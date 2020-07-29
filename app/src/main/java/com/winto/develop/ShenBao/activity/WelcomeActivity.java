package com.winto.develop.ShenBao.activity;

import android.os.Handler;
import android.text.TextUtils;

import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.base.BaseActivity;


/**
 * Created by zyp on 2019/8/20 0020.
 * class note:欢迎页面
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void initView() {
        new Handler().postDelayed(this::gotoActivity, 2000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {

    }

    private void gotoActivity() {
        if (TextUtils.isEmpty(MainApplication.getContext().getToken())) {
            toClass(context, LoginActivity.class);
        } else {
            toClass(context, MainActivity.class);
        }
        finish();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }
}