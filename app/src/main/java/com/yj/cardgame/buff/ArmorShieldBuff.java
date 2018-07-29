package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class ArmorShieldBuff extends AbstractBuff {

    public ArmorShieldBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getDescribe() {
        return "每回合开始护盾+2";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        if (card instanceof TempNormalCard) {
            user.addArmor(2);
        }
    }

    @Override
    public String getName() {
        return "狂徒";
    }

    @Override
    public int getBuffCode() {
        return 7;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return user == getOwner();
    }
}
