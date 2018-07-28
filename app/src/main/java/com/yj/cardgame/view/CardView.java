package com.yj.cardgame.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yj.cardgame.R;
import com.yj.cardgame.card.AbstractCard;
import com.yj.cardgame.card.equipmentCard.EquipmentCard;
import com.yj.cardgame.card.magicCard.MagicCard;
import com.yj.cardgame.card.normalCard.NormalCard;
import com.yj.cardgame.card.trapCard.TarpCard;
import com.yj.cardgame.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yj on 2018/7/24.
 */

public class CardView extends FrameLayout {
    @BindView(R.id.iv_res)
    ImageView ivRes;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_describe)
    TextView tvDescribe;
    @BindView(R.id.tv_type)
    TextView tvType;
    View view;

    int card_view_card_name_text_size = -1;
    int card_view_card_describe_text_size = -1;
    int card_view_card_type_text_size = -1;


    public CardView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.card_view);//获取配置属性
            card_view_card_name_text_size = tArray.getDimensionPixelSize(R.styleable.card_view_card_name_text_size, -1);
            card_view_card_describe_text_size = tArray.getDimensionPixelSize(R.styleable.card_view_card_describe_text_size, -1);
            card_view_card_type_text_size = tArray.getDimensionPixelSize(R.styleable.card_view_card_type_text_size, -1);
        }
        view = LayoutInflater.from(context).inflate(R.layout.layout_card, null, false);
        addView(view);
        ButterKnife.bind(this);
    }

    public void setCard(AbstractCard card) {
        if (card instanceof NormalCard) {
            tvType.setText("攻击卡");
            view.setBackgroundResource(R.mipmap.bg_normal_card);
        } else if (card instanceof TarpCard) {
            tvType.setText("状态卡");
            view.setBackgroundResource(R.mipmap.bg_trap_card);
        } else if (card instanceof EquipmentCard) {
            tvType.setText("装备卡");
            view.setBackgroundResource(R.mipmap.bg_equipment_card);
        } else if (card instanceof MagicCard) {
            tvType.setText("魔法卡");
            view.setBackgroundResource(R.mipmap.bg_magic_card);
        } else {
            view.setBackground(null);
        }

        // 设置卡牌图案、名字、效果
        int resId = card.getResId();
        if (resId != 0) {
            ivRes.setImageResource(card.getResId());
        }
        tvName.setText(card.getName());
        tvDescribe.setText(card.getDescribe());

        //  大小
        if (card_view_card_describe_text_size != -1) {
            tvDescribe.setTextSize(DensityUtil.px2sp(card_view_card_describe_text_size));
        }
        if (card_view_card_name_text_size != -1) {
            tvName.setTextSize(DensityUtil.px2sp(card_view_card_name_text_size));
        }
        if (card_view_card_type_text_size != -1) {
            tvType.setTextSize(DensityUtil.px2sp(card_view_card_type_text_size));
        }
    }
}
