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
    public int getMaxHp() {
        return 3000;
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
//        cardGroupList.add(1);
//        cardGroupList.add(1);
//        cardGroupList.add(1);
//        cardGroupList.add(8);
//        cardGroupList.add(9);
//        cardGroupList.add(3);
//        cardGroupList.add(4);
//        cardGroupList.add(5);
//        cardGroupList.add(10);

        cardGroupList.add(1);
        cardGroupList.add(8);
        cardGroupList.add(6);
        cardGroupList.add(10);
    }
}
