package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.WaitNoticeActivity;
import com.winto.develop.ShenBao.adapter.WaitNoticeListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.TroubleListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaitNoticeFragment extends BaseFragment {
    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_list;
    private View layout_empty;

    private WaitNoticeListAdapter adapter;
    private int page = 1;
    private List<TroubleListBean.DataBean> troubleList;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        rv_list = findViewById(R.id.rv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);
        tv_tips.setText("没有需要下发的整改通知");
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initAdapter() {
        troubleList = new ArrayList<>();
        adapter = new WaitNoticeListAdapter(context, troubleList);
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
            if (MainApplication.getContext().isManagementPosition()) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("trouble", bean);
                toClass(context, WaitNoticeActivity.class, bundle);
            }
        });
    }

    private void getList() {
        Map<String, String> params = new HashMap<>();
        params.put("condition", "");
        params.put("keyword", "");
        params.put("qdstates", "1");
        params.put("page", String.valueOf(page));
        params.put("limit", "20");
        HttpAction.getInstance().getTroubleList(params).subscribe(new BaseObserver<TroubleListBean>() {
            @Override
            public void onSuccess(TroubleListBean bean) {
                if (page == 1) {
                    addHeader(bean.getData());
                    srl_refresh.finishRefresh();
                } else {
                    addFooter(bean.getData());
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

    private void addHeader(List<TroubleListBean.DataBean> data) {
        troubleList.clear();
        troubleList.addAll(data);
        showEmptyView(troubleList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void addFooter(List<TroubleListBean.DataBean> data) {
        troubleList.addAll(data);
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
        return R.layout.fragment_wait_notice;
    }
}