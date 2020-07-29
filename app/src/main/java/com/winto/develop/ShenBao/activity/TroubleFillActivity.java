package com.winto.develop.ShenBao.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.ImageListAdapter;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.base.BaseResponse;
import com.winto.develop.ShenBao.bean.HiddenLevelBean;
import com.winto.develop.ShenBao.bean.PaichaListBean;
import com.winto.develop.ShenBao.dialog.WaitUI;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.GlideEngine;
import com.winto.develop.ShenBao.util.RandomUtil;
import com.winto.develop.ShenBao.util.ToastUtil;
import com.winto.develop.ShenBao.wight.CustomGridView;
import com.winto.develop.ShenBao.wight.ItemPicker;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:隐患填报
 */

public class TroubleFillActivity extends BaseActivity {

    private ImageView iv_back;
    private TextView tv_choose_process;
    private TextView et_choose_name;
    private EditText et_id;
    private EditText et_base_info;
    private TextView tv_choose_type;
    private TextView tv_choose_head;
    private TextView tv_choose_department;
    private EditText et_demand;
    private EditText et_position;
    private EditText et_trouble_type;
    private TextView tv_choose_level;
    private TextView tv_choose_date;
    private TextView tv_choose_time_limit;
    private TextView tv_choose_attachment;
    private EditText tv_troubleshooting_item;
    private EditText tv_risk_factor;
    private TextView tv_choose_image;
    private CustomGridView gv_image_list;
    private Button btn_confirm;

    private ItemPicker picker;
    private ItemPicker hiddenLevelPicker;
    private PaichaListBean.DataBean bean;
    private String id;
    private String riskPointName;
    private String riskId;
    private String riskLevel;

    private List<HiddenLevelBean.DataBean> hiddenLevelList;
    private String hiddenLevel;

    private List<HiddenLevelBean.DataBean> accidentTypeList;
    private String accidentType;

    private List<LocalMedia> imageList;
    private ImageListAdapter imageAdapter;

    @Override
    protected void initIntentData() {
        bean = (PaichaListBean.DataBean) getIntent().getSerializableExtra("paicha");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_choose_process = findViewById(R.id.tv_choose_process);
        et_choose_name = findViewById(R.id.et_choose_name);
        et_id = findViewById(R.id.et_id);
        et_base_info = findViewById(R.id.et_base_info);
        tv_choose_type = findViewById(R.id.tv_choose_type);
        tv_choose_head = findViewById(R.id.tv_choose_head);
        tv_choose_department = findViewById(R.id.tv_choose_department);
        et_demand = findViewById(R.id.et_demand);
        et_position = findViewById(R.id.et_position);
        et_trouble_type = findViewById(R.id.et_trouble_type);
        tv_troubleshooting_item = findViewById(R.id.tv_troubleshooting_item);
        tv_risk_factor = findViewById(R.id.tv_risk_factor);
        tv_choose_level = findViewById(R.id.tv_choose_level);
        tv_choose_date = findViewById(R.id.tv_choose_date);
        tv_choose_time_limit = findViewById(R.id.tv_choose_time_limit);
        tv_choose_attachment = findViewById(R.id.tv_choose_attachment);
        tv_choose_image = findViewById(R.id.tv_choose_image);
        gv_image_list = findViewById(R.id.gv_image_list);
        btn_confirm = findViewById(R.id.btn_confirm);
        setPage();
    }

    @Override
    protected void initData() {
        getHiddenLevel("003");
        getHiddenLevel("005");
    }

