package com.soul.commumication.utils.basicutils;

import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

/**
 * * @author Administrator
 *
 * @项目名:wc360_android
 * @包名: com.vtcomm.wangcai360.utils
 * @作者：祝明
 * @描述：TODO
 * @创建时间：2015/12/31 14:36
 */
public class StartActvityUtils {
    public static void StartActvity(final Activity activity, final HashMap<String, Integer> map) {
       UIUtils.postTaskSafely(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(UIUtils.getContext(), activity.getClass());
                if (map != null) {
                    for (Map.Entry<String, Integer> enry : map.entrySet()) {
                        intent.putExtra(enry.getKey(), enry.getValue());
                    }
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                UIUtils.getContext().startActivity(intent);
            }
        });
    }
}
