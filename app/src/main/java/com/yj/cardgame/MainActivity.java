package com.yj.cardgame;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.character.Monster;
import com.yj.cardgame.character.Player;
import com.yj.cardgame.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnTouchListener {

    @BindView(R.id.monster_name)
    TextView monster_name;
    @BindView(R.id.player_name)
    TextView player_name;
    @BindView(R.id.monster_hp)
    TextView monster_hp;
    @BindView(R.id.player_hp)
    TextView player_hp;
    @BindView(R.id.monster_card_1)
    Button monster_card_1;
    @BindView(R.id.monster_card_2)
    Button monster_card_2;
    @BindView(R.id.monster_card_3)
    Button monster_card_3;
    @BindView(R.id.monster_card_4)
    Button monster_card_4;
    @BindView(R.id.player_card_1)
    Button player_card_1;
    @BindView(R.id.player_card_2)
    Button player_card_2;
    @BindView(R.id.player_card_3)
    Button player_card_3;
    @BindView(R.id.player_card_4)
    Button player_card_4;
    @BindView(R.id.end)
    Button end;
    @BindView(R.id.monster_card_group)
    TextView monsterCardGroup;
    @BindView(R.id.player_card_group)
    TextView playerCardGroup;
    @BindView(R.id.tv_card_describe)
    TextView tvCardDescribe;

    Monster monster;
    Player player;

    @BindView(R.id.player_equipment_1)
    TextView playerEquipment1;
    @BindView(R.id.player_equipment_2)
    TextView playerEquipment2;
    @BindView(R.id.player_equipment_3)
    TextView playerEquipment3;
    @BindView(R.id.player_equipment_4)
    TextView playerEquipment4;
    @BindView(R.id.monster_equipment_1)
    TextView monsterEquipment1;
    @BindView(R.id.monster_equipment_2)
    TextView monsterEquipment2;
    @BindView(R.id.monster_equipment_3)
    TextView monsterEquipment3;
    @BindView(R.id.monster_equipment_4)
    TextView monsterEquipment4;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.player_buff_1)
    TextView playerBuff1;
    @BindView(R.id.player_buff_2)
    TextView playerBuff2;
    @BindView(R.id.player_buff_3)
    TextView playerBuff3;
    @BindView(R.id.player_buff_4)
    TextView playerBuff4;
    @BindView(R.id.player_buff_5)
    TextView playerBuff5;
    @BindView(R.id.player_buff_6)
    TextView playerBuff6;
    @BindView(R.id.player_buff_7)
    TextView playerBuff7;
    @BindView(R.id.player_buff_8)
    TextView playerBuff8;
    @BindView(R.id.monster_buff_1)
    TextView monsterBuff1;
    @BindView(R.id.monster_buff_2)
    TextView monsterBuff2;
    @BindView(R.id.monster_buff_3)
    TextView monsterBuff3;
    @BindView(R.id.monster_buff_4)
    TextView monsterBuff4;
    @BindView(R.id.monster_buff_5)
    TextView monsterBuff5;
    @BindView(R.id.monster_buff_6)
    TextView monsterBuff6;
    @BindView(R.id.monster_buff_7)
    TextView monsterBuff7;
    @BindView(R.id.monster_buff_8)
    TextView monsterBuff8;

    
    List<Button> playerCards;
    List<Button> monsterCards;
    List<TextView> playerEquipments;
    List<TextView> monsterEquipments;
    List<TextView> playerBuffs;
    List<TextView> monsterBuffs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        playerCards = new ArrayList<>(4);
        playerCards.add(player_card_1);
        playerCards.add(player_card_2);
        playerCards.add(player_card_3);
        playerCards.add(player_card_4);

        monsterCards = new ArrayList<>(4);
        monsterCards.add(monster_card_1);
        monsterCards.add(monster_card_2);
        monsterCards.add(monster_card_3);
        monsterCards.add(monster_card_4);

        playerEquipments = new ArrayList<>(4);
        playerEquipments.add(playerEquipment1);
        playerEquipments.add(playerEquipment2);
        playerEquipments.add(playerEquipment3);
        playerEquipments.add(playerEquipment4);

        monsterEquipments = new ArrayList<>(4);
        monsterEquipments.add(monsterEquipment1);
        monsterEquipments.add(monsterEquipment2);
        monsterEquipments.add(monsterEquipment3);
        monsterEquipments.add(monsterEquipment4);

        playerBuffs = new ArrayList<>(8);
        playerBuffs.add(playerBuff1);
        playerBuffs.add(playerBuff2);
        playerBuffs.add(playerBuff3);
        playerBuffs.add(playerBuff4);
        playerBuffs.add(playerBuff5);
        playerBuffs.add(playerBuff6);
        playerBuffs.add(playerBuff7);
        playerBuffs.add(playerBuff8);

        monsterBuffs = new ArrayList<>(8);
        monsterBuffs.add(monsterBuff1);
        monsterBuffs.add(monsterBuff2);
        monsterBuffs.add(monsterBuff3);
        monsterBuffs.add(monsterBuff4);
        monsterBuffs.add(monsterBuff5);
        monsterBuffs.add(monsterBuff6);
        monsterBuffs.add(monsterBuff7);
        monsterBuffs.add(monsterBuff8);



        for (int i = 0; i< playerCards.size(); i++) {
            playerCards.get(i).setOnLongClickListener(this);
            playerCards.get(i).setOnTouchListener(this);
        }

        for (int i = 0; i< monsterCards.size(); i++) {
            monsterCards.get(i).setOnLongClickListener(this);
            monsterCards.get(i).setOnTouchListener(this);
        }


        for (int i = 0; i < monsterEquipments.size(); i++) {
            monsterEquipments.get(i).setOnLongClickListener(this);
            monsterEquipments.get(i).setOnTouchListener(this);
        }

        for (int i = 0; i < playerEquipments.size(); i++) {
            playerEquipments.get(i).setOnLongClickListener(this);
            playerEquipments.get(i).setOnTouchListener(this);
        }

        for (int i = 0; i < monsterBuffs.size(); i++) {
            monsterBuffs.get(i).setOnLongClickListener(this);
            monsterBuffs.get(i).setOnTouchListener(this);
        }

        for (int i = 0; i < playerBuffs.size(); i++) {
            playerBuffs.get(i).setOnLongClickListener(this);
            playerBuffs.get(i).setOnTouchListener(this);
        }



        Game.start();

        monster = Game.monster;
        player = Game.player;

        playerTurn();

    }

    private void update() {
        // update View
        monster_name.setText(monster.getName());
        player_name.setText(player.getName());
        monsterCardGroup.setText("剩余卡牌" + monster.getCardGroupNum() + "张");
        playerCardGroup.setText("剩余卡牌" + player.getCardGroupNum() + "张");

        for (int i = 0; i < monsterCards.size(); i++) {
            monsterCards.get(i).setText(monster.getCards()[i].getName());
            monsterCards.get(i).setVisibility(monster.getCards()[i] instanceof NullCard ? View.GONE : View.VISIBLE);
            monsterCards.get(i).setTag(monster.getCards()[i].getDescribe());
        }

        for (int i = 0; i < playerCards.size(); i++) {
            playerCards.get(i).setText(player.getCards()[i].getName());
            playerCards.get(i).setVisibility(player.getCards()[i] instanceof NullCard ? View.GONE : View.VISIBLE);
            playerCards.get(i).setTag(player.getCards()[i].getDescribe());
        }

        for (int i = 0; i < monsterEquipments.size(); i++) {
            monsterEquipments.get(i).setText(monster.getEquipment(i).getName());
            monsterEquipments.get(i).setVisibility(monster.getEquipment(i) instanceof NullCard ? View.GONE : View.VISIBLE);
            monsterEquipments.get(i).setTag(monster.getEquipment(i).getDescribe());
        }

        for (int i = 0; i < playerEquipments.size(); i++) {
            playerEquipments.get(i).setText(player.getEquipment(i).getName());
            playerEquipments.get(i).setVisibility(player.getEquipment(i) instanceof NullCard ? View.GONE : View.VISIBLE);
            playerEquipments.get(i).setTag(player.getEquipment(i).getDescribe());
        }

        for (int i = 0; i < monsterBuffs.size(); i++) {
            monsterBuffs.get(i).setText(monster.getStates(i) == null ? "" : monster.getStates(i).getName());
            monsterBuffs.get(i).setVisibility(monster.getStates(i) == null ? View.GONE : View.VISIBLE);
            monsterBuffs.get(i).setTag(monster.getStates(i) == null? "" : monster.getStates(i).getDescribe());
        }

        for (int i = 0; i < playerBuffs.size(); i++) {
            playerBuffs.get(i).setText(player.getStates(i) == null ? "" : player.getStates(i).getName());
            playerBuffs.get(i).setVisibility(player.getStates(i) == null ? View.GONE : View.VISIBLE);
            playerBuffs.get(i).setTag(player.getStates(i) == null? "" : player.getStates(i).getDescribe());
        }
        


        monster_hp.setText("hp:" + monster.getHp() + "/" + monster.getMaxHp());
        player_hp.setText("hp:" + player.getHp() + "/" + player.getMaxHp());

        // 判断是否结束
        if (isGameOver()) {
            String winner;
            if (player.isDead()) {
                winner = monster.getName();
            } else {
                winner = player.getName();
            }
            new AlertDialog.Builder(this).setMessage("游戏结束!, 胜利者是" + winner).create().show();
        }
    }

    @OnClick({R.id.monster_card_2, R.id.monster_card_3, R.id.player_card_2, R.id.player_card_3, R.id.player_card_1, R.id.player_card_4, R.id.monster_card_1, R.id.monster_card_4, R.id.end})
    public void onViewClicked(View view) {
        if (isGameOver()) {
            ToastUtil.show("游戏已经结束啦~退出APP后重新进入可以再次开启游戏~");
            return;
        }

        switch (view.getId()) {
            case R.id.monster_card_1:
                monster.useCard(0);
                update();
                break;
            case R.id.monster_card_2:
                monster.useCard(1);
                update();
                break;
            case R.id.monster_card_3:
                monster.useCard(2);
                update();
                break;
            case R.id.monster_card_4:
                monster.useCard(3);
                update();
                break;
            case R.id.player_card_1:
                player.useCard(0);
                update();
                break;
            case R.id.player_card_2:
                player.useCard(1);
                update();
                break;
            case R.id.player_card_3:
                player.useCard(2);
                update();
                break;
            case R.id.player_card_4:
                player.useCard(3);
                update();
                break;
            case R.id.end:
                monsterTurn();
                break;
        }
    }

    private void monsterTurn() {
        monster.startTurn();
        // 玩家卡牌不可点击(舍弃)
        player.throwAllCard();
        // 结束回合按钮不可点击
        end.setAlpha(0.5f);
        end.setClickable(false);
        // 玩家补充卡牌
        monster.drawCard(4);

        update();
        // 怪兽自动使用卡牌（按顺序使用）
        if (!isGameOver()) {
            // performClick必须在UI线程执行，直接通过code执行的并不是在UI线程
            monster_card_1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    monster_card_1.performClick();
                }
            }, 100);
        }
        if (!isGameOver()) {
            monster_card_2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    monster_card_2.performClick();
                }
            }, 200);
        }
        if (!isGameOver()) {
            monster_card_3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    monster_card_3.performClick();
                }
            }, 300);
        }
        if (!isGameOver()) {
            monster_card_4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    monster_card_4.performClick();
                }
            }, 400);
        }
        // 玩家回合
        playerTurn();
    }

    private void playerTurn() {
        player.startTurn();
        // 怪兽卡牌不可点击(舍弃)
        monster_card_1.setVisibility(View.GONE);
        monster_card_2.setVisibility(View.GONE);
        monster_card_3.setVisibility(View.GONE);
        monster_card_4.setVisibility(View.GONE);
        // 结束回合按钮可以点击
        end.setAlpha(1f);
        end.setClickable(true);
        // 玩家补充卡牌
        player.drawCard(4);
        update();
    }

    public boolean isGameOver() {
        return monster.isDead() || player.isDead();
    }

    @Override
    public boolean onLongClick(View v) {
        String describe = (String) v.getTag();
        tvCardDescribe.setText(describe);
        tvCardDescribe.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            tvCardDescribe.setVisibility(View.GONE);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Game.destroy();
    }
}
