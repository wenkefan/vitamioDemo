package com.wenke.vitamiodemo.video;

import android.os.Handler;
import android.os.Message;

import com.wenke.vitamiodemo.file.FileName;
import com.wenke.vitamiodemo.file.FileUtils;
import com.wenke.vitamiodemo.model.Playlist;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Response;
import testlibrary.hylk.com.loginlibrary.okhttp.LK_OkHttpUtil;
import testlibrary.hylk.com.loginlibrary.okhttp.coreprogress.LK_FileUtils;
import testlibrary.hylk.com.loginlibrary.utils.LK_LogUtil;

/**
 * Created by wenke on 2017/7/20.
 */

public class MediaDownload {

    private static MediaDownload mVideo;


    private MediaDownload() {
    }

    public static MediaDownload getInstance() {
        if (mVideo == null) {
            synchronized (MediaDownload.class) {
                if (mVideo == null) {
                    mVideo = new MediaDownload();
                }
            }
        }
        return mVideo;
    }
    private boolean Flag = true;
    private boolean EndFlag = false;
    public void Download(final Map<Integer, Playlist> playlistMap){
        int isFlag = -1;
        for (int j = playlistMap.size() - 1; j > 0; j--){
            if (!playlistMap.get(j).isDowlond()){
                isFlag = j;
                break;
            }
        }
        if (isFlag == -1){
            callBack.allDownload(playlistMap);
            return;
        }
        for (int i = 0; i < playlistMap.size(); i++){
            if (i == isFlag){
                LK_LogUtil.D("isFlag---:" + isFlag + "----i---:" + i);
                EndFlag = true;
            }
            if (!playlistMap.get(i).isDowlond()){
                if (playlistMap.get(i).getMediaType() == 1){
                    //图片
                    final int finalI = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DownloadImage(playlistMap, finalI);
                        }
                    }).start();
                } else if (playlistMap.get(i).getMediaType() == 2) {
                    //视频
                    final int finalI1 = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DownloadVideo(playlistMap, finalI1);
                        }
                    }).start();
                }
            }
        }
    }

    private void DownloadVideo(final Map<Integer, Playlist> playlistMap, final int finalI1){
        LK_OkHttpUtil.getOkHttpUtil().download(playlistMap.get(finalI1).getMediaFile(), null,
                new LK_OkHttpUtil.OnMyDownLoadListener() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccess(Response response) throws IOException {
                        LK_FileUtils.saveFile2Local(response, FileUtils.getVedioPaht() + "/" + playlistMap.get(finalI1).getMediaName());
                        playlistMap.get(finalI1).setDowlond(true);
                        if (Flag){
                            callBack.fristDownload(playlistMap);
                        }
                        Flag = false;
                        if (EndFlag) {
                            EndFlag = false;
                            callBack.endDownload(playlistMap);
                        }
                    }
                });
    }

    private void DownloadImage(final Map<Integer, Playlist> playlistMap, final int finalI){
        LK_OkHttpUtil.getOkHttpUtil().download(playlistMap.get(finalI).getMediaFile(), null,
                new LK_OkHttpUtil.OnMyDownLoadListener() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccess(Response response) throws IOException {
                        LK_FileUtils.saveFile2Local(response, FileUtils.getImagePaht() + "/" + playlistMap.get(finalI).getMediaName());
                        playlistMap.get(finalI).setDowlond(true);
                        if (EndFlag) {
                            EndFlag = false;
                            callBack.endDownload(playlistMap);
                        }
                    }
                });
    }

    public interface CallBack{
        void fristDownload(Map<Integer, Playlist> playlistMap);
        void endDownload(Map<Integer, Playlist> playlistMap);
        void allDownload(Map<Integer, Playlist> playlistMap);

    }
    private CallBack callBack;
    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }
}
