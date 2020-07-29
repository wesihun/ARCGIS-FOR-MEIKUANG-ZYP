package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class TaskDetailBean extends BaseResponse {

    /**
     * count : 0
     * data : {"Id":"3640489e-d60a-46a4-a4e1-f8ddf62ad0a7","PlanName":"计划1","CheckDate":"2020-05-31 00:00:00","ExecutionMode":"1","RiskBH":"1/1/1-2,1/1/1-1","RiskName":"运输车辆,开拓运输道路","OrgId":"5261e995-ca08-4ea5-8184-59d224728333","OrgName":"神宝煤矿","DepId":"6309213e-13dc-4ca2-9f29-8e21ee355a82","DepName":"采矿部","RoleId":"dff5ebf1-551a-4ff3-94ba-2ddde1d924b6","RoleName":"岗位员工","UserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","UserName":"小王","CreateTime":"2020-05-29 13:35:27","DeleteMark":1,"LastCompleteTime":null,"states":"未完成"}
     */

    private int count;
    private DataBean data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Id : 3640489e-d60a-46a4-a4e1-f8ddf62ad0a7
         * PlanName : 计划1
         * CheckDate : 2020-05-31 00:00:00
         * ExecutionMode : 1
         * RiskBH : 1/1/1-2,1/1/1-1
         * RiskName : 运输车辆,开拓运输道路
         * OrgId : 5261e995-ca08-4ea5-8184-59d224728333
         * OrgName : 神宝煤矿
         * DepId : 6309213e-13dc-4ca2-9f29-8e21ee355a82
         * DepName : 采矿部
         * RoleId : dff5ebf1-551a-4ff3-94ba-2ddde1d924b6
         * RoleName : 岗位员工
         * UserId : 6af3baaf-6a14-4cc9-a997-1921ffbea9bf
         * UserName : 小王
         * CreateTime : 2020-05-29 13:35:27
         * DeleteMark : 1
         * LastCompleteTime : null
         * states : 未完成
         */

        private String Id;
        private String PlanName;
        private String CheckDate;
        private String ExecutionMode;
        private String RiskBH;
        private String RiskName;
        private String OrgId;
        private String OrgName;
        private String DepId;
        private String DepName;
        private String RoleId;
        private String RoleName;
        private String UserId;
        private String UserName;
        private String CreateTime;
        private int DeleteMark;
        private Object LastCompleteTime;
        private String states;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getPlanName() {
            return PlanName;
        }

        public void setPlanName(String PlanName) {
            this.PlanName = PlanName;
        }

        public String getCheckDate() {
            return CheckDate;
        }

        public void setCheckDate(String CheckDate) {
            this.CheckDate = CheckDate;
        }

        public String getExecutionMode() {
            return ExecutionMode;
        }

        public void setExecutionMode(String ExecutionMode) {
            this.ExecutionMode = ExecutionMode;
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

        public String getDepId() {
            return DepId;
        }

        public void setDepId(String DepId) {
            this.DepId = DepId;
        }

        public String getDepName() {
            return DepName;
        }

        public void setDepName(String DepName) {
            this.DepName = DepName;
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

        public Object getLastCompleteTime() {
            return LastCompleteTime;
        }

        public void setLastCompleteTime(Object LastCompleteTime) {
            this.LastCompleteTime = LastCompleteTime;
        }

        public String getStates() {
            return states;
        }

        public void setStates(String states) {
            this.states = states;
        }
    }
}
