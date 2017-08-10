package com.wenke.vitamiodemo.file;

import android.os.Environment;
import android.util.Log;

import com.wenke.vitamiodemo.Constant;

import java.io.File;

/**
 * Created by wenke on 2017/7/14.
 */

public class FileUtils {
    //判断是否有sda卡
    //判断目标文件夹是否存在
    public void getSDCar() {
        File sdCar = null;
        sdCar = setPath();
        String vedio = sdCar + Constant.VedioPath;
        String image = sdCar + Constant.ImagePath;
        String setting = sdCar + Constant.SettingPath;
        File vedioFile = new File(vedio);
        File imageFile = new File(image);
        File settingFile = new File(setting);
        if (!vedioFile.exists()) {
            vedioFile.mkdirs();
        }
        if (!imageFile.exists()) {
            imageFile.mkdirs();
        }
        if (!settingFile.exists()) {
            settingFile.mkdirs();
        }
    }

    private static File setPath() {
        String sd = Environment.getExternalStorageState();
        if (sd.equals(Environment.MEDIA_MOUNTED)){
            return Environment.getExternalStorageDirectory();
        } else {
            return Environment.getDataDirectory();
        }
    }

    public static String getVedioPaht(){
        return setPath().getPath() + Constant.VedioPath;
    }
    public static String getImagePaht(){
        return setPath().getPath() + Constant.ImagePath;
    }
    public static String getSettingPaht(){
        return setPath().getPath() + Constant.SettingPath;
    }
}
