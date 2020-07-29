package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class CountDataBean extends BaseResponse {

    /**
     * count : 0
     * data : {"Count1":1,"Count2":1,"Count3":0,"Count4":1}
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
         * Count1 : 1
         * Count2 : 1
         * Count3 : 0
         * Count4 : 1
         */

        private int Count1;
        private int Count2;
        private int Count3;
        private int Count4;

        public int getCount1() {
            return Count1;
        }

        public void setCount1(int Count1) {
            this.Count1 = Count1;
        }

        public int getCount2() {
            return Count2;
        }

        public void setCount2(int Count2) {
            this.Count2 = Count2;
        }

        public int getCount3() {
            return Count3;
        }

        public void setCount3(int Count3) {
            this.Count3 = Count3;
        }

        public int getCount4() {
            return Count4;
        }

        public void setCount4(int Count4) {
            this.Count4 = Count4;
        }
    }
}
