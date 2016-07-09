package com.zhuming.commumication.utils.basicutils;

import java.text.SimpleDateFormat;

/**
 * * @author soul
 *
 * @项目名:Commumication
 * @包名: com.bdxht.commumication.utils
 * @作者：祝明
 * @描述：日期格式的帮助类
 * @创建时间：2016/3/22 18:02
 */
public class DataUtils {

    /**
     * 今天
     */
    public static String getToDayData(Long currentTime) {
        //        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(currentTime);
    }

    public static String getbeforeData(Long currentTime) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        return format.format(currentTime);
    }

    public static String getbeforeDataTime(Long currentTime) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:MM:ss");
        return format.format(currentTime);
    }

}
