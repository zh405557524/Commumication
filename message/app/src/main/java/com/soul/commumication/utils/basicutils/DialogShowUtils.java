package com.zhuming.commumication.utils.basicutils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * * @author soul
 *
 * @作者：祝明
 * @描述：TODO
 * @创建时间：2016/2/26 11:17
 */
public class DialogShowUtils {
    public interface RequestCallBack {
        public void onSuccess(DialogInterface dialog, int which);

        public void onFailure(DialogInterface dialog, int which);
    }

    public interface RequestCallBackLoadData {
        public void onSuccess(String string);

        public void onFailure(String string);

    }

    public static void ShowDialog(Context context, String title, final RequestCallBack requestCallBack) {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                requestCallBack.onSuccess(dialog, which);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestCallBack.onFailure(dialog, which);
            }
        });
        builder.show();

    }


    public static void showAppayRes(final String res, final Context context, final RequestCallBack RequestCallBack) {
        UIUtils.postTaskSafely(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(context)
                        .setMessage(res)
                        .setCancelable(false)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                RequestCallBack.onSuccess(dialog, which);
                            }
                        })
                        .show();
            }
        });
    }

    public static void showAppayRes(final String res, final Context context) {
        UIUtils.postTaskSafely(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(context)
                        .setMessage(res)
                        .setCancelable(false)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }


}
