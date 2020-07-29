package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.TroubleReviewActivity;
import com.winto.develop.ShenBao.adapter.WaitRecheckListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.ReviewedHiddenListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaitRecheckListFragment extends BaseFragment {
    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_list;
    private WaitRecheckListAdapter adapter;
    private List<ReviewedHiddenListBean.DataBean> messageList;
    private View layout_empty;
    private int page = 1;
    private int limit = 20;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        rv_list = findViewById(R.id.lv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);
        tv_tips.setText("没有需要待复查的隐患");
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initAdapter() {
        messageList = new ArrayList<>();
        adapter = new WaitRecheckListAdapter(context, messageList);
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        rv_list.setAdapter(adapter);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initClick() {
        srl_refresh.setOnRefreshListener(refreshLayout -> {
            page = 1;
            getList();
        });

        srl_refresh.setOnLoadMoreListener(refreshLayout -> {
            page++;
            getList();
        });

        adapter.setOnItemClickListener(bean -> {
            Bundle bundle = new Bundle();
            bundle.putString("ReportId", bean.getReportId());
            bundle.putString("ModifyUserId", bean.getModifyUserId());
            bundle.putString("ModifyUserName", bean.getModifyUserName());
            bundle.putString("ImageUrl", bean.getImageUrl());
            bundle.putString("ModifyStates", bean.getModifyStates());
            bundle.putString("ModifySituation", bean.getModifySituation());
            bundle.putString("ModifyResult", bean.getModifyResult());
            bundle.putString("HiddenDangersDescribe", bean.getHiddenDangersDescribe());
            bundle.putString("RiskBH", bean.getRiskBH());
            bundle.putString("RiskName", bean.getRiskName());
            bundle.putString("CreateTime", bean.getCreateTime());
            toClass(context, TroubleReviewActivity.class, bundle);
        });
    }

    private void getList() {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("limit", String.valueOf(limit));
        params.put("states", "2");
        HttpAction.getInstance().getReviewHiddenList(params).subscribe(new BaseObserver<ReviewedHiddenListBean>() {
            @Override
            public void onSuccess(ReviewedHiddenListBean bean) {
                if (page == 1) {
                    addHeaderData(bean.getData());
                    srl_refresh.finishRefresh();
                } else {
                    addFooterData(bean.getData());
                    srl_refresh.finishLoadMore();
                }
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
                srl_refresh.finishRefresh();
                srl_refresh.finishLoadMore();
                showEmptyView(true);
            }
        });
    }

    private void addHeaderData(List<ReviewedHiddenListBean.DataBean> data) {
        messageList.clear();
        messageList.addAll(data);
        showEmptyView(messageList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void addFooterData(List<ReviewedHiddenListBean.DataBean> data) {
        messageList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    private void showEmptyView(boolean b) {
        if (b) {
            layout_empty.setVisibility(View.VISIBLE);
            rv_list.setVisibility(View.GONE);
        } else {
            layout_empty.setVisibility(View.GONE);
            rv_list.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getList();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_recheck_list;
    }
}