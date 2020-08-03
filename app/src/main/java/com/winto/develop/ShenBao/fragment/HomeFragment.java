package com.winto.develop.ShenBao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.winto.develop.ShenBao.MainApplication;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.activity.RectifiedHiddenListActivity;
import com.winto.develop.ShenBao.activity.ReviewedHiddenListActivity;
import com.winto.develop.ShenBao.activity.TaskListActivity;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.HiddenCountBean;
import com.winto.develop.ShenBao.bean.RiskNoticeCardListBean;
import com.winto.develop.ShenBao.bean.TaskListBean;
import com.winto.develop.ShenBao.dialog.RiskNoticeCardDialog;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private TextView tv_scan;
    private TextView tv_fill;
    private View view_risk_level;

    private TextView tv_major_num;
    private TextView tv_large_num;
    private TextView tv_general_num;
    private TextView tv_low_num;
    private TextView[] numViews;
    private TextView tv_name1;
    private TextView tv_name2;
    private TextView tv_name3;
    private TextView tv_name4;
    private TextView[] nameViews;

    private RelativeLayout rl_control_plan_not_completed;
    private RelativeLayout rl_control_plan_completed;
    private RelativeLayout rl_other_test_not_completed;
    private RelativeLayout rl_other_test_completed;
    private ConstraintLayout cl_middle;
    private ImageView iv_to_notice;
    private ImageView iv_to_rectification;
    private ImageView iv_to_review;

    @Override
    protected void initView() {
        tv_scan = findViewById(R.id.iv_scan);
        tv_fill = findViewById(R.id.tv_fill);
        view_risk_level = findViewById(R.id.view_risk_level);
        tv_major_num = view_risk_level.findViewById(R.id.tv_major_num);
        tv_large_num = view_risk_level.findViewById(R.id.tv_large_num);
        tv_general_num = view_risk_level.findViewById(R.id.tv_general_num);
        tv_low_num = view_risk_level.findViewById(R.id.tv_low_num);
        numViews = new TextView[]{tv_major_num, tv_large_num, tv_general_num, tv_low_num};
        tv_name1 = view_risk_level.findViewById(R.id.tv_name1);
        tv_name2 = view_risk_level.findViewById(R.id.tv_name2);
        tv_name3 = view_risk_level.findViewById(R.id.tv_name3);
        tv_name4 = view_risk_level.findViewById(R.id.tv_name4);
        nameViews = new TextView[]{tv_name1, tv_name2, tv_name3, tv_name4};
        rl_control_plan_not_completed = findViewById(R.id.rl_control_plan_not_completed);
        rl_control_plan_completed = findViewById(R.id.rl_control_plan_completed);
        rl_other_test_not_completed = findViewById(R.id.rl_other_test_not_completed);
        rl_other_test_completed = findViewById(R.id.rl_other_test_completed);
        cl_middle = findViewById(R.id.cl_middle);
        iv_to_notice = findViewById(R.id.iv_to_notice);
        iv_to_rectification = findViewById(R.id.iv_to_rectification);
        iv_to_review = findViewById(R.id.iv_to_review);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        tv_scan.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("scanType", 1);
            toClass(context, CaptureActivity.class, bundle);
        });

        tv_fill.setOnClickListener(v -> {
            showNoticeCard();
        });

        rl_control_plan_not_completed.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("taskType", "0");
            toClass(context, TaskListActivity.class, bundle);
        });

        rl_control_plan_completed.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("taskType", "1");
            toClass(context, TaskListActivity.class, bundle);
        });

        rl_other_test_not_completed.setOnClickListener(v -> {
            TaskListBean task1 = new TaskListBean("挖掘机", "风险点编号:1/4/2-2", "2020-5-20", 0);
            TaskListBean task2 = new TaskListBean("装载机", "风险点编号:2/5/1-3", "2020-5-20", 0);
            TaskListBean task3 = new TaskListBean("铲装作业", "风险点编号:2/1/3-1", "2020-5-20", 0);
            List<TaskListBean> taskList = new ArrayList<>();
            taskList.add(task1);
            taskList.add(task2);
            taskList.add(task3);
            Bundle bundle = new Bundle();
            bundle.putInt("taskType", 0);
            bundle.putSerializable("taskList", (Serializable) taskList);
            toClass(context, TaskListActivity.class, bundle);
        });

        rl_other_test_completed.setOnClickListener(v -> {
            TaskListBean task1 = new TaskListBean("配电设备", "风险点编号:1/3/1-2", "2020-5-20", 1);
            TaskListBean task2 = new TaskListBean("发电机组", "风险点编号:1/4/2-2", "2020-5-20", 1);
            TaskListBean task3 = new TaskListBean("空压机设备", "风险点编号:1/2/1-6", "2020-5-20", 1);
            TaskListBean task4 = new TaskListBean("发（配）电操作", "风险点编号:1/3/1-2", "2020-5-20", 1);
            List<TaskListBean> taskList = new ArrayList<>();
            taskList.add(task1);
            taskList.add(task2);
            taskList.add(task3);
            taskList.add(task4);
            Bundle bundle = new Bundle();
            bundle.putInt("taskType", 1);
            bundle.putSerializable("taskList", (Serializable) taskList);
            toClass(context, TaskListActivity.class, bundle);
        });

        iv_to_notice.setOnClickListener(v -> {
            if (MainApplication.getContext().isManagementPosition()) {
                Bundle bundle = new Bundle();
                bundle.putInt("pageType", 1);
                toClass(context, ReviewedHiddenListActivity.class, bundle);
            } else {
                ToastUtil.show(context, "无下发通知权限");
            }
        });

        iv_to_rectification.setOnClickListener(v -> {
            if (MainApplication.getContext().isManagementPosition()) {
                Bundle bundle = new Bundle();
                bundle.putInt("pageType", 0);
                toClass(context, ReviewedHiddenListActivity.class, bundle);
            } else {
                toClass(context, RectifiedHiddenListActivity.class);
            }
        });

        iv_to_review.setOnClickListener(v -> {
            if (MainApplication.getContext().isManagementPosition()) {
                Bundle bundle = new Bundle();
                bundle.putInt("pageType", 2);
                toClass(context, ReviewedHiddenListActivity.class, bundle);
            } else {
                ToastUtil.show(context, "无复查权限");
            }
        });
    }

    private RiskNoticeCardDialog cardDialog;

    private void showNoticeCard() {
        HttpAction.getInstance().getRiskNoticeList().subscribe(new BaseObserver<RiskNoticeCardListBean>() {
            @Override
            public void onSuccess(RiskNoticeCardListBean bean) {
                if (cardDialog == null) {
                    cardDialog = new RiskNoticeCardDialog(context);
                }
                cardDialog.setData(bean.getData());
                cardDialog.show();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void getHiddenCount() {
        HttpAction.getInstance().getHiddenCount().subscribe(new BaseObserver<HiddenCountBean>() {
            @Override
            public void onSuccess(HiddenCountBean bean) {
                List<HiddenCountBean.DataBean> list = bean.getData();
                for (int i = 0; i < list.size(); i++) {
                    HiddenCountBean.DataBean data = list.get(i);
                    numViews[i].setText(String.valueOf(data.getCount()));
                    nameViews[i].setText(data.getName());
                }
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getHiddenCount();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

}
