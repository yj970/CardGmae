package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class OrcShieldBuff extends AbstractBuff {


    public OrcShieldBuff(AbstractCharacter owner) {
        super(owner);
    }

    public OrcShieldBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getName() {
        return "兽人盾";
    }

    @Override
    public int getBuffCode() {
        return 2;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return user != getOwner();
    }

    @Override
    public String getDescribe() {
        return "抵挡2点伤害";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.decreaseDamage(2);
    }
}
