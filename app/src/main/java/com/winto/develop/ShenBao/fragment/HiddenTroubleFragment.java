package com.winto.develop.ShenBao.fragment;

import android.graphics.Color;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.winto.develop.ShenBao.R;
import com.winto.develop.ShenBao.adapter.CountDataListAdapter;
import com.winto.develop.ShenBao.adapter.MyAxisValueFormatter;
import com.winto.develop.ShenBao.adapter.UnitDataListAdapter;
import com.winto.develop.ShenBao.base.BaseFragment;
import com.winto.develop.ShenBao.base.BaseObserver;
import com.winto.develop.ShenBao.bean.CountDataBean;
import com.winto.develop.ShenBao.bean.HiddenTJBean;
import com.winto.develop.ShenBao.bean.RiskUnitTJBean;
import com.winto.develop.ShenBao.http.HttpAction;
import com.winto.develop.ShenBao.util.ToastUtil;
import com.winto.develop.ShenBao.wight.CustomListView;

import java.util.ArrayList;
import java.util.List;

public class HiddenTroubleFragment extends BaseFragment {
    private String[] colorArray = {"#1cd7ff", "#fcd55f", "#fc615f", "#f2ab01", "#41fad1", "#fcc9c7", "#0391fc", "#1cd7ff", "#394d5c", "#ffff00", "#d17d62", "#c64747", "#1d2088", "#f3302e", "#87c89d", "#fc615f", "#ffb400"};

    private SmartRefreshLayout srl_refresh;
    private TextView tv_count1;
    private TextView tv_count2;
    private TextView tv_count3;
    private TextView tv_count4;
    private PieChart pc_chart;
    private CustomListView lv_trouble_cate_list;
    private BarChart bc_chart;
    private CustomListView lv_trouble_unit_list;
    private CountDataListAdapter dataListAdapter;
    private List<HiddenTJBean.DataBean> dataList;
    private UnitDataListAdapter unitListAdapter;
    private List<RiskUnitTJBean.DataBean> unitList;

    @Override
    protected void initView() {
        srl_refresh = findViewById(R.id.srl_refresh);
        tv_count1 = findViewById(R.id.tv_count1);
        tv_count2 = findViewById(R.id.tv_count2);
        tv_count3 = findViewById(R.id.tv_count3);
        tv_count4 = findViewById(R.id.tv_count4);
        pc_chart = findViewById(R.id.pc_chart);
        lv_trouble_cate_list = findViewById(R.id.lv_trouble_cate_list);
        bc_chart = findViewById(R.id.bc_chart);
        lv_trouble_unit_list = findViewById(R.id.lv_trouble_unit_list);
    }

    @Override
    protected void initAdapter() {
        dataList = new ArrayList<>();
        dataListAdapter = new CountDataListAdapter(context, dataList);
        lv_trouble_cate_list.setAdapter(dataListAdapter);

        unitList = new ArrayList<>();
        unitListAdapter = new UnitDataListAdapter(context, unitList);
        lv_trouble_unit_list.setAdapter(unitListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getCountData();
        getHiddenTJ();
        getRiskUnitTJ();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            getCountData();
            getHiddenTJ();
            getRiskUnitTJ();
        }
    }

    @Override
    protected void initData() {
        getCountData();
        getHiddenTJ();
        getRiskUnitTJ();
    }

