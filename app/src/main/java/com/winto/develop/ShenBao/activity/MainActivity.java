package com.winto.develop.ShenBao.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.UserInfoBean;
import com.winto.develop.ShenBao.dialog.MoreFunctionPopup;
import com.winto.develop.ShenBao.dialog.TwoButtonCenterDialog;
import com.winto.develop.ShenBao.fragment.FindFragment;
import com.winto.develop.ShenBao.fragment.HiddenTroubleFragment;
import com.winto.develop.ShenBao.fragment.HomeFragment;
import com.winto.develop.ShenBao.fragment.OperationFragment;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:欢迎页
 */

public class MainActivity extends BaseActivity {
    private String[] permissionList = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    private DrawerLayout dl_drawer;
    private View view_user_info;
    private ImageView iv_my;
    private TextView tv_title;
    private ImageView iv_msg;

    private TextView tv_user_name;
    private TextView tv_job_name;
    private TextView tv_role_name;
    private TextView tv_dep_name;
    private TextView tv_org_name;
    private TextView tv_log_out;

    private RadioGroup rg_main;
    private String[] titleArray = {"首页", "操作", "隐患上报记录", "统计"};
    private BaseFragment[] fragmentArray;
    private int currentIndex;

    private UserInfoBean.DataBean userInfo;

    private TwoButtonCenterDialog dialog;
    private LocationManager lm;

    @Override
    protected void initView() {
        dl_drawer = findViewById(R.id.dl_drawer);
        view_user_info = findViewById(R.id.view_user_info);
        tv_title = findViewById(R.id.tv_title);
        iv_my = findViewById(R.id.iv_my);
        iv_msg = findViewById(R.id.iv_msg);
        rg_main = findViewById(R.id.rg_main);
        tv_log_out = view_user_info.findViewById(R.id.tv_log_out);
        tv_user_name = view_user_info.findViewById(R.id.tv_user_name);
        tv_job_name = view_user_info.findViewById(R.id.tv_job_name);
        tv_role_name = view_user_info.findViewById(R.id.tv_role_name);
        tv_dep_name = view_user_info.findViewById(R.id.tv_dep_name);
        tv_org_name = view_user_info.findViewById(R.id.tv_org_name);
        view_user_info.setClickable(true);
        initFragment();

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        /*if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            ToastUtil.show(context, "定位可用");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkPermission(permissionList[0]) || checkPermission(permissionList[1])) {
                    initPermission();
                } else {
                    List<String> providers = lm.getProviders(true);
                    Location bestLocation = null;
                    for (String provider : providers) {
                        Location l = lm.getLastKnownLocation(provider);
                        if (l == null) {
                            continue;
                        }
                        if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                            // Found best last known location: %s", l);
                            bestLocation = l;
                        }
                    }
                }
            } else {
//                Location location = lm.getLastKnownLocation(locationProvider);
            }

        } else {
            ToastUtil.show(context, "定位不可用");
        }*/
    }

    private void initFragment() {
        fragmentArray = new BaseFragment[]{
                new HomeFragment(),
                new OperationFragment(),
                new FindFragment(),
                new HiddenTroubleFragment()
        };

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //设置为默认界面 MessageFragment
        ft.replace(R.id.fl_container, fragmentArray[0]);
        tv_title.setText(titleArray[0]);
        ft.commit();
    }

    @Override
    protected void initData() {
        getUserInfo();
    }

