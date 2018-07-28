package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class HammerHitCard extends NormalCard{
    @Override
    public int getCardCode() {
        return 4;
    }

    @Override
    public String getDescribe() {
        return "对敌人造成"+damage+"点伤害，自己造成3点伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        user.reduceHp(3);
    }

    @Override
    public String getName() {
        return "猛锤";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 5;
    }
}
