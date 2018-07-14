package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class FastHitCard extends NormalCard {
    @Override
    public String getDescribe() {
        return "对敌人造成1点伤害，自己额外抽1张卡牌";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(1);
        user.drawCard();
    }

    @Override
    public String getName() {
        return "迅捷打击";
    }
}
