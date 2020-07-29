package com.winto.develop.ShenBao.activity;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.base.BaseActivity;
import com.winto.develop.ShenBao.dialog.WaitUI;
import com.winto.develop.ShenBao.util.ToastUtil;
import com.winto.develop.ShenBao.wight.ItemPicker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyp on 2020/5/12 0020.
 * class note:隐患速记
 */

public class TroubleShorthandActivity extends BaseActivity {
    private ImageView iv_back;
    private TextView tv_choose_name;
    private EditText et_id;
    private EditText et_base_info;
    private TextView tv_choose_type;
    private TextView tv_choose_head;
    private TextView tv_choose_department;
    private EditText et_demand;
    private TextView tv_choose_level;
    private TextView tv_choose_date;
    private TextView tv_choose_time_limit;
    private TextView tv_choose_attachment;
    private Button btn_confirm;

    private ItemPicker picker;

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_choose_name = findViewById(R.id.et_choose_name);
        et_id = findViewById(R.id.et_id);
        et_base_info = findViewById(R.id.et_base_info);
        tv_choose_type = findViewById(R.id.tv_choose_type);
        tv_choose_head = findViewById(R.id.tv_choose_head);
        tv_choose_department = findViewById(R.id.tv_choose_department);
        et_demand = findViewById(R.id.et_demand);
        tv_choose_level = findViewById(R.id.tv_choose_level);
        tv_choose_date = findViewById(R.id.tv_choose_date);
        tv_choose_time_limit = findViewById(R.id.tv_choose_time_limit);
        tv_choose_attachment = findViewById(R.id.tv_choose_attachment);
        btn_confirm = findViewById(R.id.btn_confirm);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_choose_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<>();
                itemList.add("开拓运输道路");
                itemList.add("运输车辆");
                itemList.add("外来车辆");
                itemList.add("运输作业");
                itemList.add("采剥要素");
                itemList.add("潜孔钻机");
                itemList.add("穿孔作业");
                itemList.add("空压机设备");
                itemList.add("空压机作业检查");
                itemList.add("爆破作业");
                itemList.add("挖掘机");
                itemList.add("装载机");
                itemList.add("铲装作业");
                itemList.add("配电设备");
                itemList.add("发电机组");
                itemList.add("供油箱");
                itemList.add("电工作业");
                itemList.add("发(配)电操作");
                itemList.add("作业环境");
                initPicker(itemList, tv_choose_name);
            }
        });

        tv_choose_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<>();
                itemList.add("车辆伤害");
                itemList.add("物体打击");
                itemList.add("坍塌");
                itemList.add("高处坠落");
                itemList.add("机械伤害");
                itemList.add("粉尘");
                itemList.add("触电");
                itemList.add("容器爆炸");
                itemList.add("火灾、爆炸");
                itemList.add("放炮、其他伤害");
                itemList.add("标志缺陷");
                initPicker(itemList, tv_choose_type);
            }
        });

        tv_choose_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<>();
                itemList.add("李");
                itemList.add("张");
                itemList.add("刘");
                itemList.add("王");
                itemList.add("周");
                initPicker(itemList, tv_choose_head);
            }
        });

        tv_choose_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        tv_choose_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<>();
                itemList.add("低风险");
                itemList.add("一般风险");
                itemList.add("较大风险");
                itemList.add("重大风险");
                initPicker(itemList, tv_choose_level);
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_choose_name.getText().toString().equals("请选择")) {
                    ToastUtil.show(context, "请选择风险点名称");
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
                if (tv_choose_head.getText().toString().equals("请选择")) {
                    ToastUtil.show(context, "请选择整改负责人");
                    return;
                }
                if (tv_choose_department.getText().toString().equals("请选择")) {
                    ToastUtil.show(context, "请选择整改负责部门");
                    return;
                }
                if (TextUtils.isEmpty(et_demand.getText().toString())) {
                    ToastUtil.show(context, "请输入整改要求");
                    return;
                }
                if (tv_choose_level.getText().toString().equals("请选择")) {
                    ToastUtil.show(context, "请选择隐患级别");
                    return;
                }
                confirm();
            }
        });
    }

    private void initPicker(List<String> itemList, TextView tv) {
        if (picker == null) {
            picker = new ItemPicker(context);
        }
        picker.setItemData(itemList);
        picker.show();
        picker.setTypeListener((type, position) -> tv.setText(type));
    }

    private void confirm() {
        WaitUI.show(context);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WaitUI.cancel();
                ToastUtil.show(context, "隐患提交成功");
                finish();
            }
        }, 1100);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_trouble_shorthand;
    }
}