package com.wenke.vitamiodemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    private ImageView mImage;

    private MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** 加了这句话可以，不加会初始化不成功 */
//        Vitamio.initialize(this);
        Vitamio.isInitialized(getApplication());


        // ~~~ 检测Vitamio是否解压解码包
//        if (!LibsChecker.checkVitamioLibs(this))
//            return;
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mImage = (ImageView) findViewById(R.id.imageview);

        playVideo();
    }

    private String path_net = "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4";
    private String path_net1 = "http://gslb.miaopai.com/stream/3D~8BM-7CZqjZscVBEYr5g__.mp4";

    private String meizi = "https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg";

    private void playVideo() {


        mVideoView.setVideoPath(path_net1);

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
                Log.d("fan","bofangwanle111111");
                Toast.makeText(getApplicationContext(),"feiqilai",Toast.LENGTH_LONG).show();

            }
        });


        // 设置播放完成的监听
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                Log.d("fan","bofangwanle");
                Toast.makeText(getApplicationContext(),"daozhele",Toast.LENGTH_LONG).show();
            }
        });

        // 设置播放失败的监听
        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return true;
            }
        });
        try {
            Thread.sleep(5000);
            handler.sendEmptyMessage(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                mVideoView.setVideoPath(path_net1);
            }
        }
    };
}
