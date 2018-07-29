package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class FranticBuff extends AbstractBuff {
    public FranticBuff(AbstractCharacter owner) {
        super(owner);
    }

    public FranticBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getDescribe() {
        return "伤害+3, 每回合开始损失7点生命";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        // 每回合开始
        if (card instanceof TempNormalCard) {
            user.reduceHp(7);
        } else {
            card.increaseDamage(3);
        }
    }

    @Override
    public String getName() {
        return "发狂";
    }

    @Override
    public int getBuffCode() {
        return 6;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return getOwner() == user;
    }
}
