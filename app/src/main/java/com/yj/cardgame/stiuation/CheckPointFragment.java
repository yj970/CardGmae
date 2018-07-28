package com.yj.cardgame.stiuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yj.cardgame.Game;
import com.yj.cardgame.R;
import com.yj.cardgame.checkPoint.AbstractCheckPoint;
import com.yj.cardgame.checkPoint.MonsterCheckPoint;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yj on 2018/7/24.
 */

public class CheckPointFragment extends Fragment {

    @BindView(R.id.point_1)
    LinearLayout llPoint1;
    @BindView(R.id.point_2)
    LinearLayout llPoint2;
    @BindView(R.id.point_3)
    LinearLayout llPoint3;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_point, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    // 填充关卡
    public void supplyCheckPoint() {
        setCheckPoint(llPoint1);
        setCheckPoint(llPoint2);
        setCheckPoint(llPoint3);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        supplyCheckPoint();
    }

    // 填充关卡
    private void setCheckPoint(LinearLayout llCheckPoint) {
        if (llCheckPoint.getTag() == null) {
            AbstractCheckPoint checkPoint = Game.getCheckPoint();
            if (checkPoint != null) {
                llCheckPoint.setTag(checkPoint);
                llCheckPoint.setVisibility(View.VISIBLE);
                ((ImageView)llCheckPoint.findViewById(R.id.iv_res)).setImageResource(checkPoint.getResourId());
                ((TextView)llCheckPoint.findViewById(R.id.tv_name)).setText(checkPoint.getName());
            } else {
                llCheckPoint.setTag(null);
                llCheckPoint.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.point_1, R.id.point_2, R.id.point_3})
    public void onViewClicked(View v) {
        if (v.getTag() instanceof MonsterCheckPoint) {
            Game.monster = ((MonsterCheckPoint)v.getTag()).getMonster();
            ((GameActivity)getActivity()).battle();

            v.setTag(null);
            // 进入战斗
            supplyCheckPoint();
        }
    }
}
