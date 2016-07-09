package com.soul.commumication.utils.basicutils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * * @author Administrator
 *
 * @项目名:wc360_android
 * @包名: com.vtcomm.wangcai360.utils
 * @作者：祝明
 * @描述：TODO
 * @创建时间：2015/12/30 11:40
 */
public class ShowDialogUtils {
    private static ProgressDialog mPd;
    private static boolean flag = true;

    public static void showDialog(final String msg, final Context context) {
        UIUtils.postTaskSafely(new Runnable() {
            @Override
            public void run() {
                mPd = new ProgressDialog(context);
                mPd.setCancelable(false);
                mPd.setMessage(msg);
                mPd.show();
            }
        });
    }

    public static void setCancelable(boolean flag) {
        ShowDialogUtils.flag = flag;
    }

    public static void closeDialog() {
        UIUtils.postTaskSafely(new Runnable() {
            @Override
            public void run() {
                if (mPd != null) {
                    ShowDialogUtils.flag = true;
                    mPd.dismiss();
                }
            }
        });
    }
}
