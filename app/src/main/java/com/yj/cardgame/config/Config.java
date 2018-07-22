package com.yj.cardgame.config;

import android.util.Log;

import com.yj.cardgame.buff.BattlefuryBuff;
import com.yj.cardgame.buff.OrcShieldBuff;
import com.yj.cardgame.buff.PerfectCubeBuff;
import com.yj.cardgame.buff.ReflexBuff;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.card.equipmentCard.BattlefuryEquipmentCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.equipmentCard.OrcShieldCard;
import com.yj.cardgame.card.magicCard.DisarmCard;
import com.yj.cardgame.card.magicCard.GodHandCard;
import com.yj.cardgame.card.magicCard.MagicCard;
import com.yj.cardgame.card.magicCard.UnfairTreatmentCard;
import com.yj.cardgame.card.normalCard.AttackCard;
import com.yj.cardgame.card.normalCard.ChaosHitCard;
import com.yj.cardgame.card.normalCard.FastHitCard;
import com.yj.cardgame.card.normalCard.HammerHitCard;
import com.yj.cardgame.card.normalCard.MultipleHitCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.PigAttack;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.card.trapCard.PerfectCubeCard;
import com.yj.cardgame.card.trapCard.ReflexCard;
import com.yj.cardgame.card.trapCard.TarpCard;

import java.util.HashMap;

/**
 * Created by yangjie on 2018/7/14.
 */

public class Config {

    // 配置卡牌
    static HashMap<Integer, Class> cardMap = new HashMap<>();
    // 配置buff
    static HashMap<Integer, Class> buffMap = new HashMap<>();

    static {
        cardMap.put(-1, TempNormalCard.class);
        cardMap.put(0, NullCard.class);
        cardMap.put(1, AttackCard.class);
        cardMap.put(2, ChaosHitCard.class);
        cardMap.put(3, FastHitCard.class);
        cardMap.put(4, HammerHitCard.class);
        cardMap.put(5, MultipleHitCard.class);
        cardMap.put(6, GodHandCard.class);
        cardMap.put(7, UnfairTreatmentCard.class);
        cardMap.put(8, PerfectCubeCard.class);
        cardMap.put(9, ReflexCard.class);
        cardMap.put(10, BattlefuryEquipmentCard.class);
        cardMap.put(11, OrcShieldCard.class);
        cardMap.put(12, PigAttack.class);
        cardMap.put(13, DisarmCard.class);

        // buff
        buffMap.put(1, BattlefuryBuff.class);
        buffMap.put(2, OrcShieldBuff.class);
        buffMap.put(3, PerfectCubeBuff.class);
        buffMap.put(4, ReflexBuff.class);



        // test 输出卡牌名字和效果
        for (int i =-1; i<cardMap.size()-1;i++) {
            String type = null;
            try {
                if (cardMap.get(i).newInstance() instanceof NormalCard) {
                    type = "普通卡";
                } else if(cardMap.get(i).newInstance() instanceof MagicCard) {
                   type = "魔法卡";
                } else if (cardMap.get(i).newInstance() instanceof TarpCard) {
                    type = "陷阱卡";
                } else if (cardMap.get(i).newInstance() instanceof EquipmentCard) {
                    type = "装备卡";
                } else if (cardMap.get(i).newInstance() instanceof NullCard) {
                    type = "空卡";
                }

                Log.d("MyTAG", type+" "+((AbstractCard)cardMap.get(i).newInstance()).getName()+" :"+ ((AbstractCard)cardMap.get(i).newInstance()).getDescribe());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Class getCardClass(int cardCode) {
        return cardMap.get(cardCode);
    }

}