package com.yj.cardgame.state;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public abstract class AbstractState {
    private AbstractCharacter owner;
    public abstract String getDescribe();
    public abstract void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept);

    public AbstractState(AbstractCharacter owner) {
        this.owner = owner;
    }

    public AbstractCharacter getOwner() {
        return owner;
    }
}
