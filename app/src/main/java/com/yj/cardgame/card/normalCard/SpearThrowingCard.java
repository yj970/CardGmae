package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.buff.FragileBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class SpearThrowingCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 21;
    }

    @Override
    public String getDescribe() {
        return "造成"+damage+"点伤害, 给予敌人1层脆弱";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        accepter.addState(new FragileBuff(accepter));
    }

    @Override
    public String getName() {
        return "掷矛";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 1;
    }
}
