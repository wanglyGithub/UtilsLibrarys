package com.wangly.utilslibary;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者：Administrator
 * 创建时间：2017/1/7 23:39
 * 描述：公共的Dialog 工具类
 * TODO ：切记，还未完成，待续写。
 *
 */

public class ProUtis extends Dialog {
    private boolean cancelable;
    private int titileId;
    private CharSequence message;
    private int messageId;
    private int iconId;
    private Drawable icon;
    private boolean isShow;

    //控件
    private TextView tv_Title;
    private TextView tv_Message;
    private ImageView iv_Icon;


    public ProUtis(Context context, Builder builder) {
        super(context);
        this.cancelable = builder.cancelable;
        this.titileId = builder.titileId;
        this.message = builder.message;
        this.messageId = builder.messageId;
        this.iconId = builder.iconId;
        this.icon = builder.icon;
        this.isShow = builder.isShow;


    }

    public ProUtis(Context context, int themeResId) {
        super(context, themeResId);


        setContentView(R.layout.layout_dialog);
        initView();
    }

    private void initView() {
        tv_Title = (TextView) findViewById(R.id.tv_title);
        tv_Message = (TextView) findViewById(R.id.tv_message);
        iv_Icon = (ImageView) findViewById(R.id.iv_icon);


    }


    public void setCancelable(boolean cancelable) {
        this.setCancelable(cancelable);
    }

    public void setTitle(int titileId) {
        if (titileId > 0) {
            // 通过String.xml 设置Dialog 标题
            tv_Title.setVisibility(View.VISIBLE);
            tv_Title.setText(titileId);
        }
    }

    public void setMessage(CharSequence message) {
        if (!"".equals(message) && null != message) {
            tv_Message.setVisibility(View.VISIBLE);
            tv_Message.setText(message);
        }
    }

    public void setMessage(int messageId) {
        if (messageId > 0) {
            tv_Message.setVisibility(View.VISIBLE);
            tv_Message.setText(messageId);
        }
    }

    public void show() {
        if (this.isShow) {
            this.show();
        }
    }

    public void dismiss() {
        if (isShowing()) {
            this.dismiss();
        }
    }

    public static class Builder {

        private boolean cancelable;
        private int titileId;
        private CharSequence message;
        private int messageId;
        private int iconId;
        private Drawable icon;
        private Context mContext;
        private boolean isShow;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder(Context context, int ResId) {

        }


        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setTitle(int titileId) {
            this.titileId = titileId;
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setIcon(int iconId) {
            this.iconId = iconId;
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            return this;
        }

        public Builder show() {
            this.isShow = true;
            return this;
        }


        public ProUtis build() {
            return new ProUtis(mContext, this);
        }
    }
}




