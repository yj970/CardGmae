package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.buff.LightKnifeBuff;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/29.
 */

public class LightKnifeCard extends EquipmentCard {
    @Override
    public int getCardCode() {
        return 20;
    }

    @Override
    public String getDescribe() {
        return "伤害+1";
    }

    @Override
    public String getName() {
        return "轻灵小刀";
    }

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        super.use(user, accepter);
        user.addState(new LightKnifeBuff(user, 9999));
    }

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public int getBuffCode() {
        return 8;
    }
}
