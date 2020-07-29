package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class HistoryListBean extends BaseResponse {

    /**
     * count : 5
     * data : [{"Id":null,"ReportId":null,"NoticeId":null,"ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"士大夫第三方的","ModifySituation":"士大夫上的","ModifyResult":"官方大概地方","ImageUrl":null,"CreateTime":"2020-07-23 14:32:55","DeleteMark":0,"ZRRId":null,"ZRRName":null,"States":"4","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":null,"RiskBH":null,"RiskName":null,"OrgId":null,"OrgName":"神宝煤矿","HiddenDangerLevel":"重大隐患","RiskPointLevel":null,"TroubleshootingItems":"冰雪或多雨季节道路较滑时，道路有无防护措施。","RiskFactor":"冰雪或多雨季节道路较滑时，道路无防护措施。","ControlMeasures":"在道路湿、滑路段设限速标志，限制外来车辆行驶速度。"},{"Id":null,"ReportId":null,"NoticeId":null,"ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"士大夫上的","ModifySituation":"士大夫","ModifyResult":"士大夫","ImageUrl":null,"CreateTime":"2020-07-23 13:34:17","DeleteMark":0,"ZRRId":null,"ZRRName":null,"States":"2","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":null,"RiskBH":null,"RiskName":null,"OrgId":null,"OrgName":"神宝煤矿","HiddenDangerLevel":"重大隐患","RiskPointLevel":null,"TroubleshootingItems":"夜间作业时，矿山道路危险点是否设足够的照明。","RiskFactor":"夜间作业时，矿山道路危险点未设足够的照明。","ControlMeasures":"夜间工作时，危险点均应有足够的照明。"},{"Id":null,"ReportId":null,"NoticeId":null,"ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"嘻嘻嘻","ModifySituation":"小咯为咯在真咯","ModifyResult":"嘻嘻嘻","ImageUrl":null,"CreateTime":"2020-07-22 10:44:37","DeleteMark":0,"ZRRId":null,"ZRRName":null,"States":"3","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":null,"RiskBH":null,"RiskName":null,"OrgId":null,"OrgName":"神宝煤矿","HiddenDangerLevel":"一般隐患","RiskPointLevel":null,"TroubleshootingItems":"夜间作业时，矿山道路危险点是否设足够的照明。","RiskFactor":"夜间作业时，矿山道路危险点未设足够的照明。","ControlMeasures":"夜间工作时，危险点均应有足够的照明。"},{"Id":null,"ReportId":null,"NoticeId":null,"ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"哦咯一下","ModifySituation":"黄柠檬","ModifyResult":"戏子无义","ImageUrl":null,"CreateTime":"2020-07-22 10:39:09","DeleteMark":0,"ZRRId":null,"ZRRName":null,"States":"3","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":null,"RiskBH":null,"RiskName":null,"OrgId":null,"OrgName":"神宝煤矿","HiddenDangerLevel":"一般隐患","RiskPointLevel":null,"TroubleshootingItems":"夜间作业时，矿山道路危险点是否设足够的照明。","RiskFactor":"夜间作业时，矿山道路危险点未设足够的照明。","ControlMeasures":"夜间工作时，危险点均应有足够的照明。"},{"Id":null,"ReportId":null,"NoticeId":null,"ModifyUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","ModifyUserName":"小王(员工)","ModifyStates":"您红蜘蛛","ModifySituation":"明细账","ModifyResult":"仔仔细细","ImageUrl":null,"CreateTime":"2020-07-22 10:26:26","DeleteMark":0,"ZRRId":null,"ZRRName":null,"States":"3","IsSupervisor":"0","RiskLevel":null,"HiddenDangersDescribe":null,"RiskBH":null,"RiskName":null,"OrgId":null,"OrgName":"神宝煤矿","HiddenDangerLevel":"一般隐患","RiskPointLevel":null,"TroubleshootingItems":"道路最小圆曲线半径是否小于15m。","RiskFactor":"道路最小圆曲线半径小于15m。","ControlMeasures":"夜间工作时，危险点均应有足够的照明。"}]
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

    public static class DataBean extends BaseResponse {
        /**
         * Id : null
         * ReportId : null
         * NoticeId : null
         * ModifyUserId : 6af3baaf-6a14-4cc9-a997-1921ffbea9bf
         * ModifyUserName : 小王(员工)
         * ModifyStates : 士大夫第三方的
         * ModifySituation : 士大夫上的
         * ModifyResult : 官方大概地方
         * ImageUrl : null
         * CreateTime : 2020-07-23 14:32:55
         * DeleteMark : 0
         * ZRRId : null
         * ZRRName : null
         * States : 4
         * IsSupervisor : 0
         * RiskLevel : null
         * HiddenDangersDescribe : null
         * RiskBH : null
         * RiskName : null
         * OrgId : null
         * OrgName : 神宝煤矿
         * HiddenDangerLevel : 重大隐患
         * RiskPointLevel : null
         * TroubleshootingItems : 冰雪或多雨季节道路较滑时，道路有无防护措施。
         * RiskFactor : 冰雪或多雨季节道路较滑时，道路无防护措施。
         * ControlMeasures : 在道路湿、滑路段设限速标志，限制外来车辆行驶速度。
         */

        private String Id;
        private String ReportId;
        private String NoticeId;
        private String ModifyUserId;
        private String ModifyUserName;
        private String PersonName;
        private String ModifyStates;
        private String ModifySituation;
        private String ReportUserName;
        private String ModifyResult;
        private String ImageUrl;
        private String CreateTime;
        private int DeleteMark;
        private String ZRRId;
        private String ZRRName;
        private String States;
        private String IsSupervisor;
        private String Method;
        private String RiskLevel;
        private String HiddenDangersDescribe;
        private String RiskBH;
        private String RiskName;
        private String OrgId;
        private String OrgName;
        private String HiddenDangerLevel;
        private String RiskPointLevel;
        private String ReportImageUrl;
        private String TroubleshootingItems;
        private String RiskFactor;
        private String ReportTime;
        private String ReportHiddenDangerLevel;
        private String ReTime;
        private String ReImageUrl;
        private String ControlMeasures;
        private String Remark;
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

        public String getPersonName() {
            return PersonName;
        }

        public void setPersonName(String personName) {
            PersonName = personName;
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

        public String getMethod() {
            return Method;
        }

        public void setMethod(String method) {
            Method = method;
        }

        public String getReportHiddenDangerLevel() {
            return ReportHiddenDangerLevel;
        }

        public void setReportHiddenDangerLevel(String reportHiddenDangerLevel) {
            ReportHiddenDangerLevel = reportHiddenDangerLevel;
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

        public String getReportImageUrl() {
            return ReportImageUrl;
        }

        public void setReportImageUrl(String reportImageUrl) {
            ReportImageUrl = reportImageUrl;
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

        public String getRiskLevel() {
            return RiskLevel;
        }

        public void setRiskLevel(String RiskLevel) {
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

        public String getHiddenDangerLevel() {
            return HiddenDangerLevel;
        }

        public void setHiddenDangerLevel(String HiddenDangerLevel) {
            this.HiddenDangerLevel = HiddenDangerLevel;
        }

        public String getRiskPointLevel() {
            return RiskPointLevel;
        }

        public void setRiskPointLevel(String RiskPointLevel) {
            this.RiskPointLevel = RiskPointLevel;
        }

        public String getTroubleshootingItems() {
            return TroubleshootingItems;
        }

        public void setTroubleshootingItems(String TroubleshootingItems) {
            this.TroubleshootingItems = TroubleshootingItems;
        }

        public String getRiskFactor() {
            return RiskFactor;
        }

        public void setRiskFactor(String RiskFactor) {
            this.RiskFactor = RiskFactor;
        }

        public String getControlMeasures() {
            return ControlMeasures;
        }

        public void setControlMeasures(String ControlMeasures) {
            this.ControlMeasures = ControlMeasures;
        }

        public String getReportUserName() {
            return ReportUserName;
        }

        public void setReportUserName(String reportUserName) {
            ReportUserName = reportUserName;
        }

        public String getReportTime() {
            return ReportTime;
        }

        public void setReportTime(String reportTime) {
            ReportTime = reportTime;
        }

        public String getReTime() {
            return ReTime;
        }

        public void setReTime(String reTime) {
            ReTime = reTime;
        }

        public String getReImageUrl() {
            return ReImageUrl;
        }

        public void setReImageUrl(String reImageUrl) {
            ReImageUrl = reImageUrl;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String remark) {
            Remark = remark;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String result) {
            Result = result;
        }

        public String getReProposal() {
            return ReProposal;
        }

        public void setReProposal(String reProposal) {
            ReProposal = reProposal;
        }
    }
}