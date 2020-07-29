package com.winto.develop.ShenBao.http;


import android.text.TextUtils;

import com.winto.develop.ShenBao.base.BaseResponse;
import com.winto.develop.ShenBao.bean.ChoosePersonListBean;
import com.winto.develop.ShenBao.bean.CountDataBean;
import com.winto.develop.ShenBao.bean.HiddenCountBean;
import com.winto.develop.ShenBao.bean.HiddenLevelBean;
import com.winto.develop.ShenBao.bean.HiddenTJBean;
import com.winto.develop.ShenBao.bean.HistoryListBean;
import com.winto.develop.ShenBao.bean.LoginBean;
import com.winto.develop.ShenBao.bean.PaichaListBean;
import com.winto.develop.ShenBao.bean.RectifiedHiddenListBean;
import com.winto.develop.ShenBao.bean.ReviewedHiddenListBean;
import com.winto.develop.ShenBao.bean.RiskNoticeCardListBean;
import com.winto.develop.ShenBao.bean.RiskPointListBean;
import com.winto.develop.ShenBao.bean.RiskUnitTJBean;
import com.winto.develop.ShenBao.bean.TaskDetailBean;
import com.winto.develop.ShenBao.bean.TroubleListBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class HttpAction {

    public static HttpAction getInstance() {
        return HttpActionHolder.instance;
    }

    private static class HttpActionHolder {
        private static HttpAction instance = new HttpAction();
    }

    private <T> Flowable<T> applySchedulers(Flowable<T> responseFlowable) {
        return responseFlowable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<BaseResponse> uploadFiles(String url, MultipartBody.Part file) {
        return applySchedulers(HttpClient.getHttpService().uploadFiles(url, file));
    }

    public Flowable<BaseResponse> uploadFiles(String url, List<MultipartBody.Part> fileList) {
        return applySchedulers(HttpClient.getHttpService().uploadFileList(url, fileList));
    }

    public Flowable<TaskDetailBean> getPlanList() {
        return applySchedulers(HttpClient.getHttpService().getPlanList());
    }

    public Flowable<RiskPointListBean> getRiskPointList() {
        return applySchedulers(HttpClient.getHttpService().getRiskPointList());
    }

    public Flowable<LoginBean> login(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().login(generateRequestBody(params)));
    }

    public Flowable<PaichaListBean> getInvestigateItemList(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().getInvestigateItemList(params));
    }

    public Flowable<BaseResponse> checkPass(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().checkPass(generateRequestBody(params)));
    }

    public Flowable<BaseResponse> hiddenReport(List<MultipartBody.Part> parts, Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().hiddenReport(parts, generateRequestBody(params)));
    }

    public Flowable<BaseResponse> createModify(List<MultipartBody.Part> parts, Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().createModify(parts, generateRequestBody(params)));
    }

    public Flowable<BaseResponse> createRecheck(List<MultipartBody.Part> parts, Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().createRecheck(parts, generateRequestBody(params)));
    }

    public Flowable<BaseResponse> createNotice(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().createNotice(generateRequestBody(params)));
    }

    public Flowable<TroubleListBean> getTroubleList(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().getTroubleList(params));
    }

    public Flowable<RectifiedHiddenListBean> getRectifiedHiddenList(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().getRectifiedHiddenList(params));
    }

    public Flowable<ReviewedHiddenListBean> getReviewHiddenList(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().getReviewHiddenList(params));
    }

    public Flowable<ChoosePersonListBean> getSafeUserList() {
        return applySchedulers(HttpClient.getHttpService().getSafeUserList());
    }

    public Flowable<BaseResponse> pushSafeDepart(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().pushSafeDepart(generateRequestBody(params)));
    }

    public Flowable<RiskNoticeCardListBean> getRiskNoticeList() {
        return applySchedulers(HttpClient.getHttpService().getRiskNoticeList());
    }

    public Flowable<CountDataBean> getCountData() {
        return applySchedulers(HttpClient.getHttpService().getCountData());
    }

    public Flowable<HiddenTJBean> getHiddenTJ() {
        return applySchedulers(HttpClient.getHttpService().getHiddenTJ());
    }

    public Flowable<RiskUnitTJBean> getRiskUnitTJ() {
        return applySchedulers(HttpClient.getHttpService().getRiskUnitTJ());
    }

    public Flowable<HiddenLevelBean> getHiddenType(Map<String, Object> params) {
        return applySchedulers(HttpClient.getHttpService().getHiddenType(params));
    }

    public Flowable<HiddenCountBean> getHiddenCount() {
        return applySchedulers(HttpClient.getHttpService().getHiddenCount());
    }

    public Flowable<HistoryListBean> getHistoryList(Map<String, Object> params) {
        return applySchedulers(HttpClient.getHttpService().getHistoryList(params));
    }

    /**
     * 转换为 form-data
     */
    private static Map<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : requestDataMap.keySet()) {
            MediaType type = MediaType.parse("multipart/form-data");
            RequestBody requestBody = RequestBody.create(type, TextUtils.isEmpty(requestDataMap.get(key)) ? "" : Objects.requireNonNull(requestDataMap.get(key)));
            requestBodyMap.put(key, requestBody);
        }
        return requestBodyMap;
    }
}