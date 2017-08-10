package com.wenke.vitamiodemo;

import android.app.Application;
import android.content.Context;

import testlibrary.hylk.com.loginlibrary.utils.LK_MyApplication;


/**
 * Created by wenke on 2017/7/18.
 */

public class VitamioApp extends LK_MyApplication {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public Context getmContext(){
        return mContext;
    }
}
