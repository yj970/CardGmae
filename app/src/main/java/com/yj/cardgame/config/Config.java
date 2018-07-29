package com.yj.cardgame.config;

import android.util.Log;

import com.yj.cardgame.buff.ArmorShieldBuff;
import com.yj.cardgame.buff.BattlefuryBuff;
import com.yj.cardgame.buff.BloodthirstyBuff;
import com.yj.cardgame.buff.FragileBuff;
import com.yj.cardgame.buff.FranticBuff;
import com.yj.cardgame.buff.LightKnifeBuff;
import com.yj.cardgame.buff.OrcShieldBuff;
import com.yj.cardgame.buff.PerfectCubeBuff;
import com.yj.cardgame.buff.ReflexBuff;
import com.yj.cardgame.buff.SacrificeLifeBuff;
import com.yj.cardgame.buff.StormBuff;
import com.yj.cardgame.buff.WarriorSpiritBuff;
import com.yj.cardgame.buff.WeakBuff;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.card.equipmentCard.ArmorShieldCard;
import com.yj.cardgame.card.equipmentCard.BattlefuryEquipmentCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.equipmentCard.LightKnifeCard;
import com.yj.cardgame.card.equipmentCard.OrcShieldCard;
import com.yj.cardgame.card.magicCard.AddArmorCard;
import com.yj.cardgame.card.magicCard.ArmourUnloadCard;
import com.yj.cardgame.card.magicCard.CrazyKillCard;
import com.yj.cardgame.card.magicCard.DisarmCard;
import com.yj.cardgame.card.magicCard.GodHandCard;
import com.yj.cardgame.card.magicCard.MagicCard;
import com.yj.cardgame.card.magicCard.StrongCard;
import com.yj.cardgame.card.magicCard.UnfairTreatmentCard;
import com.yj.cardgame.card.normalCard.ArmorAttackCard;
import com.yj.cardgame.card.normalCard.AttackCard;
import com.yj.cardgame.card.normalCard.ChaosHitCard;
import com.yj.cardgame.card.normalCard.FastHitCard;
import com.yj.cardgame.card.normalCard.GodArmorAttack;
import com.yj.cardgame.card.normalCard.HammerHitCard;
import com.yj.cardgame.card.normalCard.KillAttackCard;
import com.yj.cardgame.card.normalCard.MultipleHitCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.PigAttack;
import com.yj.cardgame.card.normalCard.PunishmentHammerCard;
import com.yj.cardgame.card.normalCard.SpearThrowingCard;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.card.trapCard.ArrogantCard;
import com.yj.cardgame.card.trapCard.BloodthirstyCard;
import com.yj.cardgame.card.trapCard.FranticCard;
import com.yj.cardgame.card.trapCard.PerfectCubeCard;
import com.yj.cardgame.card.trapCard.ReflexCard;
import com.yj.cardgame.card.trapCard.SacrificeLifeCard;
import com.yj.cardgame.card.trapCard.TarpCard;
import com.yj.cardgame.card.trapCard.WarriorSpiritCard;

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
        cardMap.put(14, AddArmorCard.class);
        cardMap.put(15, BloodthirstyCard.class);
        cardMap.put(16, FranticCard.class);
        cardMap.put(17, ArmorShieldCard.class);
        cardMap.put(18, ArmorAttackCard.class);
        cardMap.put(19, GodArmorAttack.class);
        cardMap.put(20, LightKnifeCard.class);
        cardMap.put(21, SpearThrowingCard.class);
        cardMap.put(22, ArrogantCard.class);
        cardMap.put(23, WarriorSpiritCard.class);
        cardMap.put(24, SacrificeLifeCard.class);
        cardMap.put(25, ArmourUnloadCard.class);
        cardMap.put(26, PunishmentHammerCard.class);
        cardMap.put(27, StrongCard.class);
        cardMap.put(28, KillAttackCard.class);
        cardMap.put(29, CrazyKillCard.class);



        // buff
        buffMap.put(1, BattlefuryBuff.class);
        buffMap.put(2, OrcShieldBuff.class);
        buffMap.put(3, PerfectCubeBuff.class);
        buffMap.put(4, ReflexBuff.class);
        buffMap.put(5, BloodthirstyBuff.class);
        buffMap.put(6, FranticBuff.class);
        buffMap.put(7, ArmorShieldBuff.class);
        buffMap.put(8, LightKnifeBuff.class);
        buffMap.put(9, FragileBuff.class);
        buffMap.put(10, StormBuff.class);
        buffMap.put(11, WarriorSpiritBuff.class);
        buffMap.put(12, SacrificeLifeBuff.class);
        buffMap.put(13, WeakBuff.class);




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
