package com.yj.cardgame.character;

import android.util.Log;

import com.yj.cardgame.Game;
import com.yj.cardgame.buff.AbstractBuff;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.normalCard.TempNormalCard;
import com.yj.cardgame.config.CardConfig;
import com.yj.cardgame.util.ToastUtil;

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
    private AbstractCard[] equipments; // 装备容器
    private AbstractCard[] cards; // 手牌组
    private AbstractCard[] nullCards;// 空牌组
    private NullCard nullCard = new NullCard();// 空牌
    private ArrayList<Integer> cardGroupIndexList = new ArrayList<>(); // 卡组索引
    private List<AbstractCard> cardGroupList = new ArrayList<>(); // 卡组
    private TempNormalCard tempNormalCard = new TempNormalCard();// 临时普通卡

    private ArrayList<AbstractBuff> buffs;// 状态

    public AbstractCharacter() {
        maxHp = getMaxHp();
        name = getName();
        maxCardNum = getMaxCardNum();
        maxEquipmentNum = getMaxEquipmentNum();
        hp = getMaxHp();
        cards = new AbstractCard[maxCardNum];

        nullCards = new AbstractCard[maxCardNum];
        for (int i = 0; i < maxCardNum; i++) {
            nullCards[i] = new NullCard();
        }
        cards = nullCards.clone();
        equipments = nullCards.clone();
        buffs = new ArrayList();
        // 设置卡组索引
        setCardGroupIndex(cardGroupIndexList);
        // 根据卡组索引，拿到对应的卡牌，添加进卡组
        buildCardGroup();
    }

    // 生成卡组（抽牌堆）
    private void buildCardGroup() {
        // 洗牌
        ArrayList<Integer> temp = (ArrayList<Integer>) cardGroupIndexList.clone();
        Collections.shuffle(temp);
        try {
            cardGroupList.clear();
            for (int i = 0; i < temp.size(); i++) {
                cardGroupList.add((AbstractCard) CardConfig.getCardClass(temp.get(i)).newInstance());
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

    public abstract int getMaxHp();

    public abstract int getMaxCardNum();

    public abstract int getMaxEquipmentNum();

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return  hp <= 0;
    }

    public void reduceHp(int num) {
        hp-=num;
        if (hp <=0) {
            hp = 0;
        }
    }

    public void addHp(int num) {
        hp+=num;
        if (hp >= maxHp) {
            hp = maxHp;
        }
    }

    public void useCard(int position) {
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
        Log.d("MyTAG", user.getName()+"使用"+usedCard.getName()+" "+accept.getName()+"剩余生命为"+accept.getHp());
    }


    public void throwAllCard() {
        this.cards = nullCards.clone();
    }

    public AbstractCard[] getCards(){
        return cards;
    }

    /**
     * 设置卡组
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
            ToastUtil.show("手牌已满，无法加入新卡牌!");
            Log.d("MyTAG", this.getName());
        }
    }

    /**
     * 随机丢弃卡
     **/
    public void throwCard() {
        Random random = new Random();
        int result = random.nextInt(maxCardNum);
        for (int i = 0; i<maxCardNum; i++) {
            if (!(cards[result] instanceof NullCard)) {
                cards[result] = nullCard;
                break;
            } else {
                if (result != maxCardNum-1) {
                    result += 1;
                } else {
                    result = 0;
                }
            }
        }
    }

    /**
     * 获取卡堆剩余卡牌数量
     * @return
     */
    public int getCardGroupNum() {
        return cardGroupList.size();
    }

    /**
     * 获得当前手牌
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
        // todo 若已有次buff，holdTurn+1
        buffs.add(state);
    }

    /**
     * 添加装备
     * @param card
     */
    public void addEquipment(EquipmentCard card) {
        boolean isAdd = false; // 是否成功加入手牌
        for (int i = 0; i < maxEquipmentNum; i++) {
            if ((equipments[i] instanceof NullCard)) {
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
        Iterator iterator =  buffs.iterator();
        while (iterator.hasNext()) {
            AbstractBuff buff = (AbstractBuff) iterator.next();
            buff.use(tempNormalCard, user, accept);
            buff.reduceTurn();
            if (buff.isClear()) {
                Log.d("MyTAG", user.getName()+"移除"+buff.getName());
                iterator.remove();
            }
        }
    }

    /**
     * 回合结束
     */
    public void endTurn() {

    }
}
