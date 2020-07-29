package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.NoticedHistoryInfoActivity;
import com.winto.develop.ShenBao.adapter.NoticedHistoryListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.HistoryListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoticedHistoryFragment extends BaseFragment {
    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_list;
    private View layout_empty;

    private NoticedHistoryListAdapter adapter;
    private int page = 1;
    private List<HistoryListBean.DataBean> troubleList;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        rv_list = findViewById(R.id.lv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);
        tv_tips.setText("暂无已下发整改通知的记录");
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAdapter() {
        troubleList = new ArrayList<>();
        adapter = new NoticedHistoryListAdapter(context, troubleList,1);
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        rv_list.setAdapter(adapter);
    }

    @Override
    protected void initClick() {
        adapter.setOnItemClickListener(bean -> {
            //1已上报未下发通知  2已整改待复查  3已复查已通过  4已复查未通过  5已下发通知未整改
            Bundle bundle = new Bundle();
            bundle.putSerializable("trouble", bean);
            toClass(context, NoticedHistoryInfoActivity.class, bundle);
        });

        srl_refresh.setOnRefreshListener(refreshLayout -> {
            page = 1;
            getTroubleList();
        });

        srl_refresh.setOnLoadMoreListener(refreshLayout -> {
            page++;
            getTroubleList();
        });
    }

    private void getTroubleList() {
        Map<String, Object> params = new HashMap<>();
        params.put("states", 1);
        params.put("page", page);
        params.put("limit", "20");
        HttpAction.getInstance().getHistoryList(params).subscribe(new BaseObserver<HistoryListBean>() {
            @Override
            public void onSuccess(HistoryListBean bean) {
                if (page == 1) {
                    srl_refresh.finishRefresh();
                    addHeader(bean.getData());
                } else {
                    srl_refresh.finishLoadMore();
                    addFooter(bean.getData());
                }
            }

            @Override
            public void onError(String message) {
                srl_refresh.finishRefresh();
                srl_refresh.finishLoadMore();
                ToastUtil.show(context, message);
                showEmptyView(true);
            }
        });
    }

    private void addHeader(List<HistoryListBean.DataBean> data) {
        troubleList.clear();
        troubleList.addAll(data);
        showEmptyView(troubleList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void addFooter(List<HistoryListBean.DataBean> data) {
        troubleList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    private void showEmptyView(boolean b) {
        if (b) {
            layout_empty.setVisibility(View.VISIBLE);
            srl_refresh.setVisibility(View.GONE);
        } else {
            layout_empty.setVisibility(View.GONE);
            srl_refresh.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getTroubleList();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_noticed;
    }
}
