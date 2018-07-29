package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class AddArmorCard extends MagicCard {
    @Override
    public int getCardCode() {
        return 14;
    }

    @Override
    public String getDescribe() {
        return "增加3点护盾";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addArmor(3);
    }

    @Override
    public String getName() {
        return "架盾";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
