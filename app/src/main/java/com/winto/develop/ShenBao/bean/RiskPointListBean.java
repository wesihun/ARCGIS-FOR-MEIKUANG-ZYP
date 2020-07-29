package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class RiskPointListBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"RiskBH":"1/1/1-2","RiskName":"运输车辆","OrgId":null,"OrgName":null,"states":"未完成"},{"RiskBH":"1/1/1-1","RiskName":"运输车辆","OrgId":null,"OrgName":null,"states":"未完成"}]
     */

    private int count;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * RiskBH : 1/1/1-2
         * RiskName : 运输车辆
         * OrgId : null
         * OrgName : null
         * states : 未完成
         */

        private String RiskBH;
        private String RiskName;
        private String OrgId;
        private String OrgName;
        private String states;

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

        public Object getOrgId() {
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

        public String getStates() {
            return states;
        }

        public void setStates(String states) {
            this.states = states;
        }
    }
}
