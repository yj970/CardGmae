package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/22.
 */

public class PigAttack extends NormalCard{
    @Override
    public int getCardCode() {
        return 12;
    }

    @Override
    public String getDescribe() {
        return "猪猪撞击，造成"+damage+"伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
    }

    @Override
    public String getName() {
        return "猪猪冲撞";
    }

    @Override
    public int getBaseDamage() {
        return 2;
    }
}
