package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class WarriorSpiritBuff extends AbstractBuff {

    public WarriorSpiritBuff(AbstractCharacter owner) {
        super(owner);
    }

    @Override
    public String getDescribe() {
        return "伤害+10";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.increaseDamage(10);
    }

    @Override
    public String getName() {
        return "战士之魂";
    }

    @Override
    public int getBuffCode() {
        return 11;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return getOwner() == user;
    }
}
