package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/11.
 *
 */
public class AttackCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 1;
    }

    @Override
    public String getDescribe() {
        return "对敌人造成"+damage+"点伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
    }

    @Override
    public String getName() {
        return "攻击卡";
    }


    @Override
    public int getBaseDamage() {
        return 3;
    }
}
