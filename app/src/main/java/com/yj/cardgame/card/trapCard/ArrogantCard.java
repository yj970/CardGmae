package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.StormBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class ArrogantCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 22;
    }

    @Override
    public String getDescribe() {
        return "自己获得2回合强攻，敌人获得3回合强攻";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new StormBuff(user, 2));
        accepter.addState(new StormBuff(accepter, 3));
    }

    @Override
    public String getName() {
        return "傲慢";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
