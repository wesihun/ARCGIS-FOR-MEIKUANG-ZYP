package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class UserInfoBean extends BaseResponse {

    /**
     * count : 0
     * data : {"UserName":"liubaoguanzuzhang","RealName":"刘保管组长","RoleName":"班组长","JobName":"保管组长","OrgName":"中央储备粮鸡西直属库有限公司","DepName":"仓储保管科"}
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
         * UserName : liubaoguanzuzhang
         * RealName : 刘保管组长
         * RoleName : 班组长
         * JobName : 保管组长
         * OrgName : 中央储备粮鸡西直属库有限公司
         * DepName : 仓储保管科
         */
        private String UserName;
        private String RealName;
        private String RoleName;
        private String JobName;
        private String OrgName;
        private String DepName;

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getRealName() {
            return RealName;
        }

        public void setRealName(String RealName) {
            this.RealName = RealName;
        }

        public String getRoleName() {
            return RoleName;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public String getJobName() {
            return JobName;
        }

        public void setJobName(String JobName) {
            this.JobName = JobName;
        }

        public String getOrgName() {
            return OrgName;
        }

        public void setOrgName(String OrgName) {
            this.OrgName = OrgName;
        }

        public String getDepName() {
            return DepName;
        }

        public void setDepName(String DepName) {
            this.DepName = DepName;
        }
    }
}
