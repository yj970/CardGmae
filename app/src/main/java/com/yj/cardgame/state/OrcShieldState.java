package com.yj.cardgame.state;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public class OrcShieldState extends AbstractState{

    public OrcShieldState(AbstractCharacter owner) {
        super(owner);
    }

    @Override
    public String getDescribe() {
        return "抵挡2点伤害";
    }

    @Override
    public void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        AbstractCharacter owner = getOwner();
        if (user != owner) {
            card.decreaseDamage(2);
        }
    }
}
