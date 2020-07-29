package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class TableListBean extends BaseResponse {
    private String departmentName;
    private int gfxNum;
    private int dzgNum;
    private int dfcNum;
    private int ybhNum;
    private String zglNum;

    public TableListBean() {
    }

    public TableListBean(String departmentName, int gfxNum, int dzgNum, int dfcNum, int ybhNum, String zglNum) {
        this.departmentName = departmentName;
        this.gfxNum = gfxNum;
        this.dzgNum = dzgNum;
        this.dfcNum = dfcNum;
        this.ybhNum = ybhNum;
        this.zglNum = zglNum;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getGfxNum() {
        return gfxNum;
    }

    public void setGfxNum(int gfxNum) {
        this.gfxNum = gfxNum;
    }

    public int getDzgNum() {
        return dzgNum;
    }

    public void setDzgNum(int dzgNum) {
        this.dzgNum = dzgNum;
    }

    public int getDfcNum() {
        return dfcNum;
    }

    public void setDfcNum(int dfcNum) {
        this.dfcNum = dfcNum;
    }

    public int getYbhNum() {
        return ybhNum;
    }

    public void setYbhNum(int ybhNum) {
        this.ybhNum = ybhNum;
    }

    public String getZglNum() {
        return zglNum;
    }

    public void setZglNum(String zglNum) {
        this.zglNum = zglNum;
    }
}
