package com.winto.develop.ShenBao.listener;

public interface UploadCallBack {

    void onProgress(int progress);

    void onCompleted(String imageUrl);

    void onError(String msg);

}
