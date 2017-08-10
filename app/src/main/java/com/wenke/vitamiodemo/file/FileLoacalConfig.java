package com.wenke.vitamiodemo.file;

import com.wenke.vitamiodemo.Constant;
import com.wenke.vitamiodemo.model.Advertising;
import com.wenke.vitamiodemo.model.AdvertisingData;
import com.wenke.vitamiodemo.model.Playlist;
import com.wenke.vitamiodemo.network.API;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testlibrary.hylk.com.loginlibrary.utils.LK_LogUtil;

/**
 * Created by wenke on 2017/8/9.
 */

public class FileLoacalConfig {


    private Map<Integer, Playlist> playlists;

    public void getAdLocal() {//加载本地配置文件
        AdvertisingData.GetAdver(FileUtils.getSettingPaht() + "/" + Constant.SettingName, Advertising.class,
                new AdvertisingData.OnCallBackAdDataListener() {
                    @Override
                    public void call(Advertising advertising) {
                        if (advertising != null) {
                            LK_LogUtil.D(advertising.toString());
                            playlists = new HashMap<>();
                            int order = 0;
                            for (int i = 0; i < advertising.getAdList().size(); i++) {
                                if (i == 0) {
                                    order = 0;
                                } else {
                                    order = order + advertising.getAdList().get(i - 1).getAdcontentList().size();
                                }
                                String name = advertising.getAdList().get(i).getName();
                                int ord = 0;
                                for (Advertising.AdListBean.AdcontentListBean listBean : advertising.getAdList().get(i).getAdcontentList()) {
                                    Playlist playlist = new Playlist();
                                    playlist.setBroadcastOrder(listBean.getBroadcastOrder());
                                    playlist.setMediaType(listBean.getMediaType());
                                    playlist.setMediaFile(API.ceshiApi + listBean.getMediaFile());
                                    String[] lastNames = listBean.getMediaFile().split("/");
                                    String lastName = lastNames[lastNames.length - 1];
                                    playlist.setMediaName(name + lastName);
                                    playlist.setDowlond(false);
                                    LK_LogUtil.D(playlist.toString());
                                    playlists.put(ord + order, playlist);
                                    ord++;
                                }
                            }

                        } else {
                            LK_LogUtil.D("null");
                        }
                        LK_LogUtil.D("加载成功");
                        initData();
                    }
                });
    }

    private void initData() {
        List<File> videoFileName = FileName.GetFileName(FileUtils.getVedioPaht());
        List<File> imageFileName = FileName.GetFileName(FileUtils.getImagePaht());

        deleteFile(imageFileName, 1);
        deleteFile(videoFileName, 2);


        for (int i = 0; i < playlists.size(); i++) {
            int flag = playlists.get(i).getMediaType();
            if (flag == 1) {
                //图片
                for (int j = 0; j < imageFileName.size(); j++) {
                    if (playlists.get(i).getMediaName().equals(imageFileName.get(j).getName())) {
                        playlists.get(i).setDowlond(true);
                        break;
                    }
                }
            } else if (flag == 2) {
                //视频
                for (int j = 0; j < videoFileName.size(); j++) {
                    if (playlists.get(i).getMediaName().equals(videoFileName.get(j).getName())) {
                        playlists.get(i).setDowlond(true);
                        break;
                    }
                }
            }
        }
        callBack.CallBack(playlists);
    }

    private void deleteFile(List<File> FileName, int flage) {
        for (int i = 0; i < FileName.size(); i++){
            for (int j = 0; j < playlists.size(); j++){
                if (playlists.get(j).getMediaType() == flage){
                    if (FileName.get(i).getName().equals(playlists.get(j).getMediaName())){
                        break;
                    } else if (j == playlists.size() - 1){
                        FileName.get(i).delete();
                    }
                }
            }

        }
    }

    public interface FileLoacalConfigCallBack {
        void CallBack(Map<Integer, Playlist> playlistMap);
    }

    FileLoacalConfigCallBack callBack;

    public void OnFileLoacalConfigCallBack(FileLoacalConfigCallBack callBack){
        this.callBack = callBack;
    }

}
