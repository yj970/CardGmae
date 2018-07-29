package com.yj.cardgame.character;

import java.util.List;

/**
 * Created by yangjie on 2018/7/11.
 */
public class Player extends AbstractCharacter {

    @Override
    public String getName() {
        return "玩家";
    }

    @Override
    public int getDefaultMaxHp() {
        return 30;
    }

    @Override
    public int getMaxCardNum() {
        return 8;
    }

    @Override
    public int getMaxEquipmentNum() {
        return 4;
    }

    @Override
    public void setCardGroupIndex(List<Integer> cardGroupList) {
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(14);
        cardGroupList.add(14);
        cardGroupList.add(14);
        cardGroupList.add(5);
        cardGroupList.add(6);
        cardGroupList.add(7);
        cardGroupList.add(8);
        cardGroupList.add(9);
        cardGroupList.add(10);
        cardGroupList.add(11);
        cardGroupList.add(12);
        cardGroupList.add(13);
        cardGroupList.add(14);
        cardGroupList.add(15);
        cardGroupList.add(16);
        cardGroupList.add(17);
        cardGroupList.add(18);
        cardGroupList.add(19);
        cardGroupList.add(20);
        cardGroupList.add(21);
        cardGroupList.add(22);
        cardGroupList.add(23);
        cardGroupList.add(24);
        cardGroupList.add(25);
        cardGroupList.add(26);
        cardGroupList.add(27);
        cardGroupList.add(28);
        cardGroupList.add(29);




    }

    @Override
    public int getImageId() {
        return 0;
    }
}
