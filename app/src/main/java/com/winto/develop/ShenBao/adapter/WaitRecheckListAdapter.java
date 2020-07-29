package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.ReviewedHiddenListBean;

import java.util.List;

public class WaitRecheckListAdapter extends RecyclerView.Adapter<WaitRecheckListAdapter.TaskViewHolder> {
    private Context context;
    private List<ReviewedHiddenListBean.DataBean> list;

    private OnItemClickListener listener;

    public WaitRecheckListAdapter(Context context, List<ReviewedHiddenListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_list, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        ReviewedHiddenListBean.DataBean bean = getItem(position);
        holder.tv_name.setText(bean.getHiddenDangersDescribe());
        holder.tv_department.setText(bean.getModifyUserName());
        holder.tv_time.setText(bean.getCreateTime());
        holder.tv_id.setText(bean.getRiskBH());
        holder.ll_is_supervisor.setVisibility("1".equals(bean.getIsSupervisor()) ? View.VISIBLE : View.GONE);

        /*
         * state为2的时候表示当前的通知未进行处理，其他状态为已处理，包括合格和不合格
         * */
        if (bean.getStates().equals("2")) {
            holder.tv_state.setText("未处理");
        } else {
            holder.tv_state.setText("已处理");
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                if (bean.getStates().equals("2")) {
                    listener.onItemClick(bean);
                }
            }
        });
    }

    private ReviewedHiddenListBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_department;
        private TextView tv_time;
        private TextView tv_state;
        private TextView tv_id;
        private LinearLayout ll_is_supervisor;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_department = itemView.findViewById(R.id.tv_department);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_state = itemView.findViewById(R.id.tv_state);
            tv_id = itemView.findViewById(R.id.tv_id);
            ll_is_supervisor = itemView.findViewById(R.id.ll_is_supervisor);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ReviewedHiddenListBean.DataBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
