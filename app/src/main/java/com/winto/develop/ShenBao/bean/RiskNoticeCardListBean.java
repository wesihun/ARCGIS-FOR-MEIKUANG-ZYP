package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class RiskNoticeCardListBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"AccidentType":null,"RiskBH":null,"RiskFactor":null,"RiskLevel":null,"RiskName":null,"TroubleshootingItems":null,"ControlMeasures":null},{"AccidentType":null,"RiskBH":null,"RiskFactor":null,"RiskLevel":null,"RiskName":null,"TroubleshootingItems":null,"ControlMeasures":null},{"AccidentType":null,"RiskBH":null,"RiskFactor":null,"RiskLevel":null,"RiskName":null,"TroubleshootingItems":null,"ControlMeasures":null},{"AccidentType":null,"RiskBH":null,"RiskFactor":null,"RiskLevel":null,"RiskName":null,"TroubleshootingItems":null,"ControlMeasures":null}]
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
         * AccidentType : null
         * RiskBH : null
         * RiskFactor : null
         * RiskLevel : null
         * RiskName : null
         * TroubleshootingItems : null
         * ControlMeasures : null
         */

        private String AccidentType;
        private String RiskBH;
        private String RiskFactor;
        private String RiskLevel;
        private String RiskName;
        private String TroubleshootingItems;
        private String ControlMeasures;

        public String getAccidentType() {
            return AccidentType;
        }

        public void setAccidentType(String AccidentType) {
            this.AccidentType = AccidentType;
        }

        public String getRiskBH() {
            return RiskBH;
        }

        public void setRiskBH(String RiskBH) {
            this.RiskBH = RiskBH;
        }

        public String getRiskFactor() {
            return RiskFactor;
        }

        public void setRiskFactor(String RiskFactor) {
            this.RiskFactor = RiskFactor;
        }

        public String getRiskLevel() {
            return RiskLevel;
        }

        public void setRiskLevel(String RiskLevel) {
            this.RiskLevel = RiskLevel;
        }

        public String getRiskName() {
            return RiskName;
        }

        public void setRiskName(String RiskName) {
            this.RiskName = RiskName;
        }

        public String getTroubleshootingItems() {
            return TroubleshootingItems;
        }

        public void setTroubleshootingItems(String TroubleshootingItems) {
            this.TroubleshootingItems = TroubleshootingItems;
        }

        public String getControlMeasures() {
            return ControlMeasures;
        }

        public void setControlMeasures(String ControlMeasures) {
            this.ControlMeasures = ControlMeasures;
        }
    }
}
