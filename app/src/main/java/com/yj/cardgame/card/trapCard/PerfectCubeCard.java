package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.PerfectCubeBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class PerfectCubeCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 8;
    }

    @Override
    public String getDescribe() {
        return "抵挡敌人的普通卡伤害1次";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new PerfectCubeBuff(user));

    }

    @Override
    public String getName() {
        return "完美立方体";
    }
}
