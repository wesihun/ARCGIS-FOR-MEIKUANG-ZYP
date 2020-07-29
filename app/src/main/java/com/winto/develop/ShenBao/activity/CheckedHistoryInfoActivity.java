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

public class CheckedHistoryInfoActivity extends BaseActivity {

    private ImageView iv_back;
    private TextView tv_trouble_info;
    private TextView tv_time;
    private TextView tv_shooting_item;
    private TextView tv_hidden_level;
    private RelativeLayout rl_is_supervisor;
    private TextView tv_control_measures;
    private TextView tv_user_name;

    private TextView tv_result;
    private TextView tv_re_proposal;
    private TextView tv_remark;
    private TextView tv_re_states;
    private TextView tv_re_time;
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
        rl_is_supervisor = findViewById(R.id.rl_is_supervisor);
        tv_control_measures = findViewById(R.id.tv_control_measures);
        gv_image_list = findViewById(R.id.gv_image_list);
        tv_shooting_item = findViewById(R.id.tv_shooting_item);
        tv_user_name = findViewById(R.id.tv_user_name);
        tv_hidden_level = findViewById(R.id.tv_hidden_level);
        tv_result = findViewById(R.id.tv_result);
        tv_re_proposal = findViewById(R.id.tv_re_proposal);
        tv_remark = findViewById(R.id.tv_remark);
        tv_re_states = findViewById(R.id.tv_re_states);
        tv_re_time = findViewById(R.id.tv_re_time);
        setPage();
    }

    private void setPage() {
        tv_trouble_info.setText(TextUtils.isEmpty(trouble.getHiddenDangersDescribe()) ? "暂无描述" : trouble.getHiddenDangersDescribe());
        tv_time.setText(trouble.getReportTime());
        tv_shooting_item.setText(trouble.getTroubleshootingItems());
        tv_hidden_level.setText(trouble.getHiddenDangerLevel());
        tv_control_measures.setText(trouble.getControlMeasures());
        tv_user_name.setText(trouble.getReportUserName());

        tv_result.setText(trouble.getResult());
        tv_re_proposal.setText(trouble.getReProposal());
        tv_remark.setText(trouble.getRemark());
        tv_re_time.setText(trouble.getReTime());

        if ("3".equals(trouble.getStates())) {
            tv_re_states.setText("已通过");
        } else if ("4".equals(trouble.getStates())) {
            tv_re_states.setText("未通过");
        }

        if ("1".equals(trouble.getIsSupervisor())) {
            rl_is_supervisor.setVisibility(View.VISIBLE);
        } else {
            rl_is_supervisor.setVisibility(View.GONE);
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
        return R.layout.activity_checked_history_info;
    }
}