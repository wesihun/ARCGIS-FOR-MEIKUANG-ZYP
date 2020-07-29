package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.bean.HiddenTJBean;

import java.util.List;

public class CountDataListAdapter extends BaseAdapter {
    private Context context;
    private List<HiddenTJBean.DataBean> list;

    public CountDataListAdapter(Context context, List<HiddenTJBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_trouble_cate_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HiddenTJBean.DataBean bean = getItem(position);
        holder.tv_order.setText(String.valueOf(position + 1));
        holder.tv_name.setText(bean.getName());
        holder.tv_count.setText(String.valueOf(bean.getCount()));
        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public HiddenTJBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_order;
        public TextView tv_name;
        public TextView tv_count;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_order = (TextView) rootView.findViewById(R.id.tv_order);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_count = (TextView) rootView.findViewById(R.id.tv_count);
        }

    }
}