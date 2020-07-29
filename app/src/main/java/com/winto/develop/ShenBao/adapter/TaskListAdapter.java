package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.TaskListBean;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private Context context;
    private List<TaskListBean> list;

    private OnItemClickListener listener;

    public TaskListAdapter(Context context, List<TaskListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskListBean bean = getItem(position);
        holder.tv_name.setText(bean.getTaskName());
        holder.tv_info.setText(bean.getTaskInfo());
        holder.tv_time.setText(bean.getTime());
        if (bean.getTaskState() == 0) {
            holder.tv_state.setText("未完成");
            holder.tv_state.setTextColor(ContextCompat.getColor(context, R.color.lightred));
        } else {
            holder.tv_state.setText("已完成");
            holder.tv_state.setTextColor(ContextCompat.getColor(context, R.color.secondcolor));
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(bean);
            }
        });
    }

    private TaskListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_info;
        private TextView tv_time;
        private TextView tv_state;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_info = itemView.findViewById(R.id.tv_info);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_state = itemView.findViewById(R.id.tv_state);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(TaskListBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
