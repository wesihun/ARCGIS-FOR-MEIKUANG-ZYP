package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.io.Serializable;
import java.util.List;

public class PaichaListBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"Id":"7805346f-3ae2-4501-b4b7-5ef6432cb652","ClassificationId":"63d4534e-79d4-4e13-88be-1877322296ea","RoleId":"dff5ebf1-551a-4ff3-94ba-2ddde1d924b6","RoleName":"岗位员工","JobId":"a757d0d0-22e3-4f4f-b09d-ed8f24c47b3b","JobName":"生产技术员","UserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","UserName":"小王","RiskPointBH":"1/1/1-2","RiskPointName":"运输车辆","RiskFactor":"车辆使用前未经过外观检查，车辆存在隐患依然坚持使用。","RiskLevel":"1","CreateTime":"2020-05-28 15:40:16","DeleteMark":1,"TroubleshootingItems":"车辆出发前应对制动系统、动力系统、外观、轮胎、转向系统、照明等全面检查，定期维护保养。","OrgId":"5261e995-ca08-4ea5-8184-59d224728333","OrgName":"神宝煤矿","states1":"0","states2":null}]
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

    public static class DataBean implements Serializable {
        /**
         * Id : 7805346f-3ae2-4501-b4b7-5ef6432cb652
         * ClassificationId : 63d4534e-79d4-4e13-88be-1877322296ea
         * RoleId : dff5ebf1-551a-4ff3-94ba-2ddde1d924b6
         * RoleName : 岗位员工
         * JobId : a757d0d0-22e3-4f4f-b09d-ed8f24c47b3b
         * JobName : 生产技术员
         * UserId : 6af3baaf-6a14-4cc9-a997-1921ffbea9bf
         * UserName : 小王
         * RiskPointBH : 1/1/1-2
         * RiskPointName : 运输车辆
         * RiskFactor : 车辆使用前未经过外观检查，车辆存在隐患依然坚持使用。
         * RiskLevel : 1
         * CreateTime : 2020-05-28 15:40:16
         * DeleteMark : 1
         * TroubleshootingItems : 车辆出发前应对制动系统、动力系统、外观、轮胎、转向系统、照明等全面检查，定期维护保养。
         * OrgId : 5261e995-ca08-4ea5-8184-59d224728333
         * OrgName : 神宝煤矿
         * states1 : 0
         * states2 : null
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
        private String RiskLevel;
        private String CreateTime;
        private int DeleteMark;
        private String TroubleshootingItems;
        private String OrgId;
        private String OrgName;
        private String states1 = "0";
        private String states2 = "0";

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
