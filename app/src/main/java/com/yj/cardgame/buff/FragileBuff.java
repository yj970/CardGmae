package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class FragileBuff extends AbstractBuff {

    public FragileBuff(AbstractCharacter owner) {
        super(owner);
    }

    @Override
    public String getDescribe() {
        return "受到伤害+1";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        card.increaseDamage(1);
    }

    @Override
    public String getName() {
        return "脆弱";
    }

    @Override
    public int getBuffCode() {
        return 9;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return getOwner() == accept;
    }
}
