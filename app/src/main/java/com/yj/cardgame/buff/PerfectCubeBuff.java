package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/17.
 */

public class PerfectCubeBuff extends AbstractBuff {

    public PerfectCubeBuff(AbstractCharacter owner) {
        super(owner);
    }

    @Override
    public String getName() {
        return "完美立方体";
    }

    @Override
    public int getBuffCode() {
        return 3;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return  (getOwner() != user);
    }

    @Override
    public String getDescribe() {
        return "完全抵挡1回合的伤害";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.damage = 0;
    }
}
