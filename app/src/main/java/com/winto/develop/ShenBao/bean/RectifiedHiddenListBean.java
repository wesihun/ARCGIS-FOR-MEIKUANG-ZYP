package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class RectifiedHiddenListBean extends BaseResponse {


    /**
     * count : 2
     * data : [{"Id":"e3df1f0e-e2c1-4882-936d-7e8ee90fe7b1","ReportId":"50018a8d-2a08-49c6-9384-170a040f5370","HiddenDangerLevel":"2","PersonId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","PersonName":"小王(员工)","Method":"某哦咯名字","ZRRId":"6af3baaf-6a14-4cc9-a997-1921ffbea9ee","ZRRName":"责任人","CreateTime":"0001-01-01 00:00:00","DeleteMark":0,"States":"4","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":"镇魔你定你不理妃子笑你就胡你过年之前您","RiskBH":"1/1/1-1","RiskName":"开拓运输道路","ReTime":"2020-06-09 15:48:08","Result":"不合格","ReProposal":"重新整改"},{"Id":"b0b87ca9-b4d6-4296-b69b-ba2790f6b15e","ReportId":"3a4f746e-8a5b-4dd1-a576-54b88027f4e0","HiddenDangerLevel":"3","PersonId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","PersonName":"小王(员工)","Method":"OMG敏敏我认怂哦摸头磨磨唧唧","ZRRId":"6af3baaf-6a14-4cc9-a997-1921ffbea9ee","ZRRName":"责任人","CreateTime":"0001-01-01 00:00:00","DeleteMark":0,"States":"1","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":"明细账","RiskBH":"1/1/1-1","RiskName":"开拓运输道路","ReTime":"0001-01-01 00:00:00","Result":null,"ReProposal":null}]
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

    public static class DataBean extends BaseResponse{
        /**
         * Id : e3df1f0e-e2c1-4882-936d-7e8ee90fe7b1
         * ReportId : 50018a8d-2a08-49c6-9384-170a040f5370
         * HiddenDangerLevel : 2
         * PersonId : 6af3baaf-6a14-4cc9-a997-1921ffbea9bf
         * PersonName : 小王(员工)
         * Method : 某哦咯名字
         * ZRRId : 6af3baaf-6a14-4cc9-a997-1921ffbea9ee
         * ZRRName : 责任人
         * CreateTime : 0001-01-01 00:00:00
         * DeleteMark : 0
         * States : 4
         * IsSupervisor : 0
         * RiskLevel : null
         * HiddenDangersDescribe : 镇魔你定你不理妃子笑你就胡你过年之前您
         * RiskBH : 1/1/1-1
         * RiskName : 开拓运输道路
         * ReTime : 2020-06-09 15:48:08
         * Result : 不合格
         * ReProposal : 重新整改
         */

        private String Id;
        private String ReportId;
        private String HiddenDangerLevel;
        private String PersonId;
        private String PersonName;
        private String Method;
        private String ZRRId;
        private String ZRRName;
        private String CreateTime;
        private int DeleteMark;
        private String States;
        private String IsSupervisor;
        private Object RiskLevel;
        private String HiddenDangersDescribe;
        private String RiskBH;
        private String RiskName;
        private String ReTime;
        private String Result;
        private String ReProposal;

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

        public String getHiddenDangerLevel() {
            return HiddenDangerLevel;
        }

        public void setHiddenDangerLevel(String HiddenDangerLevel) {
            this.HiddenDangerLevel = HiddenDangerLevel;
        }

        public String getPersonId() {
            return PersonId;
        }

        public void setPersonId(String PersonId) {
            this.PersonId = PersonId;
        }

        public String getPersonName() {
            return PersonName;
        }

        public void setPersonName(String PersonName) {
            this.PersonName = PersonName;
        }

        public String getMethod() {
            return Method;
        }

        public void setMethod(String Method) {
            this.Method = Method;
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

        public String getReTime() {
            return ReTime;
        }

        public void setReTime(String ReTime) {
            this.ReTime = ReTime;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public String getReProposal() {
            return ReProposal;
        }

        public void setReProposal(String ReProposal) {
            this.ReProposal = ReProposal;
        }
    }
}