package com.yj.cardgame.card.normalCard;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/11.
 *
 */
public class AttackCard extends NormalCard {
    @Override
    public String getDescribe() {
        return "对敌人造成3点伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        accepter.reduceHp(3);
    }

    @Override
    public String getName() {
        return "攻击卡";
    }

}
