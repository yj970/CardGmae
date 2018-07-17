package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/14.
 */

public abstract class AbstractBuff {
    // 状态持有者
    private AbstractCharacter owner;
    // 持续回合
    private int holdTurn = 1;

    public abstract String getDescribe();
    public abstract void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept);

    public AbstractBuff(AbstractCharacter owner) {
        this.owner = owner;
    }

    public AbstractBuff(AbstractCharacter owner, int holdTurn) {
        this.owner = owner;
        this.holdTurn = holdTurn;
    }

    public AbstractCharacter getOwner() {
        return owner;
    }

    public abstract String getName();

    /**
     * 持续回合-1
     */
    public void reduceTurn() {
        holdTurn-=1;
        if (holdTurn <= 0) {
            holdTurn = 0;
        }
    }

    public boolean isClear() {
        return holdTurn == 0;
    }

}
