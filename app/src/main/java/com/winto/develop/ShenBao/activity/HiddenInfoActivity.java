package com.winto.develop.ShenBao.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luck.picture.lib.entity.LocalMedia;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.ImageListAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.bean.HistoryListBean;
import com.winto.develop.ShenBao.constant.ConstantData;
import com.winto.develop.ShenBao.wight.CustomGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:隐患详情
 */

public class HiddenInfoActivity extends BaseActivity {

    private ImageView iv_back;
    private TextView tv_trouble_info;
    private TextView tv_time;
    private TextView tv_hidden_state;
    private TextView tv_shooting_item;
    private TextView tv_hidden_level;
    private RelativeLayout rl_is_supervisor;
    private TextView tv_control_measures;
    private CustomGridView gv_image_list;

    private List<LocalMedia> imageList;
    private ImageListAdapter imageAdapter;
    private HistoryListBean.DataBean trouble;


    @Override
    protected void initIntentData() {
        trouble = (HistoryListBean.DataBean) getIntent().getSerializableExtra("trouble");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_trouble_info = findViewById(R.id.tv_trouble_info);
        tv_time = findViewById(R.id.tv_time);
        tv_hidden_state = findViewById(R.id.tv_hidden_state);
        rl_is_supervisor = findViewById(R.id.rl_is_supervisor);
        tv_control_measures = findViewById(R.id.tv_control_measures);
        gv_image_list = findViewById(R.id.gv_image_list);
        tv_shooting_item = findViewById(R.id.tv_shooting_item);
        tv_hidden_level = findViewById(R.id.tv_hidden_level);
        setPage();
    }

    private void setPage() {
        tv_trouble_info.setText(TextUtils.isEmpty(trouble.getHiddenDangersDescribe()) ? "暂无描述" : trouble.getHiddenDangersDescribe());
        tv_time.setText(trouble.getCreateTime());
        tv_shooting_item.setText(trouble.getTroubleshootingItems());
        tv_hidden_level.setText(trouble.getHiddenDangerLevel());
        tv_control_measures.setText(trouble.getControlMeasures());
        rl_is_supervisor.setVisibility("1".equals(trouble.getIsSupervisor()) ? View.VISIBLE : View.GONE);

        //1已上报未下发通知  2已整改待复查  3已复查已通过  4已复查未通过  5已下发通知未整改
        switch (trouble.getStates()) {
            case "1":
                tv_hidden_state.setText("已上报");
                break;
            case "2":
                tv_hidden_state.setText("待复查");
                break;
            case "3":
                tv_hidden_state.setText("已通过");
                break;
            case "4":
                tv_hidden_state.setText("未通过");
                break;
            case "5":
                tv_hidden_state.setText("待整改");
                break;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAdapter() {
        imageList = new ArrayList<>();
        String imageUrlStr = trouble.getReportImageUrl();
        if (TextUtils.isEmpty(imageUrlStr)) {
            return;
        }
        String[] imageUrls = imageUrlStr.split(",");
        for (String imageUrl : imageUrls) {
            LocalMedia localMedia = new LocalMedia(ConstantData.IMAGE_URL + imageUrl, 0, 0, "");
            imageList.add(localMedia);
        }
        imageAdapter = new ImageListAdapter(context, imageList);
        gv_image_list.setAdapter(imageAdapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_hidden_info;
    }
}