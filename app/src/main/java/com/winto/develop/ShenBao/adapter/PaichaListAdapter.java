package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.PaichaListBean;

import java.util.List;

public class PaichaListAdapter extends BaseAdapter {

    private Context context;
    private List<PaichaListBean.DataBean> list;
    private OnBtnClickListener listener;

    public PaichaListAdapter(Context context, List<PaichaListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public PaichaListBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_paicha_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PaichaListBean.DataBean bean = getItem(position);
        holder.tv_name.setText(String.format("排查事项：%s", bean.getTroubleshootingItems()));
        holder.tv_risk_factor.setText(String.format("风险因素：%s", bean.getRiskFactor()));

        switch (bean.getRiskLevel()) {
            case "1":
                holder.tv_level.setText("重大风险");
                break;
            case "2":
                holder.tv_level.setText("较大风险");
                break;
            case "3":
                holder.tv_level.setText("一般风险");
                break;
            case "4":
                holder.tv_level.setText("低风险");
                break;
        }

        if (bean.getStates1().equals("0")) {
            holder.tv_ok.setText("通过");
            holder.tv_ok.setEnabled(true);
            holder.tv_no.setVisibility(View.VISIBLE);
        } else {
            holder.tv_ok.setText("已通过");
            holder.tv_ok.setEnabled(false);
            holder.tv_no.setVisibility(View.GONE);
        }

        if (bean.getStates2().equals("0")) {
            holder.tv_no.setText("隐患上报");
            holder.tv_no.setEnabled(true);
            holder.tv_ok.setVisibility(View.VISIBLE);
        } else {
            holder.tv_no.setText("已上报");
            holder.tv_no.setEnabled(false);
            holder.tv_ok.setVisibility(View.GONE);
        }

        if (bean.getStates1().equals("1") || bean.getStates2().equals("1")) {
            holder.tv_operation.setText("已检查");
            holder.tv_operation.setTextColor(ContextCompat.getColor(context, R.color.maincolor));
        } else {
            holder.tv_operation.setText("未检查");
            holder.tv_operation.setTextColor(ContextCompat.getColor(context, R.color.lightred));
        }

        holder.tv_ok.setOnClickListener(v -> {
            if (listener != null) {
                listener.onOkClick(bean);
            }
        });

        holder.tv_no.setOnClickListener(v -> {
            if (listener != null) {
                listener.onNoClick(bean);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        private TextView tv_name;
        private TextView tv_level;
        private TextView tv_ok;
        private TextView tv_no;
        private TextView tv_risk_factor;
        private TextView tv_operation;

        ViewHolder(View rootView) {
            this.tv_name = rootView.findViewById(R.id.tv_name);
            this.tv_level = rootView.findViewById(R.id.tv_level);
            this.tv_ok = rootView.findViewById(R.id.tv_ok);
            this.tv_no = rootView.findViewById(R.id.tv_no);
            this.tv_risk_factor = rootView.findViewById(R.id.tv_risk_factor);
            this.tv_operation = rootView.findViewById(R.id.tv_operation);
        }
    }

    public interface OnBtnClickListener {
        void onOkClick(PaichaListBean.DataBean bean);

        void onNoClick(PaichaListBean.DataBean bean);
    }

    public void setOnBtnClickListener(OnBtnClickListener listener) {
        this.listener = listener;
    }
}