package com.winto.develop.ShenBao.activity;

import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.MyPagerAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.fragment.CheckedHistoryFragment;
import com.winto.develop.ShenBao.fragment.NoticedHistoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2019/8/20 0020.
 * class note:历史记录
 */

public class HistoryActivity extends BaseActivity {

    private ImageView iv_back;
    private TabLayout tl_tab;
    private ViewPager vp_pager;

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tl_tab = findViewById(R.id.tl_tab);
        vp_pager = findViewById(R.id.vp_pager);
        initFragment();
    }

    private void initFragment() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        List<String> list_Title = new ArrayList<>();
        fragmentList.add(new NoticedHistoryFragment());
        fragmentList.add(new CheckedHistoryFragment());
        list_Title.add("已下发通知");
        list_Title.add("已复查");

        vp_pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), context, fragmentList, list_Title));
        tl_tab.setupWithViewPager(vp_pager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_history;
    }

}
