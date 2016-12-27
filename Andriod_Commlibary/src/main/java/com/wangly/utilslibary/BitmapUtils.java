package com.wangly.utilslibary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by wangly on 2016/12/27.
 */

public class BitmapUtils {

    /**
     * BitMap 转换 为 InputStream
     *
     * @param bitmap
     * @return
     */
    public static InputStream bitmapToStream(Bitmap bitmap) {
        InputStream inputStream = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        inputStream = new ByteArrayInputStream(baos.toByteArray());
        return inputStream;

    }


    /**
     * Bitamp 转换为 Byte[]
     * @param inputStream
     * @return
     */
    public static byte[] bitmapToByte(InputStream inputStream) {
        byte[] bimapData = null;
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        bimapData = baos.toByteArray();
        return bimapData;

    }

    /**
     * Byte[] 转换为Bitmap
     * @param data
     * @return
     */
    public static Bitmap byteToBitmap(byte[] data) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
        return bitmap;
    }



}
