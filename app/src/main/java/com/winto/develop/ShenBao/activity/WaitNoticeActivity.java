package com.winto.develop.ShenBao.activity;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luck.picture.lib.entity.LocalMedia;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.ImageListAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.base.BaseResponse;
import com.winto.develop.ShenBao.bean.ChoosePersonListBean;
import com.winto.develop.ShenBao.bean.HiddenLevelBean;
import com.winto.develop.ShenBao.bean.TroubleListBean;
import com.winto.develop.ShenBao.constant.ConstantData;
import com.winto.develop.ShenBao.dialog.WaitUI;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.MoneyUtil;
import com.winto.develop.ShenBao.util.ToastUtil;
import com.winto.develop.ShenBao.wight.CustomGridView;
import com.winto.develop.ShenBao.wight.ItemPicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:下发隐患整改通知
 */

public class WaitNoticeActivity extends BaseActivity {

    private ImageView iv_back;
    private TextView tv_id;
    private TextView tv_trouble_info;
    private TextView tv_personnel;
    private TextView tv_type;
    private TextView tv_time;
    private TextView tv_level;
    private RelativeLayout rl_is_supervisor;
    private CustomGridView gv_image_list;
    private EditText et_money;
    private EditText tv_method;
    private TextView tv_look;
    private TextView tv_report;
    private TextView tv_ok;

    private ItemPicker picker;
    private ItemPicker personPicker;
    private List<LocalMedia> imageList;
    private ImageListAdapter imageAdapter;
    private TroubleListBean.DataBean trouble;

    private List<HiddenLevelBean.DataBean> hiddenLevelList;
    private String hiddenLevel;

    @Override
    protected void initIntentData() {
        trouble = (TroubleListBean.DataBean) getIntent().getSerializableExtra("trouble");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_id = findViewById(R.id.tv_id);
        tv_trouble_info = findViewById(R.id.tv_trouble_info);
        tv_personnel = findViewById(R.id.tv_personnel);
        tv_type = findViewById(R.id.tv_type);
        tv_time = findViewById(R.id.tv_time);
        tv_level = findViewById(R.id.tv_level);
        rl_is_supervisor = findViewById(R.id.rl_is_supervisor);
        gv_image_list = findViewById(R.id.gv_image_list);
        et_money = findViewById(R.id.et_money);
        tv_method = findViewById(R.id.tv_method);
        tv_look = findViewById(R.id.tv_look);
        tv_report = findViewById(R.id.tv_report);
        tv_ok = findViewById(R.id.tv_ok);
        MoneyUtil.setPricePoint(et_money);
        setPage();
    }

    private void setPage() {
        tv_id.setText(trouble.getRiskPointBH());
        tv_trouble_info.setText(trouble.getHiddenDangersDescribe());
        tv_personnel.setText(trouble.getTBUserName());
        tv_type.setText(trouble.getHiddenDangersType());
        tv_time.setText(trouble.getCreateTime());
        tv_level.setText(trouble.getHiddenDangersLevel());
        if ("1".equals(trouble.getIsSupervisor())) {
            rl_is_supervisor.setVisibility(View.VISIBLE);
        } else {
            rl_is_supervisor.setVisibility(View.GONE);
        }
        if (1 == trouble.getPushMark()) {
            tv_report.setVisibility(View.GONE);
        } else {
            tv_report.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initData() {
        getHiddenLevel();
    }

    @Override
    protected void initAdapter() {
        imageList = new ArrayList<>();
        String imageUrlStr = trouble.getImageUrl();
        if (TextUtils.isEmpty(imageUrlStr)) {
            return;
        }
        String[] imageUrls = imageUrlStr.split(",");
        for (String imageUrl : imageUrls) {
            LocalMedia localMedia = new LocalMedia(ConstantData.IMAGE_URL + imageUrl, 0, 0, "");
            imageList.add(localMedia);
        }
        imageAdapter = new ImageListAdapter(context, imageList);
        gv_image_list.setAdapter(imageAdapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());

        tv_level.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            for (int i = 0; i < hiddenLevelList.size(); i++) {
                itemList.add(hiddenLevelList.get(i).getItemName());
            }
            initPicker(itemList, tv_level);
        });

        tv_report.setOnClickListener(v -> {
//            ToastUtil.show(context, "功能待完善");
            report();
        });

        tv_ok.setOnClickListener(v -> {
            if (tv_level.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择风险等级");
                return;
            }
            if (TextUtils.isEmpty(tv_method.getText().toString().trim())) {
                ToastUtil.show(context, "请输入治理方法");
                return;
            }
            commitNotice();
        });
    }

    private void commitNotice() {
        WaitUI.show(context);
        Map<String, String> params = new HashMap<>();
        params.put("ReportId", trouble.getId());
        params.put("HiddenDangerLevel", hiddenLevel);
        params.put("PersonId", trouble.getTBUserId());
        params.put("PersonName", trouble.getTBUserName());
        params.put("Method", tv_method.getText().toString().trim());
        params.put("ZRRId", trouble.getZRR());
        params.put("ZRRName", trouble.getZRRName());

        HttpAction.getInstance().createNotice(params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                WaitUI.cancel();
                ToastUtil.show(context, "通知下发成功");
                finish();
            }

            @Override
            public void onError(String message) {
                WaitUI.cancel();
                ToastUtil.show(context, message);
            }
        });
    }

    private void report() {
        HttpAction.getInstance().getSafeUserList().subscribe(new BaseObserver<ChoosePersonListBean>() {
            @Override
            public void onSuccess(ChoosePersonListBean bean) {
                initPersonPicker(bean.getData());
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void initPersonPicker(List<ChoosePersonListBean.DataBean> data) {
        if (personPicker == null) {
            personPicker = new ItemPicker(context);
        }
        List<String> list = new ArrayList<>();
        list.clear();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getUserName());
        }
        personPicker.setItemData(list);
        personPicker.show();
        personPicker.setTypeListener((type, position) -> {
            String personId = data.get(position).getUserId();
            pushSafeDepart(personId);
        });
    }

    private void pushSafeDepart(String zrrId) {
        WaitUI.show(context);
        Map<String, String> params = new HashMap<>();
        params.put("id", trouble.getId());
        params.put("zrrid", zrrId);
        HttpAction.getInstance().pushSafeDepart(params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                WaitUI.cancel();
                ToastUtil.show(context, "隐患上报成功");
                finish();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void initPicker(List<String> itemList, TextView tv) {
        if (picker == null) {
            picker = new ItemPicker(context);
        }
        picker.setItemData(itemList);
        picker.show();
        picker.setTypeListener((type, position) -> {
            tv.setText(type);
            hiddenLevel = hiddenLevelList.get(position).getItemCode();
        });
    }

    private void getHiddenLevel() {
        Map<String, Object> params = new ArrayMap<>();
        params.put("condition", "DataType");
        params.put("keyWord", "003");
        params.put("page", 1);
        params.put("limit", 100);
        HttpAction.getInstance().getHiddenType(params).subscribe(new BaseObserver<HiddenLevelBean>() {
            @Override
            public void onSuccess(HiddenLevelBean bean) {
                hiddenLevelList = bean.getData();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_wait_notice;
    }
}