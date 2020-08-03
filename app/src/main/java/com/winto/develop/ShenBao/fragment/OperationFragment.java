package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.RiskListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.RiskPointListBean;
import com.winto.develop.ShenBao.bean.TaskDetailBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class OperationFragment extends BaseFragment {

    private ListView lv_list;
    private SmartRefreshLayout srl_refresh;
    private RiskListAdapter adapter;
    private List<RiskPointListBean.DataBean> riskList;
    private TextView tv_name;
    private TextView tv_info;
    private TextView tv_time;
    private View riskHeader;
    private View layout_empty;
    private TextView tv_tips;

    @Override
    protected void initView() {
        riskHeader = LayoutInflater.from(context).inflate(R.layout.layout_task_detail_header, null);
        lv_list = findViewById(R.id.lv_list);
        srl_refresh = findViewById(R.id.srl_refresh);
        tv_name = riskHeader.findViewById(R.id.tv_name);
        tv_info = riskHeader.findViewById(R.id.tv_info);
        tv_time = riskHeader.findViewById(R.id.tv_time);
        layout_empty = findViewById(R.id.layout_empty);
        tv_tips = layout_empty.findViewById(R.id.tv_tips);
        srl_refresh.setEnableLoadMore(false);
    }

    @Override
    protected void initData() {
        getPlan();
    }

    @Override
    protected void initAdapter() {
        riskList = new ArrayList<>();
        adapter = new RiskListAdapter(context, riskList);
        lv_list.setAdapter(adapter);
    }

    @Override
    protected void initClick() {
        adapter.setOnBtnClickListener(this::goScan);

        srl_refresh.setOnRefreshListener(refreshLayout -> {
            getRiskPointList();
        });
    }

    private void getPlan() {
        HttpAction.getInstance().getPlanList().subscribe(new BaseObserver<TaskDetailBean>() {
            @Override
            public void onSuccess(TaskDetailBean bean) {
                TaskDetailBean.DataBean data = bean.getData();

                if (!TextUtils.isEmpty(data.getPlanName()) || !TextUtils.isEmpty(data.getDepName()) || !TextUtils.isEmpty(data.getCheckDate())) {
                    lv_list.addHeaderView(riskHeader);
                    tv_name.setText(data.getPlanName());
                    tv_info.setText(data.getDepName());
                    tv_time.setText(data.getCheckDate());
                }
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void getRiskPointList() {
        HttpAction.getInstance().getRiskPointList().subscribe(new BaseObserver<RiskPointListBean>() {
            @Override
            public void onSuccess(RiskPointListBean bean) {
                riskList.clear();
                riskList.addAll(bean.getData());
                adapter.notifyDataSetChanged();
                showEmptyView(riskList.size() == 0, bean.getMsg());
                srl_refresh.finishRefresh();
            }

            @Override
            public void onError(String message) {
                showEmptyView(true, "网络请求失败");
                ToastUtil.show(context, message);
                srl_refresh.finishRefresh();
            }
        });
    }

    private void showEmptyView(boolean b, String tips) {
        if (b) {
            layout_empty.setVisibility(View.VISIBLE);
            lv_list.setVisibility(View.GONE);
            tv_tips.setText(tips);
        } else {
            layout_empty.setVisibility(View.GONE);
            lv_list.setVisibility(View.VISIBLE);
        }
    }

    private void goScan(RiskPointListBean.DataBean bean) {
        Bundle bundle = new Bundle();
        bundle.putString("riskId", bean.getRiskBH());
        bundle.putInt("scanType", 2);
        toClass(context, CaptureActivity.class, bundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        getRiskPointList();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_risk_list;
    }
}