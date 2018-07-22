package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.AttackCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class BattlefuryBuff extends AbstractBuff {


    public BattlefuryBuff(AbstractCharacter owner) {
        super(owner);
    }

    public BattlefuryBuff(AbstractCharacter owner, int holdTurn) {
        super(owner, holdTurn);
    }

    @Override
    public String getName() {
        return "狂战";
    }

    @Override
    public int getBuffCode() {
        return 1;
    }

    @Override
    public boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        return (getOwner() == user) && (card instanceof AttackCard);
    }

    @Override
    public String getDescribe() {
        return "每使用1次【攻击卡】，抽1张卡";
    }

    @Override
    protected void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        user.drawCard();
    }

}
