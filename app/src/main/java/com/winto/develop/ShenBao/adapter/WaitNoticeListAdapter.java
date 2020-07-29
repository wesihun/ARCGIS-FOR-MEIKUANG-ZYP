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

import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.TroubleListBean;

import java.util.List;

public class WaitNoticeListAdapter extends RecyclerView.Adapter<WaitNoticeListAdapter.TaskViewHolder> {
    private Context context;
    private List<TroubleListBean.DataBean> list;

    private OnItemClickListener listener;

    public WaitNoticeListAdapter(Context context, List<TroubleListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wait_notice_list, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TroubleListBean.DataBean bean = getItem(position);
        holder.tv_name.setText(bean.getRiskPointName());
        holder.tv_info.setText(TextUtils.isEmpty(bean.getHiddenDangersDescribe()) ? "暂无描述" : bean.getHiddenDangersDescribe());
        holder.tv_personnel.setText(bean.getTBUserName());
        holder.tv_level.setText(bean.getHiddenDangersLevel());
        holder.tv_time.setText(bean.getCreateTime());
        holder.ll_is_supervisor.setVisibility("1".equals(bean.getIsSupervisor()) ? View.VISIBLE : View.GONE);


        boolean b = MainApplication.getContext().isManagementPosition();

        //1未整改  2已整改 待复查  3已复查 通过  4已复查 未通过
        switch (bean.getStates()) {
            case "1":
                if (b) {
                    holder.tv_state.setText("待下发整改通知");
                } else {
                    holder.tv_state.setText("已上报");
                }
                break;
            case "2":
                holder.tv_state.setText("待复查");
                break;
            case "3":
                holder.tv_state.setText("已通过");
                break;
            case "4":
                holder.tv_state.setText("未通过");
                break;
            case "5":
                if (b) {
                    holder.tv_state.setText("整改通知已下发");
                } else {
                    holder.tv_state.setText("待整改");
                }
                break;
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(bean);
            }
        });
    }

    private TroubleListBean.DataBean getItem(int position) {
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
        void onItemClick(TroubleListBean.DataBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}