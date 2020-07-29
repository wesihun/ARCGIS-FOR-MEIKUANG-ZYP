package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.HiddenInfoActivity;
import com.winto.develop.ShenBao.adapter.ReportedListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.HistoryListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFragment extends BaseFragment {
    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_list;
    private View layout_empty;

    private ReportedListAdapter adapter;
    private int page = 1;
    private List<HistoryListBean.DataBean> troubleList;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        rv_list = findViewById(R.id.lv_list);
        layout_empty = findViewById(R.id.layout_empty);
        TextView tv_tips = layout_empty.findViewById(R.id.tv_tips);
        tv_tips.setText("暂无上报的隐患");
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAdapter() {
        troubleList = new ArrayList<>();
        adapter = new ReportedListAdapter(context, troubleList, -1);
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        rv_list.setAdapter(adapter);
    }

    @Override
    protected void initClick() {
        adapter.setOnItemClickListener(bean -> {
            //1已上报未下发通知  2已整改待复查  3已复查已通过  4已复查未通过  5已下发通知未整改
            Bundle bundle = new Bundle();
            bundle.putSerializable("trouble", bean);
            toClass(context, HiddenInfoActivity.class, bundle);
            /*String roleName = MainApplication.getContext().getRoleName();
            boolean b = roleName.equals("部门(车间)负责人") || roleName.equals("公司经理级管理人员") || roleName.equals("系统管理员");

            switch (bean.getStates()) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("trouble", bean);
                    toClass(context, HiddenInfoActivity.class, bundle);
                    break;
            }*/
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
        params.put("states", 3);
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
        return R.layout.fragment_reported;
    }
}
