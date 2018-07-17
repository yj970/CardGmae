package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/17.
 */

public class TempNormalCard extends NormalCard{
    @Override
    public int getCardCode() {
        return -1;
    }

    @Override
    public String getDescribe() {
        return "临时普通卡，无实际意义";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {

    }

    @Override
    public String getName() {
        return "临时普通卡";
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }
}
