package com.yj.cardgame.eventbus;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/22.
 */

public class DamageEventbus extends BaseEventbus {
    int damage;// 伤害

    public DamageEventbus(int damage, AbstractCharacter character) {
        super(character);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
