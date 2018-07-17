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
    public String getDescribe() {
        return "每使用1次【攻击卡】，抽1张卡";
    }

    @Override
    public void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        if (getOwner() == user) {
            if (card instanceof AttackCard) {
                user.drawCard();
            }
        }
    }

}
