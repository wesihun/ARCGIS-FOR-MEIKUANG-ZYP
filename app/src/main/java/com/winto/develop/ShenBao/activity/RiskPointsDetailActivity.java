package com.winto.develop.ShenBao.activity;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.PaichaListAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.base.BaseResponse;
import com.winto.develop.ShenBao.bean.PaichaListBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zyp on 2019/8/20 0020.
 * class note:风险点详情
 */

@Route(path = "/app/RiskPointsDetailActivity")
public class RiskPointsDetailActivity extends BaseActivity {

    private ImageView iv_back;
    private SmartRefreshLayout srl_refresh;
    private ListView lv_list;
    private View headerView;

    private PaichaListAdapter adapter;
    private List<PaichaListBean.DataBean> list;

    private String riskName;
    private String riskId;
    private TextView tv_name;
    private TextView tv_id;

    @Override
    protected void initIntentData() {
        riskName = getIntent().getStringExtra("riskName");
        riskId = getIntent().getStringExtra("riskId");
    }

    @Override
    protected void initView() {
        headerView = LayoutInflater.from(context).inflate(R.layout.layout_risk_points_header, null);
        iv_back = findViewById(R.id.iv_back);
        srl_refresh = findViewById(R.id.srl_refresh);
        lv_list = findViewById(R.id.lv_list);
        tv_name = headerView.findViewById(R.id.tv_name);
        tv_id = headerView.findViewById(R.id.tv_id);
        lv_list.addHeaderView(headerView);
        tv_name.setText(riskName);
        tv_id.setText(riskId);
        srl_refresh.setEnableLoadMore(false);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initAdapter() {
        list = new ArrayList<>();
        adapter = new PaichaListAdapter(context, list);
        lv_list.setAdapter(adapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());

        srl_refresh.setOnRefreshListener(refreshLayout -> getInvestigateItemList());

        adapter.setOnBtnClickListener(new PaichaListAdapter.OnBtnClickListener() {
            @Override
            public void onOkClick(PaichaListBean.DataBean bean) {
                checkPass(bean.getId());
            }

            @Override
            public void onNoClick(PaichaListBean.DataBean bean) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("paicha", bean);
                toClass(context, TroubleFillActivity.class, bundle);
            }
        });
    }

    private void checkPass(String id) {
        Map<String, String> params = new ArrayMap<>();
        params.put("id", id);
        HttpAction.getInstance().checkPass(params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                getInvestigateItemList();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void getInvestigateItemList() {
        Map<String, String> params = new ArrayMap<>();
        params.put("riskBH", riskId);
        HttpAction.getInstance().getInvestigateItemList(params).subscribe(new BaseObserver<PaichaListBean>() {
            @Override
            public void onSuccess(PaichaListBean bean) {
                srl_refresh.finishRefresh();
                list.clear();
                list.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                srl_refresh.finishRefresh();
                ToastUtil.show(context, message);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getInvestigateItemList();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_risk_points_detail;
    }
}