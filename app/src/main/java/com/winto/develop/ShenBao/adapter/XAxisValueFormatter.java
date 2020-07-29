package com.winto.develop.ShenBao.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class XAxisValueFormatter implements IAxisValueFormatter {
    private String[] xStrs = new String[]{"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        int position = (int) value;
        if (position >= 12) {
            position = 0;
        }
        return xStrs[position];
    }
}
