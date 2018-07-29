package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.FranticBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class FranticCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 16;
    }

    @Override
    public String getDescribe() {
        return "伤害+3, 每回合开始损失7点生命, 持续2回合";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new FranticBuff(user, 2));
    }

    @Override
    public String getName() {
        return "发狂";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
