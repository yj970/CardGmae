package com.yj.cardgame.card.trapCard;

import com.yj.cardgame.buff.WarriorSpiritBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class WarriorSpiritCard extends TarpCard {
    @Override
    public int getCardCode() {
        return 23;
    }

    @Override
    public String getDescribe() {
        return "伤害+10，hp变为1";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addState(new WarriorSpiritBuff(user));
        user.setHp(1);
    }

    @Override
    public String getName() {
        return "战士之魂";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
