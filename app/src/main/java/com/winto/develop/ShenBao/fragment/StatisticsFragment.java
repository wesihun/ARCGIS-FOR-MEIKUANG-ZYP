package com.winto.develop.ShenBao.fragment;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.MyPagerAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends BaseFragment {

    private TabLayout tl_tab;
    private ViewPager vp_pager;

    @Override
    protected void initView() {
        tl_tab = findViewById(R.id.tl_tab);
        vp_pager = findViewById(R.id.vp_pager);

        initFragment();
    }

    private void initFragment() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        List<String> list_Title = new ArrayList<>();
        fragmentList.add(new HiddenTroubleFragment());
        fragmentList.add(new CheckFragment());
        list_Title.add("隐患");
        list_Title.add("检查");
        vp_pager.setAdapter(new MyPagerAdapter(getFragmentManager(), context, fragmentList, list_Title));
        tl_tab.setupWithViewPager(vp_pager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_statistics;
    }
}
