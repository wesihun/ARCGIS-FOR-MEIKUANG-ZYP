package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.RectifiedHiddenListBean;
import com.winto.develop.ShenBao.bean.TableListBean;

import java.util.List;

public class TroubleTableListAdapter extends RecyclerView.Adapter<TroubleTableListAdapter.TableViewHolder> {
    private Context context;
    private List<TableListBean> list;

    private OnItemClickListener listener;

    public TroubleTableListAdapter(Context context, List<TableListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table_children, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        TableListBean bean = getItem(position);
        holder.tv_department.setText(bean.getDepartmentName());
        holder.tv_total_num.setText(bean.getGfxNum() + "");
        holder.tv_dzg_num.setText(bean.getDzgNum() + "");
        holder.tv_dfc_num.setText(bean.getDfcNum() + "");
        holder.tv_ybh_num.setText(bean.getYbhNum() + "");
        holder.tv_zgl_num.setText(bean.getZglNum());
    }

    private TableListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TableViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_department;
        private TextView tv_total_num;
        private TextView tv_dzg_num;
        private TextView tv_dfc_num;
        private TextView tv_ybh_num;
        private TextView tv_zgl_num;

        TableViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_department = itemView.findViewById(R.id.tv_department);
            tv_total_num = itemView.findViewById(R.id.tv_total_num);
            tv_dzg_num = itemView.findViewById(R.id.tv_dzg_num);
            tv_dfc_num = itemView.findViewById(R.id.tv_dfc_num);
            tv_ybh_num = itemView.findViewById(R.id.tv_ybh_num);
            tv_zgl_num = itemView.findViewById(R.id.tv_zgl_num);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(RectifiedHiddenListBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