    @Override
    protected void initAdapter() {
        imageList = new ArrayList<>();
        imageAdapter = new ImageListAdapter(context, imageList);
        gv_image_list.setAdapter(imageAdapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());

        tv_choose_process.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("流程一");
            itemList.add("流程二");
            itemList.add("流程三");
            initPicker(itemList, tv_choose_process);
        });

        tv_choose_type.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            for (int i = 0; i < accidentTypeList.size(); i++) {
                itemList.add(accidentTypeList.get(i).getItemName());
            }
            initHiddenLevelPicker(itemList, "005", tv_choose_type);
        });

        tv_choose_head.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("李");
            itemList.add("张");
            itemList.add("刘");
            itemList.add("王");
            itemList.add("周");
            initPicker(itemList, tv_choose_head);
        });

        tv_choose_department.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("电工室/主任");
            itemList.add("电工室/电工");
            itemList.add("电工室/主任");
            itemList.add("采矿部/技术负责人");
            itemList.add("爆破公司/负责人");
            itemList.add("车队/挖掘机司机");
            itemList.add("车队/铲装司机");
            itemList.add("采矿部/部长");
            initPicker(itemList, tv_choose_department);
        });

        tv_choose_level.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            for (int i = 0; i < hiddenLevelList.size(); i++) {
                itemList.add(hiddenLevelList.get(i).getItemName());
            }
            initHiddenLevelPicker(itemList, "003", tv_choose_level);
        });

        tv_choose_image.setOnClickListener(v -> choosePicture());

        btn_confirm.setOnClickListener(v -> {
            /*if (tv_choose_process.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择流程");
                return;
            }*/
            if (TextUtils.isEmpty(et_choose_name.getText().toString().trim())) {
                ToastUtil.show(context, "请输入风险点名称");
                return;
            }
            if (TextUtils.isEmpty(et_id.getText().toString())) {
                ToastUtil.show(context, "请输入风险点编号");
                return;
            }
            if (TextUtils.isEmpty(et_id.getText().toString())) {
                ToastUtil.show(context, "请输入隐患基本情况");
                return;
            }
            /*if (tv_choose_head.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择整改负责人");
                return;
            }*/
            /*if (tv_choose_department.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择整改负责部门");
                return;
            }*/
            /*if (TextUtils.isEmpty(et_demand.getText().toString())) {
                ToastUtil.show(context, "请输入整改要求");
                return;
            }*/
            if (tv_choose_level.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择隐患级别");
                return;
            }
            confirm();
        });

        gv_image_list.setOnItemLongClickListener((parent, view, position, id) -> {
            imageList.remove(position);
            imageAdapter.notifyDataSetChanged();
            return false;
        });
    }

    private void choosePicture() {
        PictureSelector.create(this).openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .imageSpanCount(4)
                .isCamera(true)
                .selectionMode(PictureConfig.MULTIPLE)
                .previewImage(true)
                .withAspectRatio(1, 1)
                .compress(true)
                .compressQuality(55)
                .freeStyleCropEnabled(true)
                .rotateEnabled(false)
                .isDragFrame(true)
                .openClickSound(false)
                .forResult(PictureConfig.CHOOSE_REQUEST_IMAGE);
    }

    private void setPage() {
        if (bean == null) {
            return;
        }

        et_choose_name.setText(bean.getRiskPointName());
        et_choose_name.setEnabled(false);
        et_id.setText(bean.getRiskPointBH());
        et_id.setEnabled(false);
        tv_troubleshooting_item.setText(bean.getTroubleshootingItems());
        tv_troubleshooting_item.setEnabled(false);
        tv_risk_factor.setText(bean.getRiskFactor());
        tv_risk_factor.setEnabled(false);
//        tv_choose_level.setText(bean.getRiskLevel());
    }

    private void initPicker(List<String> itemList, TextView tv) {
        if (picker == null) {
            picker = new ItemPicker(context);
        }
        picker.setItemData(itemList);
        picker.show();
        picker.setTypeListener((type, position) -> tv.setText(type));
    }

    private void initHiddenLevelPicker(List<String> itemList, String keyWord, TextView textView) {
        if (hiddenLevelPicker == null) {
            hiddenLevelPicker = new ItemPicker(context);
        }
        hiddenLevelPicker.setItemData(itemList);
        hiddenLevelPicker.show();
        hiddenLevelPicker.setTypeListener((type, position) -> {
            textView.setText(type);
            if ("003".equals(keyWord)) {
                hiddenLevel = hiddenLevelList.get(position).getItemCode();
            } else if ("005".equals(keyWord)) {
                accidentType = accidentTypeList.get(position).getItemName();
            }
        });
    }

    private void confirm() {
        WaitUI.show(context);
        Map<String, String> params = new HashMap<>();
        params.put("CheckTableId", bean.getId());
        params.put("Position", et_position.getText().toString().trim());
        params.put("RiskPointBH", bean.getRiskPointBH());
        params.put("RiskPointLevel", bean.getRiskLevel());
        params.put("RiskPointName", bean.getRiskPointName());
        params.put("HiddenDangersLevel", hiddenLevel);
        params.put("HiddenDangersType", accidentType);
        params.put("HiddenDangersDescribe", et_base_info.getText().toString().trim());

        List<MultipartBody.Part> parts = null;
        if (imageList != null && imageList.size() > 0) {
            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (int i = 0; i < imageList.size(); i++) {
                File file = new File(imageList.get(i).getPath());
                RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                String uploadName = RandomUtil.getNumLargeSmallLetter(8) + i + "_" + new Date().getTime() + "." + file.getName().substring(file.getName().lastIndexOf(".") + 1);
                builder.addFormDataPart("files", uploadName, imageBody);
            }
            parts = builder.build().parts();
        }
        HttpAction.getInstance().hiddenReport(parts, params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                WaitUI.cancel();
                ToastUtil.show(context, "隐患上报成功");
                finish();
            }

            @Override
            public void onError(String message) {
                WaitUI.cancel();
                ToastUtil.show(context, message);
            }
        });
    }

    private void getHiddenLevel(String keyWord) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("condition", "DataType");
        params.put("keyWord", keyWord);
        params.put("page", 1);
        params.put("limit", 100);
        HttpAction.getInstance().getHiddenType(params).subscribe(new BaseObserver<HiddenLevelBean>() {
            @Override
            public void onSuccess(HiddenLevelBean bean) {
                if ("003".equals(keyWord)) {
                    hiddenLevelList = bean.getData();
                } else if ("005".equals(keyWord)) {
                    accidentTypeList = bean.getData();
                }
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == PictureConfig.CHOOSE_REQUEST_IMAGE) {
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
            if (selectList == null || selectList.size() == 0) {
                return;
            }
            imageList.addAll(selectList);
            imageAdapter.notifyDataSetChanged();
        }
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_trouble_fill;
    }
}