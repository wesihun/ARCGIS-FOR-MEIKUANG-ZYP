package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class RiskUnitTJBean extends BaseResponse {
    /**
     * count : 0
     * data : [{"Name":"采矿/公用辅助设施/供配电系统","Value":"2","Count":0},{"Name":"采矿/露天采矿生产系统/开拓运输","Value":"4","Count":0},{"Name":"采矿/露天采矿生产系统/采剥工艺","Value":"1","Count":0}]
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
         * Name : 采矿/公用辅助设施/供配电系统
         * Value : 2
         * Count : 0
         */

        private String Name;
        private String Value;
        private int Count;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }
    }
}
