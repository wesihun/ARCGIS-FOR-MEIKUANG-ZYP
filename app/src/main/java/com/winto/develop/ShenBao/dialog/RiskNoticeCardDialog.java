package com.winto.develop.ShenBao.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.RiskNoticeCardAdapter;
import com.winto.develop.ShenBao.bean.RiskNoticeCardListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2019/8/28 0028
 * class note:
 */

public class RiskNoticeCardDialog extends Dialog {

    private Context context;
    private List<RiskNoticeCardListBean.DataBean> list = new ArrayList<>();
    private RiskNoticeCardAdapter adapter;
    private TextView tv_tips;

    //    style引用style样式
    public RiskNoticeCardDialog(Context context) {
        super(context, R.style.DialogTheme);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_risk_notice_card, null);
        RecyclerView rv_list = view.findViewById(R.id.rv_list);
        tv_tips = view.findViewById(R.id.tv_tips);
        adapter = new RiskNoticeCardAdapter(context, list);
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        rv_list.setAdapter(adapter);

        setContentView(view);
        initClick();
    }

    public void setData(List<RiskNoticeCardListBean.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
        if (this.list.size() == 0) {
            tv_tips.setVisibility(View.VISIBLE);
        } else {
            tv_tips.setVisibility(View.GONE);
        }
    }

    private void initClick() {

    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        if (window == null) {
            return;
        }

        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;

        window.setAttributes(params);
    }
}
