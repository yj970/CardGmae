package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class MultipleHitCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 5;
    }

    @Override
    public String getDescribe() {
        return "对敌人造成2次伤害，每次伤害数值为"+damage;
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        accepter.reduceHp(damage);
    }

    @Override
    public String getName() {
        return "多次打击";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 1;
    }
}
