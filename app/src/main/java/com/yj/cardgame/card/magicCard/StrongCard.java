package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class StrongCard extends MagicCard {
    @Override
    public int getCardCode() {
        return 27;
    }

    @Override
    public String getDescribe() {
        return "护甲+5,随机丢弃1张牌";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addArmor(5);
        user.throwCard();
    }

    @Override
    public String getName() {
        return "强壮";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
