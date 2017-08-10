package com.wenke.vitamiodemo.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenke on 2017/7/18.
 */

public class FileName {

    public static List<File> GetFileName(String path) {
        File file = new File(path);
        File[] subFile = file.listFiles();
        List<File> vedioFile = new ArrayList<>();

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
//                String filename = subFile[iFileLength].getName();
//                    // 判断是否为MP4结尾
//                    if (filename.trim().toLowerCase().endsWith(suffix)) {
                vedioFile.add(subFile[iFileLength]);
//                }
            }
        }
        return vedioFile;
    }


}
