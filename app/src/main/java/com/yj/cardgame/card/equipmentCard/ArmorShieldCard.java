package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.buff.ArmorShieldBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class ArmorShieldCard extends EquipmentCard {
    @Override
    public int getBuffCode() {
        return 7;
    }

    @Override
    public int getCardCode() {
        return 17;
    }

    @Override
    public String getDescribe() {
        return "每回合开始护盾+2";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        super.use(user, accepter);
        user.addState(new ArmorShieldBuff(user, 9999));
    }

    @Override
    public String getName() {
        return "狂徒之盾";
    }

    @Override
    public int getResId() {
        return 0;
    }
}
