package com.yj.cardgame.checkPoint;

import com.yj.cardgame.R;
import com.yj.cardgame.character.Monster;
import com.yj.cardgame.character.PigPigMonster;

/**
 * Created by yangjie on 2018/7/27.
 */

public class PigCheckPoint extends MonsterCheckPoint{
    @Override
    public int getResourId() {
        return R.mipmap.monster_1;
    }

    @Override
    public String getName() {
        return "猪猪";
    }

    @Override
    public Monster getMonster() {
        return new PigPigMonster();
    }
}