    @Override
    protected void initClick() {
        srl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getCountData();
                getHiddenTJ();
                getRiskUnitTJ();
            }
        });
    }

    private void getCountData() {
        HttpAction.getInstance().getCountData().subscribe(new BaseObserver<CountDataBean>() {
            @Override
            public void onSuccess(CountDataBean bean) {
                tv_count1.setText(String.valueOf(bean.getData().getCount1()));
                tv_count2.setText(String.valueOf(bean.getData().getCount2()));
                tv_count3.setText(String.valueOf(bean.getData().getCount3()));
                tv_count4.setText(String.valueOf(bean.getData().getCount4()));
                srl_refresh.finishRefresh();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
                srl_refresh.finishRefresh();
            }
        });
    }

    private void getHiddenTJ() {
        HttpAction.getInstance().getHiddenTJ().subscribe(new BaseObserver<HiddenTJBean>() {
            @Override
            public void onSuccess(HiddenTJBean bean) {
                initPieChart(bean);
                dataList.clear();
                dataList.addAll(bean.getData());
                dataListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void getRiskUnitTJ() {
        HttpAction.getInstance().getRiskUnitTJ().subscribe(new BaseObserver<RiskUnitTJBean>() {
            @Override
            public void onSuccess(RiskUnitTJBean bean) {
                initBarChart(bean.getData());
                unitList.clear();
                unitList.addAll(bean.getData());
                unitListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void initPieChart(HiddenTJBean bean) {
        List<PieEntry> strings = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        for (int i = 0; i < bean.getData().size(); i++) {
            HiddenTJBean.DataBean hiddenBean = bean.getData().get(i);
            strings.add(new PieEntry((float) hiddenBean.getCount(), hiddenBean.getName()));
            colors.add(Color.parseColor(colorArray[i]));
        }
        PieDataSet dataSet = new PieDataSet(strings, "");
        dataSet.setColors(colors);
        PieData pieData = new PieData(dataSet);
        pieData.setDrawValues(true);
        pieData.setValueTextSize(10);
        pieData.setValueTextColor(ContextCompat.getColor(context, R.color.white));
        Description description = new Description();
        description.setText("");
        pc_chart.setDrawSliceText(false);

        pc_chart.setDrawHoleEnabled(false);
        pc_chart.setDescription(description);

        pc_chart.setRotationEnabled(false);
        pc_chart.setData(pieData);
        pc_chart.setNoDataText("暂无数据");
        pc_chart.invalidate();
        Legend legend = pc_chart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setWordWrapEnabled(true);
    }

    private void initBarChart(List<RiskUnitTJBean.DataBean> list) {
        bc_chart.setDrawBarShadow(false);
        bc_chart.setDrawValueAboveBar(true);
        bc_chart.getDescription().setEnabled(false);
        bc_chart.setMaxVisibleValueCount(list.size());
        bc_chart.setPinchZoom(false);
        bc_chart.setDrawGridBackground(false);
        bc_chart.setScaleEnabled(false);
        bc_chart.setPinchZoom(false);
        bc_chart.setBorderColor(ContextCompat.getColor(context, R.color.secondcolor));

        //自定义坐标轴适配器，配置在X轴，xAxis.setValueFormatter(xAxisFormatter);
        final String[] values = new String[list.size()];
        ArrayList<BarEntry> yValueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i).getName();
            yValueList.add(new BarEntry(i, Float.parseFloat(list.get(i).getValue())));
        }

        IAxisValueFormatter formatter = (value, axis) -> {
            int index = (int) value;
            if (index < 0 || index >= values.length) {
                return "";
            } else {
                return values[index];
            }
        };

        XAxis xAxis = bc_chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(list.size(), false);
        xAxis.setLabelRotationAngle(-25);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(8);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);

        //自定义坐标轴适配器，配置在Y轴。leftAxis.setValueFormatter(custom);
        IAxisValueFormatter custom = new MyAxisValueFormatter();
        //获取到图形左边的Y轴
        YAxis leftAxis = bc_chart.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f);

        //获取到图形右边的Y轴，并设置为不显示
        bc_chart.getAxisRight().setEnabled(false);

        //图例设置
        Legend legend = bc_chart.getLegend();
        legend.setEnabled(false);

        BarDataSet set1 = new BarDataSet(yValueList, null);
        set1.setDrawIcons(false);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);
        data.setValueTextSize(9f);
        data.setBarWidth(0.6f);

        bc_chart.setData(data);
        bc_chart.setScaleEnabled(false);
        bc_chart.animateY(800);
        bc_chart.invalidate();
        bc_chart.setNoDataText("暂无数据");
        bc_chart.getData().notifyDataChanged();
        bc_chart.notifyDataSetChanged();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_hidden_trouble;
    }
}