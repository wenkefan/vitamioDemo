package com.wenke.vitamiodemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wenke.vitamiodemo.file.FileLoacalConfig;
import com.wenke.vitamiodemo.file.FileName;
import com.wenke.vitamiodemo.file.FileUtils;
import com.wenke.vitamiodemo.model.Advertising;
import com.wenke.vitamiodemo.model.AdvertisingData;
import com.wenke.vitamiodemo.model.Playlist;
import com.wenke.vitamiodemo.network.API;
import com.wenke.vitamiodemo.network.HttpGetAdvertising;
import com.wenke.vitamiodemo.util.VideoUtils;
import com.wenke.vitamiodemo.video.MediaDownload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Response;
import testlibrary.hylk.com.loginlibrary.enums.ImageShowType;
import testlibrary.hylk.com.loginlibrary.image.LK_ImageLoader;
import testlibrary.hylk.com.loginlibrary.okhttp.LK_OkHttpUtil;
import testlibrary.hylk.com.loginlibrary.okhttp.coreprogress.LK_FileUtils;
import testlibrary.hylk.com.loginlibrary.okhttp.coreprogress.listener.impl.UIProgressListener;
import testlibrary.hylk.com.loginlibrary.utils.LK_LogUtil;
import testlibrary.hylk.com.loginlibrary.utils.LK_ToastUtil;

public class MainActivity extends BaseActivtiy implements HttpGetAdvertising.DownloadSettingListener, MediaDownload.CallBack, FileLoacalConfig.FileLoacalConfigCallBack {

    private VideoView mVideoView;

    private ImageView mImage;

    private MediaController mMediaController;


    private Map<Integer, Playlist> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** 加了这句话可以，不加会初始化不成功 */
        Vitamio.isInitialized(getApplication());
        setContentView(R.layout.activity_main);
        /**
         * 1.先读取配置文件，
         *
         * 2.
         *
         */
        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("正在加载中...").show();
        HttpGetAdvertising advertising = new HttpGetAdvertising();
        advertising.onDownloadListener(this);
        advertising.setHttp();
        initViews();
    }

    @Override
    public void setListener(boolean flag) {
        if (flag) {
            //下载成功，读取配置文件
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getAdLocal();
                }
            }).start();
        } else {
            //下载失败，查看网络
            alertDialog.dismiss();
            LK_LogUtil.D("下载失败");
            File file = new File(FileUtils.getSettingPaht() + "/" + Constant.SettingName);
            if (file.exists()){
                getAdLocal();
            } else {
                handler.sendEmptyMessage(404);
            }
        }
    }

    private void getAdLocal() {//加载本地配置文件

        new Thread(new Runnable() {
            @Override
            public void run() {
                FileLoacalConfig config = new FileLoacalConfig();
                config.OnFileLoacalConfigCallBack(MainActivity.this);
                config.getAdLocal();
            }
        }).start();
    }

    @Override
    public void CallBack(Map<Integer, Playlist> playlistMap) {
        playlists = playlistMap;
        handler.sendEmptyMessage(Constant.GetAdLocal);
    }

    private void initViews() {
        int[] pixels;
        VideoUtils videoUtils = VideoUtils.getIntance(this);
        pixels = videoUtils.getDisplay();

        mVideoView = (VideoView) findViewById(R.id.surface_view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mVideoView.getLayoutParams();
        layoutParams.width = pixels[0];
        layoutParams.height = pixels[1];
        mVideoView.setLayoutParams(layoutParams);

        mImage = (ImageView) findViewById(R.id.imageview);
        RelativeLayout.LayoutParams layoutParam = (RelativeLayout.LayoutParams) mImage.getLayoutParams();
        layoutParam.height = pixels[0];
        layoutParam.height = pixels[1];
        mImage.setLayoutParams(layoutParam);

        initVideoView();
    }

    private void initData() {

        MediaDownload download = MediaDownload.getInstance();
        download.setCallBack(this);
        download.Download(playlists);
    }

    @Override
    public void fristDownload(Map<Integer, Playlist> playlistMap) {
        alertDialog.dismiss();
        playlists = playlistMap;
        playMedia();
    }

    @Override
    public void endDownload(Map<Integer, Playlist> playlistMap) {
        playlists = playlistMap;
    }

    @Override
    public void allDownload(Map<Integer, Playlist> playlistMap) {
        alertDialog.dismiss();
        playlists = playlistMap;
        playMedia();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setNext();
                    break;
                case Constant.GetAdLocal:
                    initData();
                    break;
                case 3:
                    setImage();
                    break;
                case 4:
                    playVideo();
                    break;
                case 404:
                    LK_ToastUtil.show("请查看网络或添加离线文件");
                    break;
            }
        }
    };

    private void playMedia() {
        if (playlists.get(0).isDowlond()) {
            if (playlists.get(0).getMediaType() == 1) {
                //图片
                handler.sendEmptyMessage(3);
            } else if (playlists.get(0).getMediaType() == 2) {
                //视频
                handler.sendEmptyMessage(4);
            }
        }
    }

    private AlertDialog alertDialog;

    private int flag = 0;

    private void playVideo() {
        mVideoView.setVideoPath(FileUtils.getVedioPaht() + "/" + playlists.get(flag).getMediaName());
    }

    private void initVideoView() {
        mMediaController = new MediaController(this); //实例化控制器
        mVideoView.setMediaController(mMediaController);  //绑定控制器
        mMediaController.show(5000); //控制器显示5s后自动隐藏
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);//设置播放画质 高画质
        mVideoView.requestFocus();//取得焦点
        //设置一下监听：播放完成的监听，播放准备好的监听，播放出错的监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });

        // 设置播放完成的监听
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                setNext();
            }
        });

        // 设置播放失败的监听
        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return true;
            }
        });
    }

    //显示图片
    public void setImage() {
        hidnVideo();
        String url = FileUtils.getImagePaht() + "/" + playlists.get(flag).getMediaName();
        LK_ImageLoader
                .getInstance()
                .displayImage_SD(url,
                        mImage,
                        ImageShowType.NORMAL,
                        R.drawable.ic_launcher_round);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
        handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void setNext() {
        flag++;
        flag = flag % playlists.size();
        if (playlists.get(flag).getMediaType() == 2) {
            showVideo();
            mVideoView.setVideoPath(FileUtils.getVedioPaht() + "/" + playlists.get(flag).getMediaName());
        } else if (playlists.get(flag).getMediaType() == 1) {
            hidnVideo();
            setImage();
        }
    }

    //隐藏视频，显示图片
    public void hidnVideo() {
        mVideoView.setVisibility(View.GONE);
        mImage.setVisibility(View.VISIBLE);
    }

    //隐藏图片，显示视频
    public void showVideo() {
        mVideoView.setVisibility(View.VISIBLE);
        mImage.setVisibility(View.GONE);
    }

}
