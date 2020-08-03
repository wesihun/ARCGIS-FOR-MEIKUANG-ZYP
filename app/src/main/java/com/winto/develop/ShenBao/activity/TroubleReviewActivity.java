package com.winto.develop.ShenBao.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.winto.develop.ShenBao.constant.ConstantData;
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
 * class note:隐患复查
 */

public class TroubleReviewActivity extends BaseActivity {

    private ImageView iv_back;
    private RelativeLayout rl_title;
    private TextView tv_id;
    private TextView tv_info_label;
    private TextView tv_trouble_info;
    private RelativeLayout rl_trouble_info;
    private TextView tv_type;
    private TextView tv_time;
    private TextView tv_level;
    private TextView tv_preson;
    private TextView tv_money_label;
    private TextView tv_personnel;
    private TextView tv_state;
    private TextView tv_info;
    private TextView tv_result;
    private CustomGridView gv_image_list;
    private TextView tv_check_result;
    private EditText et_check_result;
    private TextView tv_check_proposal;
    private EditText et_check_proposal;
    private TextView tv_check_note;
    private EditText et_check_note;
    private TextView tv_image_label;
    private TextView tv_choose_image;
    private CustomGridView gv_choose_image_list;
    private TextView tv_choose;
    private TextView tv_ok;

    private ItemPicker picker;

    private List<LocalMedia> imageList;
    private ImageListAdapter chooseImageAdapter;
    private ImageListAdapter imageAdapter;

    private String ReportId;
    private String ModifyUserId;
    private String ModifyUserName;
    private String ModifyStates;
    private String ModifySituation;
    private String ModifyResult;
    private String HiddenDangersDescribe;
    private String RiskBH;
    private String RiskName;
    private String CreateTime;
    private String ImageUrl;
    private int ReFlag;

    @Override
    protected void initIntentData() {
        ReportId = getIntent().getStringExtra("ReportId");
        ModifyUserId = getIntent().getStringExtra("ModifyUserId");
        ModifyUserName = getIntent().getStringExtra("ModifyUserName");
        ModifyStates = getIntent().getStringExtra("ModifyStates");
        ModifySituation = getIntent().getStringExtra("ModifySituation");
        ModifyResult = getIntent().getStringExtra("ModifyResult");
        ImageUrl = getIntent().getStringExtra("ImageUrl");
        HiddenDangersDescribe = getIntent().getStringExtra("HiddenDangersDescribe");
        RiskBH = getIntent().getStringExtra("RiskBH");
        RiskName = getIntent().getStringExtra("RiskName");
        CreateTime = getIntent().getStringExtra("CreateTime");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        rl_title = findViewById(R.id.rl_title);
        tv_id = findViewById(R.id.tv_id);
        tv_info_label = findViewById(R.id.tv_info_label);
        tv_trouble_info = findViewById(R.id.tv_trouble_info);
        rl_trouble_info = findViewById(R.id.rl_trouble_info);
        tv_type = findViewById(R.id.tv_type);
        tv_time = findViewById(R.id.tv_time);
        tv_level = findViewById(R.id.tv_level);
        tv_preson = findViewById(R.id.tv_preson);
        tv_money_label = findViewById(R.id.tv_money_label);
        tv_personnel = findViewById(R.id.tv_personnel);
        tv_state = findViewById(R.id.tv_state);
        tv_info = findViewById(R.id.tv_info);
        tv_result = findViewById(R.id.tv_result);
        gv_image_list = findViewById(R.id.gv_image_list);
        tv_check_result = findViewById(R.id.tv_check_result);
        et_check_result = findViewById(R.id.et_check_result);
        tv_check_proposal = findViewById(R.id.tv_check_proposal);
        et_check_proposal = findViewById(R.id.et_check_proposal);
        tv_check_note = findViewById(R.id.tv_check_note);
        et_check_note = findViewById(R.id.et_check_note);
        tv_image_label = findViewById(R.id.tv_image_label);
        tv_choose_image = findViewById(R.id.tv_choose_image);
        gv_choose_image_list = findViewById(R.id.gv_choose_image_list);
        tv_choose = findViewById(R.id.tv_choose);
        tv_ok = findViewById(R.id.tv_ok);

        setPage();
    }

