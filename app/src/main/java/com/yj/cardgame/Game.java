package com.yj.cardgame;

import com.yj.cardgame.character.Monster;
import com.yj.cardgame.character.Player;

/**
 * Created by yangjie on 2018/7/12.
 */

public class Game {
    public static Monster monster ;
    public static Player player ;

    public static void destroy() {
        monster = null;
        player = null;
    }

    public static void start() {
        monster = new Monster();
        player = new Player();
    }
}
