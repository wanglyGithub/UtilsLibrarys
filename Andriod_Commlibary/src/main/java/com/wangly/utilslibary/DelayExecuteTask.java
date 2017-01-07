package com.wangly.utilslibary;

import android.os.Handler;
import android.os.Message;

/**
 * 作者：Administrator
 * 创建时间：2017/1/7 23:25
 * 描述：
 * TODO: 延时执行某个任务
 */

public abstract class DelayExecuteTask {
    public static int What = 111;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            onMainExecute();
        }
    };

    abstract void onMainExecute();


    /**
     * 执行某个延时的任务
     *
     * @param delayMillis 延时时间
     */

    public void execute(long delayMillis) {
        handler.sendEmptyMessageDelayed(What, delayMillis);
    }
}
