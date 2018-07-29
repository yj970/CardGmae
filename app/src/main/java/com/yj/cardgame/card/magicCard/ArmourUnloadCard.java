package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class ArmourUnloadCard extends MagicCard {
    @Override
    public int getCardCode() {
        return 25;
    }

    @Override
    public String getDescribe() {
        return "护甲变为0, 抽3张牌";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.setArmor(0);
        user.drawCard(3);
    }

    @Override
    public String getName() {
        return "卸甲";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
