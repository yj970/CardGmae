package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class ReflexCard extends TarpCard {
    @Override
    public String getDescribe() {
        return "对敌人造成等额的伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        // TODO: 2018/7/14  
    }

    @Override
    public String getName() {
        return "镜像反射";
    }
}
