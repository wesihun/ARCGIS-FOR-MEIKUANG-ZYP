package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.HistoryListBean;

import java.util.List;

public class NoticedHistoryListAdapter extends RecyclerView.Adapter<NoticedHistoryListAdapter.TaskViewHolder> {
    private Context context;
    private List<HistoryListBean.DataBean> list;
    private OnItemClickListener listener;
    private int states;

    public NoticedHistoryListAdapter(Context context, List<HistoryListBean.DataBean> list, int states) {
        this.context = context;
        this.list = list;
        this.states = states;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_noticed_history_list, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        HistoryListBean.DataBean bean = getItem(position);
        holder.tv_name.setText(bean.getTroubleshootingItems());
        holder.tv_info.setText(TextUtils.isEmpty(bean.getHiddenDangersDescribe()) ? "暂无描述" : bean.getHiddenDangersDescribe());
        holder.tv_personnel.setText(bean.getPersonName());
        holder.tv_level.setText(bean.getHiddenDangerLevel());
        holder.tv_time.setText(bean.getCreateTime());
        holder.ll_is_supervisor.setVisibility("1".equals(bean.getIsSupervisor()) ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(bean);
            }
        });
    }

    private HistoryListBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_info;
        private TextView tv_personnel;
        private TextView tv_state;
        private LinearLayout ll_is_supervisor;
        private TextView tv_time;
        private TextView tv_level;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_info = itemView.findViewById(R.id.tv_info);
            tv_personnel = itemView.findViewById(R.id.tv_personnel);
            tv_state = itemView.findViewById(R.id.tv_state);
            ll_is_supervisor = itemView.findViewById(R.id.ll_is_supervisor);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_level = itemView.findViewById(R.id.tv_level);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(HistoryListBean.DataBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}