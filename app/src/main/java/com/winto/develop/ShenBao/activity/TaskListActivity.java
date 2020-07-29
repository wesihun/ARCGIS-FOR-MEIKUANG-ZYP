package com.winto.develop.ShenBao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.NewRiskListAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.RiskPointListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:
 */

public class TaskListActivity extends BaseActivity {

    private ImageView iv_back;

    private SmartRefreshLayout srl_refresh;
    private ListView lv_list;
    private View layout_empty;
    private NewRiskListAdapter adapter;
    private List<RiskPointListBean.DataBean> riskList;

    private String taskType;

    @Override
    protected void initIntentData() {
        taskType = getIntent().getStringExtra("taskType");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        srl_refresh = findViewById(R.id.srl_refresh);
        lv_list = findViewById(R.id.lv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);

        if ("0".equals(taskType)) {
            tv_tips.setText("暂无未完成的任务");
        } else {
            tv_tips.setText("暂无已完成的任务");
        }

        srl_refresh.setEnableLoadMore(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAdapter() {
        riskList = new ArrayList<>();
        adapter = new NewRiskListAdapter(context, riskList, taskType);
        lv_list.setAdapter(adapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());

        adapter.setOnBtnClickListener(this::goScan);

        srl_refresh.setOnRefreshListener(refreshLayout -> getRiskPointList());
    }

    private void getRiskPointList() {
        HttpAction.getInstance().getRiskPointList().subscribe(new BaseObserver<RiskPointListBean>() {
            @Override
            public void onSuccess(RiskPointListBean bean) {
                srl_refresh.finishRefresh();
                List<RiskPointListBean.DataBean> data = bean.getData();
                riskList.clear();

                for (int i = 0; i < data.size(); i++) {
                    if ("1".equals(taskType)) {
                        if ("1".equals(data.get(i).getStates())) {
                            riskList.add(data.get(i));
                        }
                    } else {
                        if (!"1".equals(data.get(i).getStates())) {
                            riskList.add(data.get(i));
                        }
                    }
                }
                showEmptyView(riskList.size() == 0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                srl_refresh.finishRefresh();
                showEmptyView(true);
                ToastUtil.show(context, message);
            }
        });
    }

    private void goScan(RiskPointListBean.DataBean bean) {
        Bundle bundle = new Bundle();
        bundle.putString("riskId", bean.getRiskBH());
        bundle.putInt("scanType", 2);
        toClass(context, CaptureActivity.class, bundle);
    }

    private void showEmptyView(boolean b) {
        if (b) {
            layout_empty.setVisibility(View.VISIBLE);
            lv_list.setVisibility(View.GONE);
        } else {
            layout_empty.setVisibility(View.GONE);
            lv_list.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getRiskPointList();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_task_list;
    }
}