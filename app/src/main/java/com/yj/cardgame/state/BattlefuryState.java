package com.yj.cardgame.state;

import com.yj.cardgame.card.normalCard.AttackCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class BattlefuryState extends AbstractState {

    public BattlefuryState(AbstractCharacter owner) {
        super(owner);
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
