package com.wangly.utilslibary;

import android.text.TextUtils;

/**
 * Created by wangly on 2016/12/27.
 */

public class StringUtils {
    public static boolean isEmpty(String text) {
        if (TextUtils.isEmpty(text) || "".equals(text)|| null == text) {
            return true;
        }
        return false;
    }
}
