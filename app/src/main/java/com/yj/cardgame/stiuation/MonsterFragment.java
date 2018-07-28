package com.yj.cardgame.stiuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yj.cardgame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yangjie on 2018/7/23.
 */

public class MonsterFragment extends Fragment {

    @BindView(R.id.monster)
    ImageView monster;
    @BindView(R.id.describe)
    TextView describe;
    @BindView(R.id.option_1)
    Button option1;
    @BindView(R.id.option_2)
    Button option2;
    @BindView(R.id.option_3)
    Button option3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monster, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.option_1, R.id.option_2, R.id.option_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.option_1:
                ((GameActivity)getActivity()).battle();
                break;
            case R.id.option_2:
                break;
            case R.id.option_3:
                break;
        }
    }
}
