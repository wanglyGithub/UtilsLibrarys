package com.wangly.utilslibary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：Administrator
 * 创建时间：2017/1/8 01:20
 * 描述：SharedPreferences 工具类
 */

public class SharedPreUtils {
    private String fileName = "config";
    private static SharedPreUtils instance;
    private SharedPreferences preferences;
    private SharedPreUtils(Context context) {
        context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
    }


    public static synchronized SharedPreUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreUtils(context);
        }
        return instance;
    }
}
