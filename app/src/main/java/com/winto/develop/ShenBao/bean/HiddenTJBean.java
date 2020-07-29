package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class HiddenTJBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"Name":"重大隐患","Value":null,"Count":1},{"Name":"一般隐患","Value":null,"Count":1},{"Name":"无风险","Value":null,"Count":4}]
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
         * Name : 重大隐患
         * Value : null
         * Count : 1
         */

        private String Name;
        private Object Value;
        private int Count1;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public Object getValue() {
            return Value;
        }

        public void setValue(Object Value) {
            this.Value = Value;
        }

        public int getCount() {
            return Count1;
        }

        public void setCount(int Count) {
            this.Count1 = Count;
        }
    }
}
