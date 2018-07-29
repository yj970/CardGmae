package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.buff.WeakBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class PunishmentHammerCard extends NormalCard {
    @Override
    public int getCardCode() {
        return 26;
    }

    @Override
    public String getDescribe() {
        return "造成"+damage+"点伤害, 给予敌人虚弱2回合";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(damage);
        accepter.addState(new WeakBuff(accepter, 2));
    }

    @Override
    public String getName() {
        return "罚罪之锤";
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 2;
    }
}
