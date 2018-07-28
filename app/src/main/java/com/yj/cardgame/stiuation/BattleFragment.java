package com.yj.cardgame.stiuation;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yj.cardgame.Game;
import com.yj.cardgame.R;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.NullCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.equipmentCard.NullEquipment;
import com.yj.cardgame.card.magicCard.MagicCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.trapCard.TarpCard;
import com.yj.cardgame.character.Monster;
import com.yj.cardgame.character.Player;
import com.yj.cardgame.eventbus.BuffEffectEventbus;
import com.yj.cardgame.eventbus.DamageEventbus;
import com.yj.cardgame.media.MediaManager;
import com.yj.cardgame.util.DisplayMetricsUtil;
import com.yj.cardgame.util.ToastUtil;
import com.yj.cardgame.view.CardView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yangjie on 2018/7/23.
 */

public class BattleFragment extends Fragment implements View.OnLongClickListener, View.OnTouchListener {
    @BindView(R.id.monster_name)
    TextView monster_name;
    //    @BindView(R.id.player_name)
//    TextView player_name;
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
    CardView player_card_1;
    @BindView(R.id.player_card_2)
    CardView player_card_2;
    @BindView(R.id.player_card_3)
    CardView player_card_3;
    @BindView(R.id.player_card_4)
    CardView player_card_4;
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


    List<CardView> playerCards;
    List<Button> monsterCards;
    List<TextView> playerEquipments;
    List<TextView> monsterEquipments;
    List<TextView> playerBuffs;
    List<TextView> monsterBuffs;


    boolean isPlayerTurn;
    boolean isAnimationing;
    @BindView(R.id.monster_hp_damage)
    TextView monsterHpDamage;
    @BindView(R.id.player_hp_damage)
    TextView playerHpDamage;
    @BindView(R.id.monster_damage)
    ImageView monsterDamage;
    @BindView(R.id.player_damage)
    ImageView playerDamage;
    @BindView(R.id.describe)
    TextView describe;
    @BindView(R.id.c_main)
    ConstraintLayout cMain;
    @BindView(R.id.player_card_5)
    CardView player_card_5;
    @BindView(R.id.player_card_6)
    CardView player_card_6;
    @BindView(R.id.player_card_7)
    CardView player_card_7;
    @BindView(R.id.player_card_8)
    CardView player_card_8;
    @BindView(R.id.player_big_card)
    CardView bigCardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);

        // music
        MediaManager.onStart();

        playerCards = new ArrayList<>(8);
        playerCards.add(player_card_1);
        playerCards.add(player_card_2);
        playerCards.add(player_card_3);
        playerCards.add(player_card_4);
        playerCards.add(player_card_5);
        playerCards.add(player_card_6);
        playerCards.add(player_card_7);
        playerCards.add(player_card_8);

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


        for (int i = 0; i < playerCards.size(); i++) {
            playerCards.get(i).setOnLongClickListener(this);
            playerCards.get(i).setOnTouchListener(this);
        }

        for (int i = 0; i < monsterCards.size(); i++) {
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
        end.setOnTouchListener(this);

        startBatter();

    }

    public void startBatter() {
//        Game.start();

        monster = Game.monster;
        player = Game.player;

        player.reset();

        startMonsterShowAnimation(new IListener() {
            @Override
            public void onNext() {
                playerTurn();
            }
        });
    }

    // 怪物出场动画
    private void startMonsterShowAnimation(final IListener listener) {
        //
        TranslateAnimation animation = new TranslateAnimation(0, 0, -300, 0);
        animation.setDuration(1000);
        monster_name.startAnimation(animation);
        //
        monster_hp.setVisibility(View.GONE);
        cMain.setVisibility(View.GONE);
        describe.setVisibility(View.VISIBLE);
        describe.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation animation1 = new AlphaAnimation(1, 0);
                animation1.setDuration(1000);
                animation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        describe.setVisibility(View.GONE);
                        cMain.setVisibility(View.VISIBLE);
                        monster_hp.setVisibility(View.VISIBLE);
                        if (listener != null) {
                            listener.onNext();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                describe.startAnimation(animation1);
            }
        }, 1500);
    }

    public interface IListener {
        void onNext();
    }

    @Override
    public void onResume() {
        super.onResume();
        MediaManager.onRestart();
    }

    @Override
    public void onStop() {
        super.onStop();
        MediaManager.onPause();
    }

    private void update() {

        monster_name.setBackgroundResource(monster.getImageId());
        // update View
//        monster_name.setText(monster.getName());
//        player_name.setText(player.getName());
        monsterCardGroup.setText("剩卡" + monster.getCardGroupNum() + "张");
        playerCardGroup.setText("剩卡" + player.getCardGroupNum() + "张");

        for (int i = 0; i < monsterCards.size(); i++) {
            monsterCards.get(i).setText(monster.getCards()[i].getName());
            monsterCards.get(i).setVisibility(monster.getCards()[i] instanceof NullCard ? View.GONE : View.VISIBLE);
            monsterCards.get(i).setTag(monster.getCards()[i]);
            setCardBg(monsterCards.get(i));
        }


        // 手牌
        int playerCardNum = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            playerCards.get(i).setCard(player.getCards()[i]);
            playerCards.get(i).setVisibility(player.getCards()[i] instanceof NullCard ? View.GONE : View.VISIBLE);
            playerCards.get(i).setTag(player.getCards()[i]);
//            setCardBg(playerCards.get(i));
            if (!(player.getCards()[i] instanceof NullCard)) {
                playerCardNum++;
            }
        }
            for (int i = 1; i < playerCards.size(); i++) {
                ViewGroup.MarginLayoutParams params;
                params = (ViewGroup.MarginLayoutParams) playerCards.get(i).getLayoutParams();
                if (playerCardNum <= 4) {
                    params.setMargins(3 * playerCardNum, 0, 0, 0);
                } else {
                    params.setMargins(-10 * playerCardNum, 0, 0, 0);
                }
                playerCards.get(i).setLayoutParams(params);
            }
