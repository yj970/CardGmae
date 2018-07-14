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
        return 30;
    }

    @Override
    public int getMaxCardNum() {
        return 4;
    }

    @Override
    public void setCardGroupIndex(List<Integer> cardGroupList) {
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(1);
        cardGroupList.add(2);
        cardGroupList.add(3);
        cardGroupList.add(4);
        cardGroupList.add(5);
    }
}