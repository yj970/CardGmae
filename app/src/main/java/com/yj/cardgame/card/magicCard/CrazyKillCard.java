package com.yj.cardgame.card.magicCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class CrazyKillCard extends MagicCard{
    @Override
    public int getCardCode() {
        return 29;
    }

    @Override
    public String getDescribe() {
        return "造成自身最大生命值减去当前生命值的伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(user.getMaxHp()-user.getHp());
    }

    @Override
    public String getName() {
        return "嗜血杀戮";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
