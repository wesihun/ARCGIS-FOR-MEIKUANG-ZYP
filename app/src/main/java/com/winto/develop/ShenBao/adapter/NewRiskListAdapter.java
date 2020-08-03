package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.RiskPointListBean;

import java.util.List;

public class NewRiskListAdapter extends BaseAdapter {
    private Context context;
    private List<RiskPointListBean.DataBean> list;

    private OnBtnClickListener listener;
    private String taskType;

    public NewRiskListAdapter(Context context, List<RiskPointListBean.DataBean> list, String taskType) {
        this.context = context;
        this.list = list;
        this.taskType = taskType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RiskViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_risk_point_list, parent, false);
            holder = new RiskViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (RiskViewHolder) convertView.getTag();
        }
        RiskPointListBean.DataBean bean = getItem(position);
        holder.tv_name.setText("风险点名称" + bean.getRiskName());
        holder.tv_risk_id.setText("风险点编号：" + bean.getRiskBH());

        switch (bean.getStates()) {
            case "0":
                holder.tv_state.setText("未完成");
                holder.tv_state.setTextColor(ContextCompat.getColor(context, R.color.red));
                holder.iv_scan.setVisibility(View.VISIBLE);
                holder.iv_complate.setVisibility(View.GONE);
                break;
            case "1":
                holder.tv_state.setText("已完成");
                holder.tv_state.setTextColor(ContextCompat.getColor(context, R.color.blue));
                holder.iv_scan.setVisibility(View.GONE);
                holder.iv_complate.setVisibility(View.VISIBLE);
                holder.iv_complate.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_complate));
                break;
            case "2":
                holder.tv_state.setText("未到检查时间");
                holder.tv_state.setTextColor(ContextCompat.getColor(context, R.color.orange));
                holder.iv_scan.setVisibility(View.GONE);
                holder.iv_complate.setVisibility(View.VISIBLE);
                holder.iv_complate.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_pending));
                break;
        }
        holder.iv_scan.setOnClickListener(v -> {
            if (listener != null) {
                listener.onButtonClick(bean);
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public RiskPointListBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class RiskViewHolder {
        private TextView tv_name;
        private ImageView iv_scan;
        private TextView tv_risk_id;
        private TextView tv_state;
        private ImageView iv_complate;
        private View itemView;

        RiskViewHolder(@NonNull View itemView) {
            this.itemView = itemView;
            iv_scan = itemView.findViewById(R.id.iv_scan);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_risk_id = itemView.findViewById(R.id.tv_risk_id);
            tv_state = itemView.findViewById(R.id.tv_state);
            iv_complate = itemView.findViewById(R.id.iv_complate);
        }
    }

    public interface OnBtnClickListener {
        void onButtonClick(RiskPointListBean.DataBean bean);
    }

    public void setOnBtnClickListener(OnBtnClickListener listener) {
        this.listener = listener;
    }
}
