package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class GodArmorAttack extends NormalCard {
    @Override
    public int getCardCode() {
        return 19;
    }

    @Override
    public String getDescribe() {
        return "造成自身护盾x2的伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(user.getArmor()*2);
    }

    @Override
    public String getName() {
        return "神盾怒击";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }
}
