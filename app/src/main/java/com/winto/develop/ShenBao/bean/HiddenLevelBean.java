package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class HiddenLevelBean extends BaseResponse {

    /**
     * count : 2
     * data : [{"CRowId":"736701ba-d6eb-4cc4-8966-9fdc095b667d","DataType":"003","ItemCode":"1","ItemName":"重大隐患","Remark":null,"SortCode":1,"CreateDate":"2020-07-06 09:43:26","CreateUserId":"8D6D0B0E-5739-41A4-8EA3-46A5FC4A17E1","CreateUserName":"admin","ModifyDate":"2020-07-06 09:43:26","ModifyUserId":"","ModifyUserName":"","DeleteMark":1},{"CRowId":"2b09d4e1-c69e-4240-94f1-6a0a8b7a832d","DataType":"003","ItemCode":"2","ItemName":"一般隐患","Remark":null,"SortCode":2,"CreateDate":"2020-07-06 09:43:48","CreateUserId":"8D6D0B0E-5739-41A4-8EA3-46A5FC4A17E1","CreateUserName":"admin","ModifyDate":"2020-07-06 09:43:48","ModifyUserId":"","ModifyUserName":"","DeleteMark":1}]
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
         * CRowId : 736701ba-d6eb-4cc4-8966-9fdc095b667d
         * DataType : 003
         * ItemCode : 1
         * ItemName : 重大隐患
         * Remark : null
         * SortCode : 1
         * CreateDate : 2020-07-06 09:43:26
         * CreateUserId : 8D6D0B0E-5739-41A4-8EA3-46A5FC4A17E1
         * CreateUserName : admin
         * ModifyDate : 2020-07-06 09:43:26
         * ModifyUserId :
         * ModifyUserName :
         * DeleteMark : 1
         */

        private String CRowId;
        private String DataType;
        private String ItemCode;
        private String ItemName;
        private Object Remark;
        private int SortCode;
        private String CreateDate;
        private String CreateUserId;
        private String CreateUserName;
        private String ModifyDate;
        private String ModifyUserId;
        private String ModifyUserName;
        private int DeleteMark;

        public String getCRowId() {
            return CRowId;
        }

        public void setCRowId(String CRowId) {
            this.CRowId = CRowId;
        }

        public String getDataType() {
            return DataType;
        }

        public void setDataType(String DataType) {
            this.DataType = DataType;
        }

        public String getItemCode() {
            return ItemCode;
        }

        public void setItemCode(String ItemCode) {
            this.ItemCode = ItemCode;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String ItemName) {
            this.ItemName = ItemName;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }

        public int getSortCode() {
            return SortCode;
        }

        public void setSortCode(int SortCode) {
            this.SortCode = SortCode;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(String CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(String ModifyDate) {
            this.ModifyDate = ModifyDate;
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

        public int getDeleteMark() {
            return DeleteMark;
        }

        public void setDeleteMark(int DeleteMark) {
            this.DeleteMark = DeleteMark;
        }
    }
}
