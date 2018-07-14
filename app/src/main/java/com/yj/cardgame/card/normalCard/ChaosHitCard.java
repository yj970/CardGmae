package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

import java.util.Random;

/**
 * Created by yangjie on 2018/7/14.
 */

public class ChaosHitCard extends NormalCard {
    @Override
    public String getDescribe() {
        return "随机对敌人造成伤害，数值分别为-2/-4/-6";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        Random random = new Random();
        int result =  random.nextInt(3);// 随机获取[0, 2]区间的值。
        accepter.reduceHp(result+2);
    }

    @Override
    public String getName() {
        return "混乱打击";
    }
}
