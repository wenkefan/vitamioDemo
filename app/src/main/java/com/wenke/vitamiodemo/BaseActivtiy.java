package com.wenke.vitamiodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wenke.vitamiodemo.file.FileUtils;


/**
 * Created by wenke on 2017/7/18.
 */

public class BaseActivtiy extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FileUtils fileUtils = new FileUtils();
        fileUtils.getSDCar();

    }
}
