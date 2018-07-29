package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class LightKnifeBuff extends AbstractBuff {

    public LightKnifeBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getDescribe() {
        return "伤害+1";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.increaseDamage(1);
    }

    @Override
    public String getName() {
        return "轻灵";
    }

    @Override
    public int getBuffCode() {
        return 8;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return user == getOwner();
    }
}
