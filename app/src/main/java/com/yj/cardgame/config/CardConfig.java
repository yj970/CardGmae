package com.yj.cardgame.config;

import com.yj.cardgame.card.magicCard.GodHandCard;
import com.yj.cardgame.card.magicCard.UnfairTreatmentCard;
import com.yj.cardgame.card.normalCard.AttackCard;
import com.yj.cardgame.card.normalCard.ChaosHitCard;
import com.yj.cardgame.card.normalCard.FastHitCard;
import com.yj.cardgame.card.normalCard.HammerHitCard;
import com.yj.cardgame.card.normalCard.MultipleHitCard;
import com.yj.cardgame.card.trapCard.PerfectCubeCard;
import com.yj.cardgame.card.trapCard.ReflexCard;

import java.util.HashMap;

/**
 * Created by yangjie on 2018/7/14.
 */

public class CardConfig {

    // 配置卡牌
    static HashMap<Integer, Class> cardMap = new HashMap<>();

    static {
        cardMap.put(1, AttackCard.class);
        cardMap.put(2, ChaosHitCard.class);
        cardMap.put(3, FastHitCard.class);
        cardMap.put(4, HammerHitCard.class);
        cardMap.put(5, MultipleHitCard.class);
        cardMap.put(6, GodHandCard.class);
        cardMap.put(7, UnfairTreatmentCard.class);
        cardMap.put(8, PerfectCubeCard.class);
        cardMap.put(8, ReflexCard.class);
    }

    public static Class getCardClass(int cardCode) {
        return cardMap.get(cardCode);
    }

}
