package com.yj.cardgame.card;

import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/11.
 */
public abstract class AbstractCard {

    private int cardCode;

    public AbstractCard() {
        cardCode = getCardCode();
    }

    public abstract int getCardCode();

    public abstract String getDescribe();

    public abstract void use(AbstractCharacter user, AbstractCharacter accepter);

    public abstract String getName();

}
