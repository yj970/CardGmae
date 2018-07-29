package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class WeakBuff extends AbstractBuff {

    public WeakBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getDescribe() {
        return "伤害-1";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.decreaseDamage(1);
    }

    @Override
    public String getName() {
        return "虚弱";
    }

    @Override
    public int getBuffCode() {
        return 13;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return getOwner() == user;
    }
}
