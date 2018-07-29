package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.BloodthirstyBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class BloodthirstyCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 15;
    }

    @Override
    public String getDescribe() {
        return "伤害+1，收到伤害+1，持续2回合";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new BloodthirstyBuff(user, 2));
    }

    @Override
    public String getName() {
        return "嗜血";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
