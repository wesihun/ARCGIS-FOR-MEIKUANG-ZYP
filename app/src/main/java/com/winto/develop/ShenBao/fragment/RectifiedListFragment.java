package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.ModifyHiddenFillActivity;
import com.winto.develop.ShenBao.adapter.RectifiedHiddenListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.RectifiedHiddenListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectifiedListFragment extends BaseFragment {
    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_list;
    private RectifiedHiddenListAdapter adapter;
    private List<RectifiedHiddenListBean.DataBean> messageList;
    private View layout_empty;
    private int page = 1;
    private int limit = 20;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        rv_list = findViewById(R.id.lv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);
        tv_tips.setText("没有需要待整改的隐患");
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initAdapter() {
        messageList = new ArrayList<>();
        adapter = new RectifiedHiddenListAdapter(context, messageList);
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        rv_list.setAdapter(adapter);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initClick() {
        srl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                getList();
            }
        });

        srl_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getList();
            }
        });

        adapter.setOnItemClickListener(bean -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("hidden", bean);
            toClass(context, ModifyHiddenFillActivity.class, bundle);
        });
    }

    private void getList() {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("limit", String.valueOf(limit));
        params.put("states", "1");
        HttpAction.getInstance().getRectifiedHiddenList(params).subscribe(new BaseObserver<RectifiedHiddenListBean>() {
            @Override
            public void onSuccess(RectifiedHiddenListBean bean) {
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

    private void addHeaderData(List<RectifiedHiddenListBean.DataBean> data) {
        messageList.clear();
        for (int i = 0; i < data.size(); i++) {
            RectifiedHiddenListBean.DataBean hidden = data.get(i);
            if ("1".equals(hidden.getStates()) || "4".equals(hidden.getStates())) {
                messageList.add(hidden);
            }
        }
        showEmptyView(messageList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void addFooterData(List<RectifiedHiddenListBean.DataBean> data) {
        for (int i = 0; i < data.size(); i++) {
            RectifiedHiddenListBean.DataBean hidden = data.get(i);
            if ("1".equals(hidden.getStates()) || "4".equals(hidden.getStates())) {
                messageList.add(hidden);
            }
        }
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
        return R.layout.fragment_rectified_list;
    }
}