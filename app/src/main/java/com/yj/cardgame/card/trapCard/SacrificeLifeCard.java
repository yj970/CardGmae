package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.SacrificeLifeBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class SacrificeLifeCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 24;
    }

    @Override
    public String getDescribe() {
        return "舍弃所有手牌，增加自身伤害，伤害值为舍弃手牌数";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new SacrificeLifeBuff(user, 2, user.getUsableCardNum()));
        user.throwAllCard();
    }

    @Override
    public String getName() {
        return "孤注一掷";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
