package com.yj.cardgame.character;

import android.util.Log;

import com.yj.cardgame.MainActivity;
import com.yj.cardgame.card.equipmentCard.NullEquipment;
import com.yj.cardgame.eventbus.DamageEventbus;
import com.yj.cardgame.Game;
import com.yj.cardgame.buff.AbstractBuff;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.config.Config;
import com.yj.cardgame.util.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by yangjie on 2018/7/11.
 */
public abstract class AbstractCharacter {
    private String name;// 名字
    private int hp; // 当前血量
    private int maxHp; // 最高血量
    private int maxCardNum; // 最大手牌数
    private int maxEquipmentNum; // 最大装备牌数
    private EquipmentCard[] equipments; // 装备容器
    private EquipmentCard[] nullEquipments; // 空装备容器
    private AbstractCard[] cards; // 手牌组
    private AbstractCard[] nullCards;// 空牌组
    private NullCard nullCard = new NullCard();// 空牌
    private NullEquipment nullEquipment = new NullEquipment(); //空装备
    private ArrayList<Integer> cardGroupIndexList = new ArrayList<>(); // 卡组索引
    private List<AbstractCard> cardGroupList = new ArrayList<>(); // 卡组
    private TempNormalCard tempNormalCard = new TempNormalCard();// 临时普通卡
    private int armor = 0;// 护盾

    private ArrayList<AbstractBuff> buffs;// 状态

    public AbstractCharacter() {
        maxHp = getDefaultMaxHp();
        name = getName();
        maxCardNum = getMaxCardNum();
        maxEquipmentNum = getMaxEquipmentNum();
        hp = getDefaultMaxHp();
        cards = new AbstractCard[maxCardNum];

        nullCards = new AbstractCard[maxCardNum];
        for (int i = 0; i < maxCardNum; i++) {
            nullCards[i] = new NullCard();
        }
        nullEquipments = new EquipmentCard[maxEquipmentNum];
        for (int i = 0; i < maxEquipmentNum; i++) {
            nullEquipments[i] = new NullEquipment();
        }

        cards = nullCards.clone();
        equipments = nullEquipments.clone();
        buffs = new ArrayList();
        // 设置卡组索引
        setCardGroupIndex(cardGroupIndexList);
        // 根据卡组索引，拿到对应的卡牌，添加进卡组
        buildCardGroup();
    }

    public void reset() {
        buildCardGroup();// 洗牌（卡组）
        cards = nullCards.clone(); // 清空手牌
        equipments = nullEquipments.clone(); // 清理装备
        buffs = new ArrayList(); // 清理状态
    }