    @Override
    protected void initClick() {
        rg_main.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_home:
                    setIndexSelected(0);
                    break;
                case R.id.rb_operation:
                    setIndexSelected(1);
                    break;
                case R.id.rb_find:
                    setIndexSelected(2);
                    break;
                case R.id.rb_statistics:
                    setIndexSelected(3);
                    break;
            }
        });
        /*iv_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkPermission(permissionList[0]) || checkPermission(permissionList[1])) {
                        initPermission();
                    } else {
                        Location location = getLastKnownLocation();
                        ToastUtil.show(context, "位置信息正在变化，经纬度：" + location.getLongitude() + "/" + location.getLatitude());
                    }
                } else {
                    Location location = getLastKnownLocation();
                    ToastUtil.show(context, "位置信息正在变化，经纬度：" + location.getLongitude() + "/" + location.getLatitude());
                }
            }
        });*/

        view_user_info.setOnClickListener(v -> {

        });

        iv_my.setOnClickListener(v -> {
            if (userInfo == null) {
                getUserInfo();
            }
            dl_drawer.openDrawer(view_user_info);
        });

        iv_msg.setOnClickListener(v -> showMoreFunction());

        tv_log_out.setOnClickListener(v -> {
            isLogout = true;
            dl_drawer.closeDrawer(view_user_info);
        });
        dl_drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                if (isLogout) {
                    showLogoutDialog();
                    isLogout = false;
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private boolean isLogout = false;

    private void getUserInfo() {
        HttpAction.getInstance().getUserInfo().subscribe(new BaseObserver<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean bean) {
                userInfo = bean.getData();
                setUserInfo();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void setUserInfo() {
        if (userInfo == null) {
            return;
        }
        tv_user_name.setText(userInfo.getRealName());
        tv_job_name.setText(String.format("岗位：%s", userInfo.getJobName()));
        tv_role_name.setText(String.format("角色：%s", userInfo.getRoleName()));
        tv_dep_name.setText(String.format("部门：%s", userInfo.getDepName()));
        tv_org_name.setText(userInfo.getOrgName());
    }

    private void showLogoutDialog() {
        if (dialog == null) {
            dialog = new TwoButtonCenterDialog(context);
        }

        dialog.setTips("退出登录", "确定要退出当前账号吗?");
        dialog.show();
        dialog.setOnClickRateDialog(new TwoButtonCenterDialog.OnClickRateDialog() {
            @Override
            public void onClickLeft() {
                dialog.dismiss();
            }

            @Override
            public void onClickRight() {
                dialog.dismiss();
                MainApplication.getContext().setToken("");
                MainApplication.getContext().setRoleName("");
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                //关键的一句，将新的activity置为栈顶
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private MoreFunctionPopup popup;

    private void showMoreFunction() {
        if (popup == null) {
            popup = new MoreFunctionPopup(context, iv_msg);
        }
        popup.show();
        popup.setOnButtonClickListener(new MoreFunctionPopup.OnButtonClickListener() {
            @Override
            public void onMsgBtnClick() {
                if (MainApplication.getContext().isManagementPosition()) {
                    toClass(context, ReviewedHiddenListActivity.class);
                } else {
                    toClass(context, RectifiedHiddenListActivity.class);
                }
            }

            @Override
            public void onHistoryBtnClick() {
                if (MainApplication.getContext().isManagementPosition()) {
                    toClass(context, HistoryActivity.class);
                } else {
                    toClass(context, ReportedActivity.class);
                }
            }

            @Override
            public void onLogoutBtnClick() {
                MainApplication.getContext().setToken("");
                MainApplication.getContext().setRoleName("");
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                //关键的一句，将新的activity置为栈顶
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    //设置Fragment页面
    private void setIndexSelected(int index) {
        if (currentIndex == index) {
            return;
        }
        tv_title.setText(titleArray[index]);
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragmentArray[currentIndex]);
        //判断Fragment是否已经添加
        if (!fragmentArray[index].isAdded()) {
            ft.add(R.id.fl_container, fragmentArray[index]).show(fragmentArray[index]);
        } else {
            //显示新的Fragment
            ft.show(fragmentArray[index]);
        }
        ft.commit();
        currentIndex = index;
    }

    private LocationListener locationListener = new LocationListener() {


        @Override
        public void onLocationChanged(Location location) {

            ToastUtil.show(context, "位置信息正在变化，经纬度：" + location.getLongitude() + "/" + location.getLatitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.e("TAG", "onProviderEnabled: " + provider);
        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void initPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissionList[0]) || checkPermission(permissionList[1])) {
                ActivityCompat.requestPermissions(this, permissionList, 1);
            }
        }
    }

    private Location getLastKnownLocation() {
        lm = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = lm.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }

            Log.e("TAG", "getLastKnownLocation: " + provider);
        }
        return bestLocation;
    }

    private static double EARTH_RADIUS = 6378.137;

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));

        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }
}