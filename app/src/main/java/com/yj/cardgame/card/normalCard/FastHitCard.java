package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class FastHitCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 3;
    }

    @Override
    public String getDescribe() {
        return "对敌人造成"+damage+"点伤害，自己额外抽1张卡牌";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        user.drawCard();
    }

    @Override
    public String getName() {
        return "迅捷打击";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 1;
    }
}