//        for (int i = 0; i < playerCardNum; i++) {
//            int size = playerCardNum;
//            playerCards.get(i).setPivotX(playerCards.get(i).getWidth()/2);
//            playerCards.get(i).setPivotY(playerCards.get(i).getHeight()-10);
//            if (i <size/2) {
//                playerCards.get(i).setRotation((i+1-size/2)*2.5f);
//            } else {
//                playerCards.get(i).setRotation((i+1-size/2)*2.5f);
//            }
//        }


        for (int i = 0; i < monsterEquipments.size(); i++) {
            monsterEquipments.get(i).setText(monster.getEquipment(i).getName());
            monsterEquipments.get(i).setVisibility(monster.getEquipment(i) instanceof NullEquipment ? View.GONE : View.VISIBLE);
            monsterEquipments.get(i).setTag(monster.getEquipment(i));
        }

        for (int i = 0; i < playerEquipments.size(); i++) {
            playerEquipments.get(i).setText(player.getEquipment(i).getName());
            playerEquipments.get(i).setVisibility(player.getEquipment(i) instanceof NullEquipment ? View.GONE : View.VISIBLE);
            playerEquipments.get(i).setTag(player.getEquipment(i));
        }

        for (int i = 0; i < monsterBuffs.size(); i++) {
            monsterBuffs.get(i).setText(monster.getStates(i) == null ? "" : monster.getStates(i).getName());
            monsterBuffs.get(i).setVisibility(monster.getStates(i) == null ? View.GONE : View.VISIBLE);
            monsterBuffs.get(i).setTag(monster.getStates(i) == null ? "" : monster.getStates(i));
        }

        for (int i = 0; i < playerBuffs.size(); i++) {
            playerBuffs.get(i).setText(player.getStates(i) == null ? "" : player.getStates(i).getName());
            playerBuffs.get(i).setVisibility(player.getStates(i) == null ? View.GONE : View.VISIBLE);
            playerBuffs.get(i).setTag(player.getStates(i) == null ? "" : player.getStates(i));
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
            //
            ((GameActivity) getActivity()).checkPoint();
        }
    }

    @OnClick({R.id.monster_card_2, R.id.monster_card_3, R.id.player_card_2, R.id.player_card_3, R.id.player_card_1, R.id.player_card_4, R.id.monster_card_1, R.id.monster_card_4, R.id.end, R.id.player_card_5,R.id.player_card_6,R.id.player_card_7,R.id.player_card_8})
    public void onViewClicked(View view) {
        if (isGameOver()) {
            ToastUtil.show("游戏已经结束啦~退出APP后重新进入可以再次开启游戏~");
            return;
        }

        switch (view.getId()) {
            case R.id.monster_card_1:
                startCardAnimate(view, false);
                monster.useCard(0);
                break;
            case R.id.monster_card_2:
                startCardAnimate(view, false);
                monster.useCard(1);
                break;
            case R.id.monster_card_3:
                startCardAnimate(view, false);
                monster.useCard(2);
                break;
            case R.id.monster_card_4:
                startCardAnimate(view, false);
                monster.useCard(3);
                break;
            case R.id.player_card_1:
                startCardAnimate(view, true);
                player.useCard(0);
                break;
            case R.id.player_card_2:
                startCardAnimate(view, true);
                player.useCard(1);
                break;
            case R.id.player_card_3:
                startCardAnimate(view, true);
                player.useCard(2);
                break;
            case R.id.player_card_4:
                startCardAnimate(view, true);
                player.useCard(3);
                break;
            case R.id.player_card_5:
                startCardAnimate(view, true);
                player.useCard(4);
                break;
            case R.id.player_card_6:
                startCardAnimate(view, true);
                player.useCard(5);
                break;
            case R.id.player_card_7:
                startCardAnimate(view, true);
                player.useCard(6);
                break;
            case R.id.player_card_8:
                startCardAnimate(view, true);
                player.useCard(7);
                break;
            case R.id.end:
                monsterTurn();
                break;
        }
    }

    private void startCardAnimate(View view, boolean isPlayer) {
        startCardAnimate(view, isPlayer, null);
    }

    private void startCardAnimate(View view, boolean isPlayer, final Listener listener) {
        float y = view.getTranslationY();
        float offsetY = isPlayer ? y - 200 : y + 200;

        TranslateAnimation animation = new TranslateAnimation(0, 0, y, offsetY);
        animation.setDuration(600);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isAnimationing = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isAnimationing = false;
                update();
                if (listener != null) {
                    listener.onAnimationEnd();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    public void setCardBg(Button card) {
        if (card.getTag() instanceof NormalCard) {
            card.setBackgroundResource(R.drawable.bg_normal_card);
        } else if (card.getTag() instanceof TarpCard) {
            card.setBackgroundResource(R.drawable.bg_tarp_card);
        } else if (card.getTag() instanceof EquipmentCard) {
            card.setBackgroundResource(R.drawable.bg_equipment_card);
        } else if (card.getTag() instanceof MagicCard) {
            card.setBackgroundResource(R.drawable.bg_magic_card);
        } else {
            card.setBackground(null);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    private interface Listener {
        void onAnimationEnd();
    }

    private void monsterTurn() {
        isPlayerTurn = false;
        monster.startTurn();
        // 玩家卡牌不可点击(舍弃)
//        player.throwAllCard();
        // 结束回合按钮不可点击
        end.setAlpha(0.5f);
        end.setClickable(false);
        // 玩家补充卡牌
        monster.drawCard(4);

        update();
        // 怪兽自动使用卡牌（按顺序使用）
        monsterAction();

    }

    private void playerTurn() {
        isPlayerTurn = true;
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
        // todo 这里处理不好，暂时这样处理，待优化
//        String describe = null;
//        try {
//            describe = ((AbstractCard) v.getTag()).getDescribe();
//        } catch (Exception e) {
//            e.printStackTrace();
//            describe = ((AbstractBuff) v.getTag()).getDescribe();
//        }
//        tvCardDescribe.setText(describe);
//        tvCardDescribe.setVisibility(View.VISIBLE);
        if (v instanceof  CardView) {
            float x = v.getX();
            if (x+bigCardView.getWidth()> DisplayMetricsUtil.getScreenWidth()) {
                x = DisplayMetricsUtil.getScreenWidth() - bigCardView.getWidth();
            }
            bigCardView.setCard((AbstractCard) v.getTag());
            bigCardView.setX(x);
            bigCardView.setY(v.getY() - bigCardView.getHeight());// todo 刚进入马上长按时，getHeight（）=0；
            bigCardView.setVisibility(View.VISIBLE);
            v.setVisibility(View.INVISIBLE);
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!isPlayerTurn || isAnimationing) {
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
//            tvCardDescribe.setVisibility(View.GONE);
            if (v instanceof CardView) {
                bigCardView.setVisibility(View.GONE);
                v.setVisibility(View.VISIBLE);
            }
        }
        return false;
    }


    private void monsterAction() {
        if (!isGameOver()) {
            startCardAnimate(monster_card_1, false, new Listener() {
                @Override
                public void onAnimationEnd() {
                    if (!isGameOver()) {
                        startCardAnimate(monster_card_2, false, new Listener() {
                            @Override
                            public void onAnimationEnd() {
                                if (!isGameOver()) {
                                    startCardAnimate(monster_card_3, false, new Listener() {
                                        @Override
                                        public void onAnimationEnd() {
                                            if (!isGameOver()) {
                                                startCardAnimate(monster_card_4, false, new Listener() {
                                                    @Override
                                                    public void onAnimationEnd() {
// 玩家回合
                                                        playerTurn();
                                                    }
                                                });
                                                monster.useCard(3);
                                            }
                                        }
                                    });
                                    monster.useCard(2);
                                }
                            }
                        });
                        monster.useCard(1);
                    }
                }
            });
            monster.useCard(0);
        }
    }

    // 角色受伤
    @Subscribe
    public void onDamage(DamageEventbus damageEventbus) {
        if (damageEventbus.isPlayer()) {
            startDamageAnimation(playerHpDamage, damageEventbus.getDamage(), playerDamage);
        } else {
            startDamageAnimation(monsterHpDamage, damageEventbus.getDamage(), monsterDamage);
        }
        MediaManager.playAttack1();
    }

    // buff生效
    @Subscribe
    public void onBuffEffect(BuffEffectEventbus buffEffectEventbus) {
        int viewId = buffEffectEventbus.getViewID();
        for (View v : monsterBuffs) {
            if (v.getId() == viewId) {
                startBuffAnimation(v);
                return;
            }
        }
        for (View v : playerBuffs) {
            if (v.getId() == viewId) {
                startBuffAnimation(v);
                return;
            }
        }
    }

    private void startBuffAnimation(View v) {
        ScaleAnimation translateAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f, v.getWidth() / 2, v.getHeight() / 2);
        translateAnimation.setDuration(500);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(translateAnimation);
    }

    private void startDamageAnimation(final TextView view, int damage, final ImageView damageView) {
        view.setText("-" + damage);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 1f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
                damageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                damageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(alphaAnimation);
        damageView.startAnimation(alphaAnimation);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Game.destroy();
        MediaManager.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    public static int getViewId(boolean isPlayer, int pisition) {
        if (isPlayer) {
            switch (pisition) {
                case 0:
                    return R.id.player_buff_1;
                case 1:
                    return R.id.player_buff_2;
                case 2:
                    return R.id.player_buff_3;
                case 3:
                    return R.id.player_buff_4;
                case 4:
                    return R.id.player_buff_5;
                case 5:
                    return R.id.player_buff_6;
                case 6:
                    return R.id.player_buff_7;
                case 7:
                    return R.id.player_buff_8;
            }
        } else {
            switch (pisition) {
                case 0:
                    return R.id.monster_buff_1;
                case 1:
                    return R.id.monster_buff_2;
                case 2:
                    return R.id.monster_buff_3;
                case 3:
                    return R.id.monster_buff_4;
                case 4:
                    return R.id.monster_buff_5;
                case 5:
                    return R.id.monster_buff_6;
                case 6:
                    return R.id.monster_buff_7;
                case 7:
                    return R.id.monster_buff_8;
            }
        }
        return -1;
    }
}
