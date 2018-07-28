package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/23.
 */

public class NullEquipment extends EquipmentCard{
    @Override
    public int getBuffCode() {
        return 0;
    }

    @Override
    public int getCardCode() {
        return 0;
    }

    @Override
    public String getDescribe() {
        return null;
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {

    }

    @Override
    public String getName() {
        return "空装备牌";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
