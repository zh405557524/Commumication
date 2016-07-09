package com.zhuming.commumication.utils.basicutils;

import android.app.Activity;
import android.widget.Toast;

public class ShowToast {
	/**
	 * @param context
	 * @param mess
	 *            显示的消息
	 */
	public static void show(final Activity context, final String mess) {
		// 子线程打印吐司
		if (Thread.currentThread().getName().equals("main")) {
			Toast.makeText(context, mess, 0).show();
		} else {
			// 子线程打印吐司
			context.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
