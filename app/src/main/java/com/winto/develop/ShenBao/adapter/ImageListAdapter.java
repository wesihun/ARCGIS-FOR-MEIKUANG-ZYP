package com.winto.develop.ShenBao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.luck.picture.lib.entity.LocalMedia;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.util.GlideUtil;

import java.util.List;

public class ImageListAdapter extends BaseAdapter {
    private Context context;
    private List<LocalMedia> list;

    public ImageListAdapter(Context context, List<LocalMedia> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public LocalMedia getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_image_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        LocalMedia bean = getItem(position);
        GlideUtil.displayImage(context, bean.getPath(), holder.iv_image);

        return convertView;
    }


    static class ViewHolder {
        private ImageView iv_image;

        ViewHolder(View rootView) {
            this.iv_image = rootView.findViewById(R.id.iv_image);
        }
    }
}
