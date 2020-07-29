package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class ChoosePersonListBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"UserId":"e125830c-5ce9-426d-a9db-ba6539fc02b5","UserName":"gl"}]
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
         * UserId : e125830c-5ce9-426d-a9db-ba6539fc02b5
         * UserName : gl
         */

        private String UserId;
        private String UserName;

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
    }
}
