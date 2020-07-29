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
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.dialog.MoreFunctionPopup;
import com.winto.develop.ShenBao.fragment.HiddenTroubleFragment;
import com.winto.develop.ShenBao.fragment.HomeFragment;
import com.winto.develop.ShenBao.fragment.OperationFragment;
import com.winto.develop.ShenBao.fragment.FindFragment;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:欢迎页
 */

public class MainActivity extends BaseActivity {
    private String[] permissionList = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    private TextView tv_title;
    private ImageView iv_msg;
    private RadioGroup rg_main;
    private String[] titleArray = {"首页", "操作", "我上报的", "统计"};
    private BaseFragment[] fragmentArray;
    private int currentIndex;

    private LocationManager lm;

    @Override
    protected void initView() {
        tv_title = findViewById(R.id.tv_title);
        iv_msg = findViewById(R.id.iv_msg);
        rg_main = findViewById(R.id.rg_main);

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
    }

    @Override
    protected void initClick() {

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

        iv_msg.setOnClickListener(v -> showMoreFunction());
    }

    private MoreFunctionPopup popup;

    private void showMoreFunction() {
        if (popup == null) {
            popup = new MoreFunctionPopup(context, iv_msg, MainApplication.getContext().isManagementPosition());
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
                toClass(context, HistoryActivity.class);
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