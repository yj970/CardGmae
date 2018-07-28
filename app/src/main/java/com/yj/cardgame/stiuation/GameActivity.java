package com.yj.cardgame.stiuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yj.cardgame.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjie on 2018/7/23.
 */

public class GameActivity extends FragmentActivity {

    BattleFragment battleFragment;
    CheckPointFragment checkPointFragment;
    List<Fragment> allFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        battleFragment = new BattleFragment();
        checkPointFragment = new CheckPointFragment();
        allFragment.add(battleFragment);
        allFragment.add(checkPointFragment);

        // test
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.game, new MonsterFragment());
//        transaction.commitAllowingStateLoss();

        show(1);
    }

    private void show(int i) {
        hideAll();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!allFragment.get(i).isAdded()) {
            transaction.add(R.id.game, allFragment.get(i));
        }
        switch (i) {
            case 0:
                transaction.show(allFragment.get(0));
                if (allFragment.get(0).isAdded()) {
                    ((BattleFragment) allFragment.get(0)).startBatter();
                }
                break;
            case 1:
                transaction.show(allFragment.get(1));
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideAll() {
        for (Fragment fragment : allFragment) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(fragment);
            transaction.commitAllowingStateLoss();
        }
    }

    // 战斗
    public void battle() {
        show(0);
    }
    // 关卡
    public void checkPoint() {
        show(1);
    }
}
