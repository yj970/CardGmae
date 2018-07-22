package com.yj.cardgame.eventbus;

import com.yj.cardgame.character.AbstractCharacter;
import com.yj.cardgame.character.Player;

/**
 * Created by yangjie on 2018/7/22.
 */

public class BaseEventbus {
    AbstractCharacter character;

    public BaseEventbus(AbstractCharacter character) {
        this.character = character;
    }

    public boolean isPlayer() {
        return  character instanceof Player;
    }
}
