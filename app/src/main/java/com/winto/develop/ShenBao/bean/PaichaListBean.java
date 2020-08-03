package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class PaichaListBean extends BaseResponse {


    /**
     * count : 0
     * data : [{"Id":"17440eb8-6ef9-48bd-876f-dde2378f8d6f","ClassificationId":"b83d31dd-a2e2-47c2-8bbe-12d6466dfae1","RoleId":"dff5ebf1-551a-4ff3-94ba-2ddde1d924b6","RoleName":"岗位员工","JobId":"81895be0-55f2-49ea-a846-b7ca4af4fc72","JobName":"保管员","UserId":"3b80d342-cd94-4453-96ef-467fce9f2bc5","UserName":"杨保管员","RiskPointBH":"1/2/3-4","RiskPointName":"气垫输送机操作","RiskFactor":"输送机运行时清理机头、机尾滚筒机附近的粮食及杂物。","HiddenDangersLevel":"","HiddenDangersType":"","AccidentType":"","RiskLevel":"4","CreateTime":"2020-07-27 15:25:07","DeleteMark":1,"TroubleshootingItems":"输送机运行时是否清理机头、机尾滚筒机附近的粮食及杂物。","ControlMeasures":"输送机运行时禁止清理机头、机尾滚筒机附近的粮食及杂物。","MeasuresType":"1","EmergencyMeasures":"直接安全技术措施","OrgId":"798b56e2-94a0-4a82-872c-794b95e2945c","OrgName":"中央储备粮鸡西直属库有限公司","states1":"0","states2":"0"},{"Id":"2341b078-7e27-4d5f-a937-c378ad5dca19","ClassificationId":"db248aba-7eb3-4af1-9dd2-dd1e77ee93b4","RoleId":"dff5ebf1-551a-4ff3-94ba-2ddde1d924b6","RoleName":"岗位员工","JobId":"81895be0-55f2-49ea-a846-b7ca4af4fc72","JobName":"保管员","UserId":"3b80d342-cd94-4453-96ef-467fce9f2bc5","UserName":"杨保管员","RiskPointBH":"1/2/3-4","RiskPointName":"气垫输送机操作","RiskFactor":"输送机使用和检修作业人员攀爬输送机。","HiddenDangersLevel":null,"HiddenDangersType":null,"AccidentType":null,"RiskLevel":"3","CreateTime":"2020-07-27 15:25:07","DeleteMark":1,"TroubleshootingItems":"输送机使用和检修是否有作业人员攀爬输送机。","ControlMeasures":"禁止人员爬到输送机上作业。","MeasuresType":"1","EmergencyMeasures":"直接安全技术措施","OrgId":"798b56e2-94a0-4a82-872c-794b95e2945c","OrgName":"中央储备粮鸡西直属库有限公司","states1":"0","states2":"0"}]
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
         * Id : 17440eb8-6ef9-48bd-876f-dde2378f8d6f
         * ClassificationId : b83d31dd-a2e2-47c2-8bbe-12d6466dfae1
         * RoleId : dff5ebf1-551a-4ff3-94ba-2ddde1d924b6
         * RoleName : 岗位员工
         * JobId : 81895be0-55f2-49ea-a846-b7ca4af4fc72
         * JobName : 保管员
         * UserId : 3b80d342-cd94-4453-96ef-467fce9f2bc5
         * UserName : 杨保管员
         * RiskPointBH : 1/2/3-4
         * RiskPointName : 气垫输送机操作
         * RiskFactor : 输送机运行时清理机头、机尾滚筒机附近的粮食及杂物。
         * HiddenDangersLevel :
         * HiddenDangersType :
         * AccidentType :
         * RiskLevel : 4
         * CreateTime : 2020-07-27 15:25:07
         * DeleteMark : 1
         * TroubleshootingItems : 输送机运行时是否清理机头、机尾滚筒机附近的粮食及杂物。
         * ControlMeasures : 输送机运行时禁止清理机头、机尾滚筒机附近的粮食及杂物。
         * MeasuresType : 1
         * EmergencyMeasures : 直接安全技术措施
         * OrgId : 798b56e2-94a0-4a82-872c-794b95e2945c
         * OrgName : 中央储备粮鸡西直属库有限公司
         * states1 : 0
         * states2 : 0
         */

        private String Id;
        private String ClassificationId;
        private String RoleId;
        private String RoleName;
        private String JobId;
        private String JobName;
        private String UserId;
        private String UserName;
        private String RiskPointBH;
        private String RiskPointName;
        private String RiskFactor;
        private String HiddenDangersLevel;
        private String HiddenDangersType;
        private String AccidentType;
        private String RiskLevel;
        private String CreateTime;
        private int DeleteMark;
        private String TroubleshootingItems;
        private String ControlMeasures;
        private String MeasuresType;
        private String EmergencyMeasures;
        private String OrgId;
        private String OrgName;
        private String states1;
        private String states2;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getClassificationId() {
            return ClassificationId;
        }

        public void setClassificationId(String ClassificationId) {
            this.ClassificationId = ClassificationId;
        }

        public String getRoleId() {
            return RoleId;
        }

        public void setRoleId(String RoleId) {
            this.RoleId = RoleId;
        }

        public String getRoleName() {
            return RoleName;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public String getJobId() {
            return JobId;
        }

        public void setJobId(String JobId) {
            this.JobId = JobId;
        }

        public String getJobName() {
            return JobName;
        }

        public void setJobName(String JobName) {
            this.JobName = JobName;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getRiskPointBH() {
            return RiskPointBH;
        }

        public void setRiskPointBH(String RiskPointBH) {
            this.RiskPointBH = RiskPointBH;
        }

        public String getRiskPointName() {
            return RiskPointName;
        }

        public void setRiskPointName(String RiskPointName) {
            this.RiskPointName = RiskPointName;
        }

        public String getRiskFactor() {
            return RiskFactor;
        }

        public void setRiskFactor(String RiskFactor) {
            this.RiskFactor = RiskFactor;
        }

        public String getHiddenDangersLevel() {
            return HiddenDangersLevel;
        }

        public void setHiddenDangersLevel(String HiddenDangersLevel) {
            this.HiddenDangersLevel = HiddenDangersLevel;
        }

        public String getHiddenDangersType() {
            return HiddenDangersType;
        }

        public void setHiddenDangersType(String HiddenDangersType) {
            this.HiddenDangersType = HiddenDangersType;
        }

        public String getAccidentType() {
            return AccidentType;
        }

        public void setAccidentType(String AccidentType) {
            this.AccidentType = AccidentType;
        }

        public String getRiskLevel() {
            return RiskLevel;
        }

        public void setRiskLevel(String RiskLevel) {
            this.RiskLevel = RiskLevel;
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

        public String getMeasuresType() {
            return MeasuresType;
        }

        public void setMeasuresType(String MeasuresType) {
            this.MeasuresType = MeasuresType;
        }

        public String getEmergencyMeasures() {
            return EmergencyMeasures;
        }

        public void setEmergencyMeasures(String EmergencyMeasures) {
            this.EmergencyMeasures = EmergencyMeasures;
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

        public String getStates1() {
            return states1;
        }

        public void setStates1(String states1) {
            this.states1 = states1;
        }

        public String getStates2() {
            return states2;
        }

        public void setStates2(String states2) {
            this.states2 = states2;
        }
    }
}
