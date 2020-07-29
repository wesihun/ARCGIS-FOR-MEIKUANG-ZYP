package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class ReviewedHiddenListBean extends BaseResponse {
    /**
     * count : 1
     * data : [{"Id":"0a9295ec-f6b6-494a-8f1e-8bdb5954fe3f","ReportId":"50018a8d-2a08-49c6-9384-170a040f5370","NoticeId":"e3df1f0e-e2c1-4882-936d-7e8ee90fe7b1","ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"萝莉控","ModifySituation":"东陆路","ModifyResult":"boobs咯","ImageUrl":"/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Modify/80M37zMO0_1591750631361.jpg,/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Modify/0k8ZUE2S1_1591750631362.jpg","CreateTime":"2020-06-10 08:57:13","DeleteMark":0,"ZRRId":"6af3baaf-6a14-4cc9-a997-1921ffbea9ee","ZRRName":"责任人","States":"2","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":"镇魔你定你不理妃子笑你就胡你过年之前您","RiskBH":"1/1/1-1","RiskName":"开拓运输道路"}]
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
         * Id : 0a9295ec-f6b6-494a-8f1e-8bdb5954fe3f
         * ReportId : 50018a8d-2a08-49c6-9384-170a040f5370
         * NoticeId : e3df1f0e-e2c1-4882-936d-7e8ee90fe7b1
         * ModifyUserId : 6af3baaf-6a14-4cc9-a997-1921ffbea9bf
         * ModifyUserName : 小王(员工)
         * ModifyStates : 萝莉控
         * ModifySituation : 东陆路
         * ModifyResult : boobs咯
         * ImageUrl : /HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Modify/80M37zMO0_1591750631361.jpg,/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Modify/0k8ZUE2S1_1591750631362.jpg
         * CreateTime : 2020-06-10 08:57:13
         * DeleteMark : 0
         * ZRRId : 6af3baaf-6a14-4cc9-a997-1921ffbea9ee
         * ZRRName : 责任人
         * States : 2
         * IsSupervisor : 0
         * RiskLevel : null
         * HiddenDangersDescribe : 镇魔你定你不理妃子笑你就胡你过年之前您
         * RiskBH : 1/1/1-1
         * RiskName : 开拓运输道路
         */

        private String Id;
        private String ReportId;
        private String NoticeId;
        private String ModifyUserId;
        private String ModifyUserName;
        private String ModifyStates;
        private String ModifySituation;
        private String ModifyResult;
        private String ImageUrl;
        private String CreateTime;
        private int DeleteMark;
        private String ZRRId;
        private String ZRRName;
        private String States;
        private String IsSupervisor;
        private Object RiskLevel;
        private String HiddenDangersDescribe;
        private String RiskBH;
        private String RiskName;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getReportId() {
            return ReportId;
        }

        public void setReportId(String ReportId) {
            this.ReportId = ReportId;
        }

        public String getNoticeId() {
            return NoticeId;
        }

        public void setNoticeId(String NoticeId) {
            this.NoticeId = NoticeId;
        }

        public String getModifyUserId() {
            return ModifyUserId;
        }

        public void setModifyUserId(String ModifyUserId) {
            this.ModifyUserId = ModifyUserId;
        }

        public String getModifyUserName() {
            return ModifyUserName;
        }

        public void setModifyUserName(String ModifyUserName) {
            this.ModifyUserName = ModifyUserName;
        }

        public String getModifyStates() {
            return ModifyStates;
        }

        public void setModifyStates(String ModifyStates) {
            this.ModifyStates = ModifyStates;
        }

        public String getModifySituation() {
            return ModifySituation;
        }

        public void setModifySituation(String ModifySituation) {
            this.ModifySituation = ModifySituation;
        }

        public String getModifyResult() {
            return ModifyResult;
        }

        public void setModifyResult(String ModifyResult) {
            this.ModifyResult = ModifyResult;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getDeleteMark() {
            return DeleteMark;
        }

        public void setDeleteMark(int DeleteMark) {
            this.DeleteMark = DeleteMark;
        }

        public String getZRRId() {
            return ZRRId;
        }

        public void setZRRId(String ZRRId) {
            this.ZRRId = ZRRId;
        }

        public String getZRRName() {
            return ZRRName;
        }

        public void setZRRName(String ZRRName) {
            this.ZRRName = ZRRName;
        }

        public String getStates() {
            return States;
        }

        public void setStates(String States) {
            this.States = States;
        }

        public String getIsSupervisor() {
            return IsSupervisor;
        }

        public void setIsSupervisor(String IsSupervisor) {
            this.IsSupervisor = IsSupervisor;
        }

        public Object getRiskLevel() {
            return RiskLevel;
        }

        public void setRiskLevel(Object RiskLevel) {
            this.RiskLevel = RiskLevel;
        }

        public String getHiddenDangersDescribe() {
            return HiddenDangersDescribe;
        }

        public void setHiddenDangersDescribe(String HiddenDangersDescribe) {
            this.HiddenDangersDescribe = HiddenDangersDescribe;
        }

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
    }
}