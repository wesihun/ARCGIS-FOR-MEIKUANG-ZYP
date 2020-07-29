package com.winto.develop.ShenBao.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.winto.develop.ShenBao.R;

public class MoreFunctionPopup extends PopupWindow {
    private OnButtonClickListener buttonClickListener;
    private Context context;
    private View parent;
    private View view;
    private TextView tv_msg;
    private TextView tv_logout;
    private TextView tv_history;
    private boolean isManagementPosition;

    public MoreFunctionPopup(Context context, View parent, boolean isManagementPosition) {
        this.context = context;
        this.parent = parent;
        this.isManagementPosition = isManagementPosition;
        initPopup();
        initView();
        initClick();
    }

    private void initPopup() {
        view = View.inflate(context, R.layout.popup_choose_label, null);
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
    }

    private void initView() {
        tv_msg = view.findViewById(R.id.tv_msg);
        tv_history = view.findViewById(R.id.tv_history);
        tv_logout = view.findViewById(R.id.tv_log_out);
        if (isManagementPosition) {
            tv_history.setVisibility(View.VISIBLE);
        } else {
            tv_history.setVisibility(View.GONE);
        }
    }

    private void initClick() {
        tv_msg.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onMsgBtnClick();
                dismiss();
            }
        });

        tv_history.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onHistoryBtnClick();
                dismiss();
            }
        });

        tv_logout.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onLogoutBtnClick();
                dismiss();
            }
        });
    }

    public void show() {
        showAsDropDown(parent, 0, 0, Gravity.BOTTOM);
        update();
    }

    public interface OnButtonClickListener {
        void onMsgBtnClick();

        void onHistoryBtnClick();

        void onLogoutBtnClick();
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
}
