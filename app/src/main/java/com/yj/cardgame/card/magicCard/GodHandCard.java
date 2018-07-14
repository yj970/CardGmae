package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class GodHandCard extends MagicCard {
    @Override
    public String getDescribe() {
        return "自己额外抽2张卡";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.drawCard();
        user.drawCard();
    }

    @Override
    public String getName() {
        return "神来之手";
    }
}
