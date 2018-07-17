package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/17.
 */

public class ReflexBuff extends AbstractBuff {
    public ReflexBuff(AbstractCharacter owner) {
        super(owner);
    }

    @Override
    public String getName() {
        return "反射";
    }

    @Override
    public String getDescribe() {
        return "反射等额的伤害";
    }

    @Override
    public void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        if (getOwner() != user) {
            user.reduceHp(card.damage);
        }
    }
}
