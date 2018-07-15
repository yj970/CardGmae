package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.character.AbstractCharacter;
import com.yj.cardgame.state.BattlefuryState;

/**
 * Created by yangjie on 2018/7/14.
 */

public class BattlefuryEquipmentCard extends EquipmentCard {
    @Override
    public int getCardCode() {
        return 10;
    }

    @Override
    public String getDescribe() {
        return "每使用1次【攻击卡】，抽1张卡";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addEquipment(this);
        user.addState(new BattlefuryState(user));
    }

    @Override
    public String getName() {
        return "狂战斧";
    }
}
