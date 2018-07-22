package com.yj.cardgame.character;

import com.yj.cardgame.R;

import java.util.List;

/**
 * Created by yangjie on 2018/7/22.
 */

public class PigPigMonster extends Monster{
    @Override
    public String getName() {
        return "漂漂猪";
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
    public int getMaxEquipmentNum() {
        return 4;
    }

    @Override
    public void setCardGroupIndex(List<Integer> cardGroupList) {
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(12);
        cardGroupList.add(2);
        cardGroupList.add(3);
        cardGroupList.add(5);
        cardGroupList.add(11);
    }

    @Override
    public int getImageId() {
        return R.mipmap.monster_1;
    }
}
