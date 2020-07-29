package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class HiddenCountBean extends BaseResponse {

    /**
     * count : 0
     * data : [{"Name":"重大风险","Value":null,"Count":0,"Percentum":0},{"Name":"较大风险","Value":null,"Count":4,"Percentum":16.67},{"Name":"一般风险","Value":null,"Count":16,"Percentum":66.67},{"Name":"低风险","Value":null,"Count":4,"Percentum":16.67}]
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
         * Name : 重大风险
         * Value : null
         * Count : 0
         * Percentum : 0.0
         */

        private String Name;
        private Object Value;
        private int Count;
        private double Percentum;

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
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        public double getPercentum() {
            return Percentum;
        }

        public void setPercentum(double Percentum) {
            this.Percentum = Percentum;
        }
    }
}