package com.yj.cardgame;

import com.yj.cardgame.character.Monster;
import com.yj.cardgame.character.Player;
import com.yj.cardgame.checkPoint.AbstractCheckPoint;
import com.yj.cardgame.checkPoint.PigCheckPoint;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangjie on 2018/7/12.
 */

public class Game {
    public static Monster monster ;
    public static Player player;

    public static void destroy() {
        monster = null;
        player = null;
    }

//    public static void start() {
//        monster = new PigPigMonster();
//        player = new Player();
//    }

    static Set<AbstractCheckPoint> set = new HashSet<>();

    public static void start() {
        // 初始化游戏相关配置，角色，卡牌，关卡等
        player = new Player();
        setCheckPoint();
    }

    // 关卡集合
    private static void setCheckPoint() {
        set.clear();
        set.add(new PigCheckPoint());
        set.add(new PigCheckPoint());
        set.add(new PigCheckPoint());
        set.add(new PigCheckPoint());
    }

    // 从关卡集合，获取关卡
    public static AbstractCheckPoint getCheckPoint() {
        if (set.size() > 0) {
            AbstractCheckPoint point = set.iterator().next();
            set.remove(point);
            return point;
        } else {
            return null;
        }
    }
}
