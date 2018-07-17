package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.character.AbstractCharacter;
import com.yj.cardgame.buff.OrcShieldBuff;

/**
 * Created by yangjie on 2018/7/14.
 */

public class OrcShieldCard extends EquipmentCard {
    @Override
    public int getCardCode() {
        return 11;
    }

    @Override
    public String getDescribe() {
        return "抵挡2点伤害";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addEquipment(this);
        user.addState(new OrcShieldBuff(user, 9999));
    }

    @Override
    public String getName() {
        return "兽人盾";
    }
}
