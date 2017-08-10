package com.wenke.vitamiodemo.network;

/**
 * Created by wenke on 2017/7/24.
 */

public class API {
    public static final String ceshiApi = "http://192.168.1.128:8077";//建政测试地址


    private static final String advertising = ceshiApi + "/Weixin/GetAdList?";//广告地址


    public static String GetAdvertising = advertising + "KgId=%1$s&BroadcastType=%2$s";

}
