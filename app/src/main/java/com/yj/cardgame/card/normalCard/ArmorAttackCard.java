package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class ArmorAttackCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 18;
    }

    @Override
    public String getDescribe() {
        return "造成"+damage+"点伤害，增加自身1点护盾";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        user.addArmor(1);
    }

    @Override
    public String getName() {
        return "盾击";
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
