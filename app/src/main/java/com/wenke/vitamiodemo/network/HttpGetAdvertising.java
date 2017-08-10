package com.wenke.vitamiodemo.network;

import com.wenke.vitamiodemo.Constant;
import com.wenke.vitamiodemo.file.FileUtils;

import java.io.IOException;

import okhttp3.Response;
import testlibrary.hylk.com.loginlibrary.okhttp.LK_OkHttpUtil;
import testlibrary.hylk.com.loginlibrary.okhttp.coreprogress.LK_FileUtils;

/**
 * Created by wenke on 2017/7/25.
 */

public class HttpGetAdvertising {

    DownloadSettingListener listener;

    public void onDownloadListener(DownloadSettingListener listener){
        this.listener = listener;
    }

    public void setHttp() {

        String url = String.format(API.GetAdvertising, 47, 1);


        LK_OkHttpUtil.getOkHttpUtil().download(url, null, new LK_OkHttpUtil.OnMyDownLoadListener() {
            @Override
            public void onFailure(IOException e) {
                listener.setListener(false);
            }

            @Override
            public void onSuccess(Response response) throws IOException {
                LK_FileUtils.saveFile2Local(response, FileUtils.getSettingPaht() + "/" + Constant.SettingName);
                listener.setListener(true);
            }
        });
    }

    public interface DownloadSettingListener {
        void setListener(boolean flag);
    }


}
