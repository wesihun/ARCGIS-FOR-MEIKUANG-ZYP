package com.winto.develop.ShenBao;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainApplication extends Application {
    private static MainApplication application;
    private SharedPreferences preferences = null;
    public final static String TOKEN = "token";
    public final static String ROLE_NAME = "roleName";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ARouter.init(this);
        preferences = getSharedPreferences("ShenBao", MODE_PRIVATE);
    }

    public static MainApplication getContext() {
        return application;
    }

    public String getToken() {
        return preferences.getString(TOKEN, "");
    }

    public void setToken(@NonNull String token) {
        preferences.edit().putString(TOKEN, token).apply();
    }

    public String getRoleName() {
        return preferences.getString(ROLE_NAME, "");
    }

    public void setRoleName(@NonNull String roleName) {
        preferences.edit().putString(ROLE_NAME, roleName).apply();
    }

    public boolean isManagementPosition() {
        String roleName = MainApplication.getContext().getRoleName();
        return roleName.equals("班组长") || roleName.equals("部门(车间)负责人") || roleName.equals("公司经理级管理人员") || roleName.equals("系统管理员");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}