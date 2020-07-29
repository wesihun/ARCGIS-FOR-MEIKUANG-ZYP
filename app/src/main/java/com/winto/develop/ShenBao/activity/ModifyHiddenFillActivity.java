package com.winto.develop.ShenBao.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import com.winto.develop.ShenBao.bean.RectifiedHiddenListBean;
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
 * class note:整改信息填报
 */

public class ModifyHiddenFillActivity extends BaseActivity {

    private ImageView iv_back;
    private TextView tv_hidden_info;
    private TextView tv_level;
    private TextView tv_risk_name;
    private TextView tv_risk_id;
    private TextView tv_method;
    private TextView tv_tips;
    private TextView tv_image_upload;
    private TextView tv_recheck_result;
    private TextView tv_choose_result;
    private TextView tv_recheck_proposal;
    private TextView tv_recheck_time;
    private RelativeLayout rl_reason;
    private CustomGridView gv_image_list;
    private EditText et_modify_state;
    private EditText et_modify_info;
    private EditText et_modify_result;
    private EditText et_process;
    private Button btn_ok;

    private ItemPicker picker;
    private List<LocalMedia> imageList;
    private ImageListAdapter imageAdapter;

    private RectifiedHiddenListBean.DataBean hidden;

    @Override
    protected void initIntentData() {
        super.initIntentData();
        hidden = (RectifiedHiddenListBean.DataBean) getIntent().getSerializableExtra("hidden");
    }

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_hidden_info = findViewById(R.id.tv_hidden_info);
        tv_level = findViewById(R.id.tv_level);
        tv_risk_name = findViewById(R.id.tv_risk_name);
        tv_risk_id = findViewById(R.id.tv_risk_id);
        tv_method = findViewById(R.id.tv_method);
        tv_tips = findViewById(R.id.tv_tips);
        tv_image_upload = findViewById(R.id.tv_image_upload);
        tv_recheck_result = findViewById(R.id.tv_recheck_result);
        tv_choose_result = findViewById(R.id.tv_choose_result);
        tv_recheck_proposal = findViewById(R.id.tv_recheck_proposal);
        tv_recheck_time = findViewById(R.id.tv_recheck_time);
        rl_reason = findViewById(R.id.rl_reason);
        gv_image_list = findViewById(R.id.gv_image_list);
        et_modify_state = findViewById(R.id.et_modify_state);
        et_modify_info = findViewById(R.id.et_modify_info);
        et_modify_result = findViewById(R.id.et_modify_result);
        et_process = findViewById(R.id.et_process);
        btn_ok = findViewById(R.id.btn_ok);
        setPage();
    }

    @Override
    protected void initData() {

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

        tv_image_upload.setOnClickListener(v -> choosePicture());

        gv_image_list.setOnItemLongClickListener((parent, view, position, id) -> {
            imageList.remove(position);
            imageAdapter.notifyDataSetChanged();
            showTips();
            return false;
        });

        tv_choose_result.setOnClickListener(v -> {
            List<String> itemList = new ArrayList<>();
            itemList.add("已整改");
            itemList.add("未整改");
            initPicker(itemList, tv_choose_result);
        });

        btn_ok.setOnClickListener(v -> {
            /*if (TextUtils.isEmpty(et_modify_state.getText().toString().trim())) {
                ToastUtil.show(context, "请填写整改状态");
                return;
            }
            if (TextUtils.isEmpty(et_modify_info.getText().toString().trim())) {
                ToastUtil.show(context, "请填写整改情况");
                return;
            }*/
            if ("请选择".equals(tv_choose_result.getText().toString().trim())) {
                ToastUtil.show(context, "请选择整改结果");
                return;
            }
            /*if (TextUtils.isEmpty(et_process.getText().toString().trim())) {
                ToastUtil.show(context, "请填写整改流程");
                return;
            }*/
            confirm();
        });
    }

    private void setPage() {
        tv_hidden_info.setText(hidden.getHiddenDangersDescribe());
        tv_level.setText(hidden.getHiddenDangerLevel());
        tv_risk_name.setText(hidden.getRiskName());
        tv_risk_id.setText(hidden.getRiskBH());
        tv_method.setText(hidden.getMethod());
        if ("4".equals(hidden.getStates())) {
            rl_reason.setVisibility(View.VISIBLE);
            tv_recheck_result.setText(hidden.getResult());
            tv_recheck_proposal.setText(hidden.getReProposal());
            tv_recheck_time.setText(hidden.getReTime());
            btn_ok.setText("重新提交");
        } else {
            rl_reason.setVisibility(View.GONE);
            btn_ok.setText("提交");
        }
    }

    private void confirm() {
        WaitUI.show(context);
        Map<String, String> params = new HashMap<>();
        params.put("ReportId", hidden.getReportId());
        params.put("NoticeId", hidden.getId());
        params.put("ModifyUserId", hidden.getPersonId());
        params.put("ModifyUserName", hidden.getPersonName());
        params.put("ModifyStates", TextUtils.isEmpty(et_modify_state.getText().toString().trim()) ? "" : et_modify_state.getText().toString().trim());
        params.put("ModifySituation", TextUtils.isEmpty(et_modify_info.getText().toString().trim()) ? "" : et_modify_info.getText().toString().trim());
        params.put("ModifyResult", tv_choose_result.getText().toString().trim());
        params.put("ZRRId", hidden.getZRRId());
        params.put("ZRRName", hidden.getZRRName());

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
        HttpAction.getInstance().createModify(parts, params).subscribe(new BaseObserver<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse bean) {
                WaitUI.cancel();
                ToastUtil.show(context, "整改信息提交成功");
                finish();
            }

            @Override
            public void onError(String message) {
                WaitUI.cancel();
//                ToastUtil.show(context, message);
            }
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

            showTips();
        }
    }

    private void initPicker(List<String> itemList, TextView tv) {
        if (picker == null) {
            picker = new ItemPicker(context);
        }
        picker.setItemData(itemList);
        picker.show();
        picker.setTypeListener((type, position) -> tv.setText(type));
    }

    private void showTips() {
        tv_tips.setVisibility(imageList.size() == 0 ? View.GONE : View.VISIBLE);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_modify_hidden_fill;
    }
}