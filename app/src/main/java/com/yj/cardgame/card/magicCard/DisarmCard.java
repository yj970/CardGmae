package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/23.
 */

public class DisarmCard extends MagicCard {
    @Override
    public int getCardCode() {
        return 13;
    }

    @Override
    public String getDescribe() {
        return "随机卸掉敌方1件装备";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.removeEquipment();
    }

    @Override
    public String getName() {
        return "缴械";
    }
}
