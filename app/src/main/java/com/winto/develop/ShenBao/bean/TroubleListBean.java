package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

import java.util.List;

public class TroubleListBean extends BaseResponse {


    /**
     * count : 2
     * data : [{"Id":"e42ccc6d-fe0b-4d91-9aed-9b20c7065577","Position":"公路两侧","CheckTableId":"7805346f-3ae2-4501-b4b7-5ef6432cb222","RiskPointBH":"1/1/1-2","RiskPointName":"运输车辆","RiskPointLevel":null,"HiddenDangersLevel":"较大风险","HiddenDangersType":"车辆","HiddenDangersDescribe":"{\"RiskBH\":\"1/1/1-2\",\"RiskName\":\"开拓运输道路\",\"OrgId\":\"5261e995-ca08-4ea5-8184-59d224728333\",\"OrgName\":\"神宝煤矿\"}","ZRDW":"6309213e-13dc-4ca2-9f29-8e21ee355a85","ZRDWName":"责任单位","ZRR":"6af3baaf-6a14-4cc9-a997-1921ffbea9ee","ZRRName":"责任人","TBUserId":"5ea708a1-3ba7-4857-b08d-7ea1637cb03f","TBUserName":"小吴(班组长)","CreateTime":"2020-06-05 11:21:25","ImageUrl":"/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/1CJy2_1591327333427_jpg,/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/9u8pq_1591327333428_jpg,","DeleteMark":0,"PushMark":0,"PushUserId":null,"States":"1","TroubleshootingItems":"在充气的状态下拆卸轮胎时，是否存在钢圈或压条缺损、或压条未上到位。"},{"Id":"bc3b636c-2f77-4dde-9041-b2ab9aa2fd08","Position":"你摸过","CheckTableId":"7805346f-3ae2-4501-b4b7-5ef6432cb652","RiskPointBH":"1/1/1-2","RiskPointName":"运输车辆","RiskPointLevel":null,"HiddenDangersLevel":"低风险","HiddenDangersType":"给您你","HiddenDangersDescribe":"秘密哦红米","ZRDW":"6309213e-13dc-4ca2-9f29-8e21ee355a85","ZRDWName":"责任单位","ZRR":"6af3baaf-6a14-4cc9-a997-1921ffbea9ee","ZRRName":"责任人","TBUserId":"6af3baaf-6a14-4cc9-a997-1921ffbea9bf","TBUserName":"小王(员工)","CreateTime":"2020-06-05 10:34:27","ImageUrl":"/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/M6dp0_1591324516853_jpg,/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/26Lj6_1591324516853_jpg,","DeleteMark":0,"PushMark":0,"PushUserId":null,"States":"1","TroubleshootingItems":"车辆出发前应对制动系统、动力系统、外观、轮胎、转向系统、照明等全面检查，定期维护保养。"}]
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
         * Id : e42ccc6d-fe0b-4d91-9aed-9b20c7065577
         * Position : 公路两侧
         * CheckTableId : 7805346f-3ae2-4501-b4b7-5ef6432cb222
         * RiskPointBH : 1/1/1-2
         * RiskPointName : 运输车辆
         * RiskPointLevel : null
         * HiddenDangersLevel : 较大风险
         * HiddenDangersType : 车辆
         * HiddenDangersDescribe : {"RiskBH":"1/1/1-2","RiskName":"开拓运输道路","OrgId":"5261e995-ca08-4ea5-8184-59d224728333","OrgName":"神宝煤矿"}
         * ZRDW : 6309213e-13dc-4ca2-9f29-8e21ee355a85
         * ZRDWName : 责任单位
         * ZRR : 6af3baaf-6a14-4cc9-a997-1921ffbea9ee
         * ZRRName : 责任人
         * TBUserId : 5ea708a1-3ba7-4857-b08d-7ea1637cb03f
         * TBUserName : 小吴(班组长)
         * CreateTime : 2020-06-05 11:21:25
         * ImageUrl : /HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/1CJy2_1591327333427_jpg,/HiddenDangers/5261e995-ca08-4ea5-8184-59d224728333/Report/9u8pq_1591327333428_jpg,
         * DeleteMark : 0
         * PushMark : 0
         * PushUserId : null
         * States : 1
         * TroubleshootingItems : 在充气的状态下拆卸轮胎时，是否存在钢圈或压条缺损、或压条未上到位。
         */

        private String Id;
        private String Position;
        private String CheckTableId;
        private String RiskPointBH;
        private String RiskPointName;
        private Object RiskPointLevel;
        private String HiddenDangersLevel;
        private String HiddenDangersType;
        private String HiddenDangersDescribe;
        private String ZRDW;
        private String ZRDWName;
        private String ZRR;
        private String ZRRName;
        private String TBUserId;
        private String TBUserName;
        private String CreateTime;
        private String ImageUrl;
        private String ControlMeasures;
        private String IsSupervisor;
        private int DeleteMark;
        private int PushMark;
        private Object PushUserId;
        private String States;
        private String TroubleshootingItems;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getControlMeasures() {
            return ControlMeasures;
        }

        public void setControlMeasures(String controlMeasures) {
            ControlMeasures = controlMeasures;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String Position) {
            this.Position = Position;
        }

        public String getCheckTableId() {
            return CheckTableId;
        }

        public void setCheckTableId(String CheckTableId) {
            this.CheckTableId = CheckTableId;
        }

        public String getIsSupervisor() {
            return IsSupervisor;
        }

        public void setIsSupervisor(String isSupervisor) {
            IsSupervisor = isSupervisor;
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

        public Object getRiskPointLevel() {
            return RiskPointLevel;
        }

        public void setRiskPointLevel(Object RiskPointLevel) {
            this.RiskPointLevel = RiskPointLevel;
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

        public String getHiddenDangersDescribe() {
            return HiddenDangersDescribe;
        }

        public void setHiddenDangersDescribe(String HiddenDangersDescribe) {
            this.HiddenDangersDescribe = HiddenDangersDescribe;
        }

        public String getZRDW() {
            return ZRDW;
        }

        public void setZRDW(String ZRDW) {
            this.ZRDW = ZRDW;
        }

        public String getZRDWName() {
            return ZRDWName;
        }

        public void setZRDWName(String ZRDWName) {
            this.ZRDWName = ZRDWName;
        }

        public String getZRR() {
            return ZRR;
        }

        public void setZRR(String ZRR) {
            this.ZRR = ZRR;
        }

        public String getZRRName() {
            return ZRRName;
        }

        public void setZRRName(String ZRRName) {
            this.ZRRName = ZRRName;
        }

        public String getTBUserId() {
            return TBUserId;
        }

        public void setTBUserId(String TBUserId) {
            this.TBUserId = TBUserId;
        }

        public String getTBUserName() {
            return TBUserName;
        }

        public void setTBUserName(String TBUserName) {
            this.TBUserName = TBUserName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public int getDeleteMark() {
            return DeleteMark;
        }

        public void setDeleteMark(int DeleteMark) {
            this.DeleteMark = DeleteMark;
        }

        public int getPushMark() {
            return PushMark;
        }

        public void setPushMark(int PushMark) {
            this.PushMark = PushMark;
        }

        public Object getPushUserId() {
            return PushUserId;
        }

        public void setPushUserId(Object PushUserId) {
            this.PushUserId = PushUserId;
        }

        public String getStates() {
            return States;
        }

        public void setStates(String States) {
            this.States = States;
        }

        public String getTroubleshootingItems() {
            return TroubleshootingItems;
        }

        public void setTroubleshootingItems(String TroubleshootingItems) {
            this.TroubleshootingItems = TroubleshootingItems;
        }
    }
}
