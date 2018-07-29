package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class KillAttackCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 28;
    }

    @Override
    public String getDescribe() {
        return "造成"+damage+", 若杀死敌人, 自身最大生命值+2";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        if (accepter.isDead()) {
            user.addMaxHp(2);
        }
     }

    @Override
    public String getName() {
        return "斩杀";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 2;
    }
}
