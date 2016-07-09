package com.soul.commumication.utils.basicutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Administrator
 * @项目名: gemry_android
 * @包名: gemryservice.util
 * @作者： 祝明
 * @描述： TODO
 * @创建时间：2015/11/10 21:29
 * @verion $REV$
 * @updateAuthor $AUTHOR$
 * @updateDate 2015/11/10$
 * @updateDes ${TODO}
 */
public class UploadImageUtils {

    //计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }


    // 根据路径获得图片并压缩，返回bitmap用于显示
    public static Bitmap getSmallBitmap(String filePath) {
        BitmapFactory.Options options = null;
        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;// 允许可清除

        options.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果
        BitmapFactory.decodeFile(filePath, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static Bitmap bm;


    public static void clearBitamp() {
        if (bm != null) {
            bm.recycle();
            bm = null;
        }
    }


    //把bitmap转换成String
    public static byte[] bitmapToString(int percentage, String filePath) {
        bm = getSmallBitmap(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, percentage, baos);
        byte[] b = baos.toByteArray();
        //        if (bm != null) {
        //            bm.recycle();
        //        }
        //        return_normal Base64.encodeToString(b, Base64.DEFAULT);
        return b;
    }

    /**
     * 把bitmap转成String
     *
     * @return
     */
    public static String bitmapToString(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
//        if (bm != null) {
//            bm.recycle();
//        }
        return Base64.encodeToString(b, Base64.DEFAULT);
        //        return_normal b;
    }

    //获取压缩后的图片
    public static Bitmap bitmapToCompressPicture(String filePath) {
        bm = getSmallBitmap(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 40, baos);
        return bm;
    }

    //获取压缩后的图片
    public static Bitmap bitmapToCompressPicture(int percentage, String filePath) {
        clearBitamp();
        bm = getSmallBitmap(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, percentage, baos);
        return bm;
    }


    //判断图片是否可以上传
    public static boolean isUpload(String url) {
        boolean flag = true;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        // 仅仅读取图片的头信息, 不加载图片的内容. 不消耗内存
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(url, opts);
        // 获取到图片的宽高
        int picWidth = opts.outWidth;
        int picHeight = opts.outHeight;
        if (picHeight > 10 * picWidth) {
            flag = false;
        }
        if (picWidth > 10 * picHeight) {
            flag = false;
        }
        return flag;
    }
    public static Bitmap getHttpBitmap(String url) {
        Bitmap bitmap = null;
        try {
            URL pictureUrl = new URL(url);
            InputStream in = pictureUrl.openStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
