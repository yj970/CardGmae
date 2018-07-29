package com.yj.cardgame.card.equipmentCard;

import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.character.AbstractCharacter;

/**
 * Created by yangjie on 2018/7/11.
 */
public abstract class EquipmentCard extends AbstractCard {
    public EquipmentCard() {
        super();
    }

    public abstract int getBuffCode();

    @Override
    public void use(AbstractCharacter user, AbstractCharacter accepter) {
        user.addEquipment(this);
    }
}
