package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class ScanResultBean extends BaseResponse {

    /**
     * RiskBH : 1/1/1-1
     * RiskName : 开拓运输道路
     * OrgId : 5261e995-ca08-4ea5-8184-59d224728333
     * OrgName : 神宝煤矿
     */

    private String RiskBH;
    private String RiskName;
    private String OrgId;
    private String OrgName;

    public String getRiskBH() {
        return RiskBH;
    }

    public void setRiskBH(String RiskBH) {
        this.RiskBH = RiskBH;
    }

    public String getRiskName() {
        return RiskName;
    }

    public void setRiskName(String RiskName) {
        this.RiskName = RiskName;
    }

    public String getOrgId() {
        return OrgId;
    }

    public void setOrgId(String OrgId) {
        this.OrgId = OrgId;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String OrgName) {
        this.OrgName = OrgName;
    }
}
