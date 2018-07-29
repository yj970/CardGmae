package com.yj.cardgame.character;

import java.util.List;

/**
 * Created by yangjie on 2018/7/11.
 */

public class Monster extends AbstractCharacter {
    @Override
    public String getName() {
        return "怪物一号";
    }

    @Override
    public int getDefaultMaxHp() {
        return 20;
    }

    @Override
    public int getMaxCardNum() {
        return 4;
    }

    @Override
    public int getMaxEquipmentNum() {
        return 4;
    }

    @Override
    public void setCardGroupIndex(List<Integer> cardGroupList) {
        cardGroupList.add(8);
        cardGroupList.add(9);
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(11);
    }

    @Override
    public int getImageId() {
        return 0;
    }
}
