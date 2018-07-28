package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.ReflexBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class ReflexCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 9;
    }

    @Override
    public String getDescribe() {
        return "对敌人造成等额的伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new ReflexBuff(user));
    }

    @Override
    public String getName() {
        return "镜像反射";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
