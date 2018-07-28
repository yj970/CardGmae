package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class UnfairTreatmentCard extends MagicCard {
    @Override
    public int getCardCode() {
        return 7;
    }

    @Override
    public String getDescribe() {
        return "对手随机丢弃一张手牌";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.throwCard();
    }

    @Override
    public String getName() {
        return "不公平对待";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
