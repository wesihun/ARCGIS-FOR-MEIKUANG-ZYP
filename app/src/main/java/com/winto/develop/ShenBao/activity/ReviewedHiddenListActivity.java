package com.winto.develop.ShenBao.activity;

import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.MyPagerAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.fragment.WaitRecheckListFragment;
import com.winto.develop.ShenBao.fragment.RectifiedListFragment;
import com.winto.develop.ShenBao.fragment.WaitNoticeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:通知列表
 */

public class ReviewedHiddenListActivity extends BaseActivity {

    private ImageView iv_back;
    private TabLayout tl_tab;
    private ViewPager vp_pager;
    private int pageType = 0;

    @Override
    protected void initIntentData() {
        pageType = getIntent().getIntExtra("pageType", 0);
    }

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
        fragmentList.add(new RectifiedListFragment());
        fragmentList.add(new WaitNoticeFragment());
        fragmentList.add(new WaitRecheckListFragment());
        list_Title.add("待整改");
        list_Title.add("待通知");
        list_Title.add("待复查");
        vp_pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), context, fragmentList, list_Title));
        tl_tab.setupWithViewPager(vp_pager);
        vp_pager.setCurrentItem(pageType);
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
        return R.layout.activity_reviewed_hidden_list;
    }
}