package com.wenke.vitamiodemo.model;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import testlibrary.hylk.com.loginlibrary.utils.LK_LogUtil;

/**
 * Created by wenke on 2017/7/25.
 */

public class AdvertisingData {

    public static  <T> void GetAdver(String path, Class<T> clasz, OnCallBackAdDataListener listener){
        String data = getFileFromSD(path);
        LK_LogUtil.D("data-----:" + data);
        Gson gson = new Gson();
        Advertising advertising = (Advertising) gson.fromJson(data,clasz);
        listener.call(advertising);
    }


    private static String getFileFromSD(String path) {
        String result = "";
        try {
            FileInputStream f = new FileInputStream(path);
            BufferedReader bis = new BufferedReader(new InputStreamReader(f));
            String line = "";
            while ((line = bis.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public interface OnCallBackAdDataListener{
        void call(Advertising advertising);
    }
}
