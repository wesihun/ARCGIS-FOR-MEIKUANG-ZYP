package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.RiskNoticeCardListBean;

import java.util.List;

public class RiskNoticeCardAdapter extends RecyclerView.Adapter<RiskNoticeCardAdapter.TaskViewHolder> {
    private Context context;
    private List<RiskNoticeCardListBean.DataBean> list;

    private OnItemClickListener listener;

    public RiskNoticeCardAdapter(Context context, List<RiskNoticeCardListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_risk_notice_card, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        RiskNoticeCardListBean.DataBean card = getItem(position);
        holder.tv_name.setText(card.getRiskName());
        holder.tv_id.setText("风险点编号：" + card.getRiskBH());
        holder.tv_level.setText("风险等级：" + card.getRiskLevel());
        holder.tv_state.setText(card.getRiskFactor());
    }

    private RiskNoticeCardListBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_id;
        private TextView tv_level;
        private TextView tv_state;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_level = itemView.findViewById(R.id.tv_level);
            tv_state = itemView.findViewById(R.id.tv_state);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(RiskNoticeCardListBean.DataBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