    // 生成卡组（抽牌堆）
    private void buildCardGroup() {
        // 洗牌
        ArrayList<Integer> temp = (ArrayList<Integer>) cardGroupIndexList.clone();
        Collections.shuffle(temp);
        try {
            cardGroupList.clear();
            for (int i = 0; i < temp.size(); i++) {
                cardGroupList.add((AbstractCard) Config.getCardClass(temp.get(i)).newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public abstract String getName();

    public abstract int getDefaultMaxHp();

    public abstract int getMaxCardNum();

    public abstract int getMaxEquipmentNum();

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void reduceHp(int num) {
        EventBus.getDefault().post(new DamageEventbus(num, this));
        int realDamage = num;
        if (armor != 0) {
            armor = armor - num;
            if (armor >= 0) {
                realDamage = 0;
            } else {
                realDamage = Math.abs(armor);
                armor = 0;
            }
        }
        hp -= realDamage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    public int getArmor() {
        return armor;
    }

    public void addHp(int num) {
        hp += num;
        if (hp >= maxHp) {
            hp = maxHp;
        }
    }

    public void useCard(int position) {
        if (position >= cards.length) {
            Log.d("MyTAG", "无效，超过手牌数");
            return;
        }
        AbstractCard usedCard = cards[position];
        cards[position] = nullCard;

        AbstractCharacter user;
        AbstractCharacter accept;
        if (this instanceof Player) {
            user = Game.player;
            accept = Game.monster;
        } else {
            user = Game.monster;
            accept = Game.player;
        }
        // 如果是普通牌，则进行遍历状态
        if (usedCard instanceof NormalCard) {
            // 使用者的状态
            for (AbstractBuff state : buffs) {
                state.use((NormalCard) usedCard, user, accept);
            }
            // 接收者的状态
            List<AbstractBuff> tempStates = accept.getAllStates();
            for (AbstractBuff state : tempStates) {
                state.use((NormalCard) usedCard, user, accept);
            }
        }

        // 如果是武器牌，则移除战斗
        if (usedCard instanceof EquipmentCard) {
            cardGroupIndexList.remove(new Integer(usedCard.getCardCode()));
        }
        // 使用卡牌效果
        usedCard.use(user, accept);
        // log 日记
        Log.d("MyTAG", user.getName() + "使用" + usedCard.getName() + " " + accept.getName() + "剩余生命为" + accept.getHp());
    }


    public void throwAllCard() {
        this.cards = nullCards.clone();
    }

    public AbstractCard[] getCards() {
        return cards;
    }

    /**
     * 设置卡组
     *
     * @param cardGroupList
     */
    public abstract void setCardGroupIndex(List<Integer> cardGroupList);

    public void drawCard(int num) {
        for (int i = 0; i < num; i++) {
            drawCard();
        }
    }

    /**
     * 抽卡
     */
    public void drawCard() {
        if (cardGroupList.size() == 0) {
            buildCardGroup();
        }
        AbstractCard card = cardGroupList.get(0);
        cardGroupList.remove(0);// 抽牌堆移除顶牌
        //把卡牌加入到手牌
        boolean isAdd = false; // 是否成功加入手牌
        for (int i = 0; i < maxCardNum; i++) {
            if ((cards[i] instanceof NullCard)) {
                cards[i] = card;
                isAdd = true;
                break;
            }
        }
        if (!isAdd) {
            ToastUtil.show(this.getName() + "手牌已满，无法加入新卡牌!");
            Log.d("MyTAG", this.getName());
        }
    }

    /**
     * 随机丢弃卡
     **/
    public void throwCard() {
        Random random = new Random();
        int result = random.nextInt(maxCardNum);
        for (int i = 0; i < maxCardNum; i++) {
            if (!(cards[result] instanceof NullCard)) {
                cards[result] = nullCard;
                break;
            } else {
                if (result != maxCardNum - 1) {
                    result += 1;
                } else {
                    result = 0;
                }
            }
        }
    }

    /**
     * 获取卡堆剩余卡牌数量
     *
     * @return
     */
    public int getCardGroupNum() {
        return cardGroupList.size();
    }

    /**
     * 获得当前手牌
     *
     * @param i
     * @return
     */
    public AbstractCard getCard(int i) {
        return cards[i];
    }

    /**
     * 添加状态
     */
    public void addState(AbstractBuff state) {
        // 状态持续回合+1
        for (AbstractBuff buff : buffs) {
            if (state.getName().equals(buff.getName())) {
                buff.addTurn();
                return;
            }
        }

        // 添加状态
        int size = buffs.size();
        state.setViewId(MainActivity.getViewId(this instanceof Player, size));
        buffs.add(state);
    }

    /**
     * 添加装备
     *
     * @param card
     */
    public void addEquipment(EquipmentCard card) {
        boolean isAdd = false; // 是否成功加入手牌
        for (int i = 0; i < maxEquipmentNum; i++) {
            if ((equipments[i] instanceof NullEquipment)) {
                equipments[i] = card;
                isAdd = true;
                break;
            }
        }
        if (!isAdd) {
            ToastUtil.show("装备槽已满，无法加入新装备!");
            Log.d("MyTAG", this.getName());
        }
    }

    public AbstractCard getEquipment(int i) {
        return equipments[i];
    }

    /**
     * 获取状态
     *
     * @return
     */
    public AbstractBuff getStates(int i) {
        if (buffs.size() <= i) {
            return null;
        }
        return buffs.get(i);
    }

    public List<AbstractBuff> getAllStates() {
        return buffs;
    }

    /**
     * 回合开始
     */
    public void startTurn() {
        AbstractCharacter user;
        AbstractCharacter accept;
        if (this instanceof Player) {
            user = Game.player;
            accept = Game.monster;
        } else {
            user = Game.monster;
            accept = Game.player;
        }
        // buff发动、buff持续回合全部减1
        Iterator iterator = buffs.iterator();
        while (iterator.hasNext()) {
            AbstractBuff buff = (AbstractBuff) iterator.next();
            buff.use(tempNormalCard, user, accept);
            buff.reduceTurn();
            if (buff.isClear()) {
                Log.d("MyTAG", user.getName() + "移除" + buff.getName());
                iterator.remove();
            }
        }
    }

    public abstract int getImageId();

    /**
     * 回合结束
     */
    public void endTurn() {

    }

    public void addArmor(int num) {
        armor += num;
    }

    public void reduceArmor(int num) {
        armor -= num;
        if (armor < 0) {
            armor = 0;
        }
    }

    // todo 优化？？
    public void removeEquipment() {
        int size = equipments.length;
        Random random = new Random();
        int index = random.nextInt(size);// [0, size)
        EquipmentCard equipmentCard = equipments[index];
        for (int i = 0; i < size; i++) {
            if (!(equipmentCard instanceof NullEquipment)) {
                break;
            }
            index += 1;
            if (index >= size) {
                index = 0;
            }
            equipmentCard = equipments[index];
        }

        int buffCode = equipmentCard.getBuffCode();
        equipments[index] = nullEquipment;
        // 移除buff
        for (AbstractBuff buff : buffs) {
            if (buff.getBuffCode() == buffCode) {
                buffs.remove(buff);
                return;
            }
        }
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // 获得可用手牌数
    public int getUsableCardNum() {
        int i = 0;
        for (AbstractCard card : cards) {
            if (!(card instanceof NullCard)) {
                i++;
            }
        }
        return i;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void addMaxHp(int i) {
        maxHp+=i;
        hp+=i;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
