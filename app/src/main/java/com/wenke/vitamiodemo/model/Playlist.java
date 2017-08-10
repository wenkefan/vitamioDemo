package com.wenke.vitamiodemo.model;

import java.io.Serializable;

/**
 * Created by wenke on 2017/7/26.
 */

public class Playlist implements Serializable {

    private int AdId;//ID
    private int BroadcastOrder;//顺序号
    private int MediaType;//播放类型
    private String MediaFile;//播放网络地址
    private String MediaName;//视频名称
    private boolean Dowlond;//是否下载

    public boolean isDowlond() {
        return Dowlond;
    }

    public void setDowlond(boolean dowlond) {
        Dowlond = dowlond;
    }

    public int getBroadcastOrder() {
        return BroadcastOrder;
    }

    public void setBroadcastOrder(int broadcastOrder) {
        BroadcastOrder = broadcastOrder;
    }

    public int getMediaType() {
        return MediaType;
    }

    public void setMediaType(int mediaType) {
        MediaType = mediaType;
    }

    public String getMediaFile() {
        return MediaFile;
    }

    public void setMediaFile(String mediaFile) {
        MediaFile = mediaFile;
    }

    public String getMediaName() {
        return MediaName;
    }

    public void setMediaName(String mediaName) {
        MediaName = mediaName;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "AdId=" + AdId +
                ", BroadcastOrder=" + BroadcastOrder +
                ", MediaType=" + MediaType +
                ", MediaFile='" + MediaFile + '\'' +
                ", MediaName='" + MediaName + '\'' +
                ", Dowlond=" + Dowlond +
                '}';
    }
}