    private void setPage() {
//        tv_trouble_info.setText(trouble.getTroubleName());
        tv_id.setText(RiskBH);
        tv_trouble_info.setText(HiddenDangersDescribe);
        tv_type.setText(RiskName);
        tv_time.setText(CreateTime);

        tv_personnel.setText(ModifyUserName);
        tv_state.setText(ModifyStates);
        tv_info.setText(ModifySituation);
        tv_result.setText(ModifyResult);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAdapter() {
        imageList = new ArrayList<>();
        chooseImageAdapter = new ImageListAdapter(context, imageList);
        gv_choose_image_list.setAdapter(chooseImageAdapter);

        if (TextUtils.isEmpty(ImageUrl)) {
            return;
        }
        String[] imageArray = ImageUrl.split(",");
        List<LocalMedia> list = new ArrayList<>();
        for (String s : imageArray) {
            LocalMedia media = new LocalMedia(ConstantData.IMAGE_URL + s, 0, 0, "");
            list.add(media);
        }
        imageAdapter = new ImageListAdapter(context, list);
        gv_image_list.setAdapter(imageAdapter);
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(v -> finish());

        tv_level.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("低风险");
            itemList.add("一般风险");
            itemList.add("较大风险");
            itemList.add("重大风险");
            initPicker(itemList, tv_level);
        });

        tv_preson.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("李某某");
            itemList.add("张某某");
            itemList.add("刘某某");
            itemList.add("王某某");
            itemList.add("周某某");
            initPicker(itemList, tv_preson);
        });

        tv_choose_image.setOnClickListener(v -> choosePicture());

        gv_choose_image_list.setOnItemLongClickListener((parent, view, position, id) -> {
            imageList.remove(position);
            chooseImageAdapter.notifyDataSetChanged();
//            showTips();
            return false;
        });

        tv_choose.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("合格");
            itemList.add("不合格");
            initPicker(itemList, tv_choose);
        });

        tv_ok.setOnClickListener(v -> {
            if (TextUtils.isEmpty(et_check_result.getText().toString().trim())) {
                ToastUtil.show(context, "请填写验收结果");
                return;
            }
            if (TextUtils.isEmpty(et_check_proposal.getText().toString().trim())) {
                ToastUtil.show(context, "请填写复查建议");
                return;
            }
            if (tv_choose.getText().toString().equals("请选择")) {
                ToastUtil.show(context, "请选择整改是否合格");
                return;
            }
            confirm();
        });
    }

    private void confirm() {
        WaitUI.show(context);
        Map<String, String> params = new HashMap<>();
        params.put("ReportId", ReportId);
        params.put("Result", et_check_result.getText().toString().trim());
        params.put("ReProposal", et_check_proposal.getText().toString().trim());
        params.put("States", String.valueOf(ReFlag));
        params.put("Remark", et_check_note.getText().toString().trim());
        params.put("ReportUserId", ModifyUserId);
        params.put("ReportUserName", ModifyUserName);

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
        HttpAction.getInstance().createRecheck(parts, params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                WaitUI.cancel();
                ToastUtil.show(context, "复查结果提交成功");
                finish();
            }

            @Override
            public void onError(String message) {
                WaitUI.cancel();
//                ToastUtil.show(context, message);
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
            if (type.equals("合格")) {
                ReFlag = 3;
            } else {
                ReFlag = 4;
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
//            upLoad2Server(selectList.get(0).getPath());
//            upload(selectList);
            imageList.addAll(selectList);
            chooseImageAdapter.notifyDataSetChanged();
        }
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

    @Override
    protected int setLayout() {
        return R.layout.activity_trouble_review;
    }
}