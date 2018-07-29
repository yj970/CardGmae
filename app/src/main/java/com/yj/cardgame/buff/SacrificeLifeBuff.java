package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class SacrificeLifeBuff extends AbstractBuff{
    int damage = 0;
    public SacrificeLifeBuff(AbstractCharacter owner, int holdTurn, int damage) {
        super(owner, holdTurn);
        this.damage = damage;
    }

    @Override
    public String getDescribe() {
        return "伤害+"+damage;
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.increaseDamage(damage);
    }

    @Override
    public String getName() {
        return "舍命";
    }

    @Override
    public int getBuffCode() {
        return 12;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return getOwner() == user;
    }
}
