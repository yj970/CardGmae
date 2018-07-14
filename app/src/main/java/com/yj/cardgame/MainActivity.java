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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        player_card_1.setOnLongClickListener(this);
        player_card_2.setOnLongClickListener(this);
        player_card_3.setOnLongClickListener(this);
        player_card_4.setOnLongClickListener(this);

        player_card_1.setOnTouchListener(this);
        player_card_2.setOnTouchListener(this);
        player_card_3.setOnTouchListener(this);
        player_card_4.setOnTouchListener(this);


        Game.start();

        monster = Game.monster;
        player = Game.player;

        playerTurn();

    }

    private void update() {
        // update View
        monster_name.setText(monster.getName());
        player_name.setText(player.getName());
        monsterCardGroup.setText("剩余卡牌"+monster.getCardGroupNum() + "张");
        playerCardGroup.setText("剩余卡牌"+player.getCardGroupNum() + "张");


        monster_card_1.setText(monster.getCards()[0].getName());
        monster_card_2.setText(monster.getCards()[1].getName());
        monster_card_3.setText(monster.getCards()[2].getName());
        monster_card_4.setText(monster.getCards()[3].getName());
        player_card_1.setText(player.getCards()[0].getName());
        player_card_2.setText(player.getCards()[1].getName());
        player_card_3.setText(player.getCards()[2].getName());
        player_card_4.setText(player.getCards()[3].getName());

        // 是否显示卡牌
        monster_card_1.setVisibility(monster.getCards()[0] instanceof NullCard ? View.GONE : View.VISIBLE);
        monster_card_2.setVisibility(monster.getCards()[1] instanceof NullCard ? View.GONE : View.VISIBLE);
        monster_card_3.setVisibility(monster.getCards()[2] instanceof NullCard ? View.GONE : View.VISIBLE);
        monster_card_4.setVisibility(monster.getCards()[3] instanceof NullCard ? View.GONE : View.VISIBLE);
        player_card_1.setVisibility(player.getCards()[0] instanceof NullCard ? View.GONE : View.VISIBLE);
        player_card_2.setVisibility(player.getCards()[1] instanceof NullCard ? View.GONE : View.VISIBLE);
        player_card_3.setVisibility(player.getCards()[2] instanceof NullCard ? View.GONE : View.VISIBLE);
        player_card_4.setVisibility(player.getCards()[3] instanceof NullCard ? View.GONE : View.VISIBLE);


        monster_hp.setText("hp:"+monster.getHp() + "/" + monster.getMaxHp());
        player_hp.setText("hp:"+player.getHp() + "/" + player.getMaxHp());

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
        String describe = "";
        switch (v.getId()) {
            case R.id.player_card_1:
                describe = player.getCard(0).getDescribe();
                break;
            case R.id.player_card_2:
                describe = player.getCard(1).getDescribe();
                break;
            case R.id.player_card_3:
                describe = player.getCard(2).getDescribe();
                break;
            case R.id.player_card_4:
                describe = player.getCard(3).getDescribe();
                break;
        }
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
