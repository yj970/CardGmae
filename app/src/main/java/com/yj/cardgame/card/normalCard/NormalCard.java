package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.card.AbstractCard;

/**
 * Created by yangjie on 2018/7/14.
 */

public abstract class NormalCard extends AbstractCard {
    public int damage = 0;// 卡牌造成的基本伤害

    public NormalCard() {
        super();
        damage = getBaseDamage();
    }

    public abstract int getBaseDamage();

    public int getDamage() {
        return damage;
    }

    public void increaseDamage(int i) {
        damage += i;
    }

    public void  decreaseDamage(int i) {
        damage -= i;
        if (damage <= 0) {
            damage = 0;
        }
    }
}
