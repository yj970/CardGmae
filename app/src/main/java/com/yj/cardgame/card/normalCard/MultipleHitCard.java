package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class MultipleHitCard extends NormalCard {
    @Override
    public String getDescribe() {
        return "对敌人造成2次伤害，每次伤害数值为1";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(1);
        accepter.reduceHp(1);
    }

    @Override
    public String getName() {
        return "多次打击";
    }
}
