package com.yj.cardgame.card;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/11.
 */

public class NullCard extends AbstractCard {
    @Override
    public int getCardCode() {
        return 0;
    }

    @Override
    public String getDescribe() {
        return "空卡，一旦卡牌被使用，就会变成空卡";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {

    }

    @Override
    public String getName() {
        return "空卡";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
