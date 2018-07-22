package com.yj.cardgame.buff;

import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.character.AbstractCharacter;
import com.yj.cardgame.eventbus.BuffEffectEventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yangjie on 2018/7/14.
 */

public abstract class AbstractBuff {
    // 状态被哪个view展示
    private int viewId;
    // 状态持有者
    private AbstractCharacter owner;
    // 持续回合
    private int holdTurn = 1;

    public abstract String getDescribe();
    public void use(NormalCard card, AbstractCharacter user, AbstractCharacter accept) {
        // 状态是否生效
        if(isEffect(card, user, accept)) {
            // 执行状态
            doBuff(card, user, accept);
            EventBus.getDefault().post(new BuffEffectEventbus(viewId));
        }
    }

    protected abstract void doBuff(NormalCard card, AbstractCharacter user, AbstractCharacter accept);

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

    public void addTurn() {
        holdTurn+=1;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public boolean isClear() {
        return holdTurn == 0;
    }

    public abstract boolean isEffect(NormalCard card, AbstractCharacter user, AbstractCharacter accept);
}
