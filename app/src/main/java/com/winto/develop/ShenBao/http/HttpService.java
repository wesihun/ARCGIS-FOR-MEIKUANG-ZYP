package com.winto.develop.ShenBao.http;

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
import com.winto.develop.ShenBao.bean.UserInfoBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface HttpService {
    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String fileUrl);

    @Multipart
    @POST("File/UploadSampleImage")
    Flowable<BaseResponse> uploadFiles(@Part MultipartBody.Part file);

    @Multipart
    @POST()
    Flowable<BaseResponse> uploadFiles(@Url String url, @Part MultipartBody.Part file);

    @Multipart
    @POST()
    Flowable<BaseResponse> uploadFileList(@Url String url, @Part List<MultipartBody.Part> fileList);

    @Multipart
    @POST()
    Flowable<ResponseBody> UploadCompleteImage(@Url String url, @Part MultipartBody.Part file);

    @Multipart
    @POST("File/UploadSampleImage")
    Flowable<ResponseBody> uploadFiles(@Part List<MultipartBody.Part> parts);

    @GET("/bussiness/App/GetPlanList")
    Flowable<TaskDetailBean> getPlanList();

    @GET("/bussiness/App/GetRiskPointList")
    Flowable<RiskPointListBean> getRiskPointList();

    @GET("/bussiness/App/GetQRCodeList")
    Flowable<PaichaListBean> getInvestigateItemList(@QueryMap Map<String, String> params);

    @Multipart
    @POST("/auth/Login/LoginCheck")
    Flowable<LoginBean> login(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("/bussiness/App/GetQRCodeCreat")
    Flowable<BaseResponse> checkPass(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("/bussiness/HiddenDanger/CreateReport")
    Flowable<BaseResponse> hiddenReport(@Part List<MultipartBody.Part> fileList, @PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("/bussiness/HiddenDanger/CreateNotice")
    Flowable<BaseResponse> createNotice(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("/bussiness/HiddenDanger/CreateModify")
    Flowable<BaseResponse> createModify(@Part List<MultipartBody.Part> fileList, @PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("/bussiness/HiddenDanger/CreateRecheck")
    Flowable<BaseResponse> createRecheck(@Part List<MultipartBody.Part> fileList, @PartMap Map<String, RequestBody> params);

    @GET("/bussiness/HiddenDanger/GetReportListByCondition")
    Flowable<TroubleListBean> getTroubleList(@QueryMap Map<String, String> params);

    @GET("/bussiness/HiddenDanger/GetNoticeList")
    Flowable<RectifiedHiddenListBean> getRectifiedHiddenList(@QueryMap Map<String, String> params);

    @GET("/bussiness/HiddenDanger/GetModifyList")
    Flowable<ReviewedHiddenListBean> getReviewHiddenList(@QueryMap Map<String, String> params);

    @GET("/bussiness/HiddenDanger/GetSafeUserList")
    Flowable<ChoosePersonListBean> getSafeUserList();

    @Multipart
    @POST("/bussiness/HiddenDanger/PushSafeDepart")
    Flowable<BaseResponse> pushSafeDepart(@PartMap Map<String, RequestBody> params);

    @GET("/bussiness/App/GetRiskNoticeList")
    Flowable<RiskNoticeCardListBean> getRiskNoticeList();

    @GET("/bussiness/Statistical/GetCountData")
    Flowable<CountDataBean> getCountData();

    @GET("/bussiness/Statistical/GetHiddenTJ")
    Flowable<HiddenTJBean> getHiddenTJ();

    @GET("/bussiness/Statistical/GetRiskUnitTJ")
    Flowable<RiskUnitTJBean> getRiskUnitTJ();

    @GET("/api/DataDict/GetPageListByCondition")
    Flowable<HiddenLevelBean> getHiddenType(@QueryMap Map<String, Object> params);

    @GET("/bussiness/Statistical/GetRiskInfoTJ")
    Flowable<HiddenCountBean> getHiddenCount();

    @GET("/bussiness/HiddenDanger/GetHistoryList")
    Flowable<HistoryListBean> getHistoryList(@QueryMap Map<String, Object> params);

    @GET("/bussiness/App/GetUserInfo")
    Flowable<UserInfoBean> getUserInfo();

}