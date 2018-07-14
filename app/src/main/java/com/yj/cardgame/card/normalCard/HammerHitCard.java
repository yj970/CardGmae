package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class HammerHitCard extends NormalCard{
    @Override
    public String getDescribe() {
        return "对敌人造成5点伤害，自己造成3点伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(5);
        user.reduceHp(3);
    }

    @Override
    public String getName() {
        return "猛锤";
    }
}
