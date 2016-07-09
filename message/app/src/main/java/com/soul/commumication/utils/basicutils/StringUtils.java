package com.zhuming.commumication.utils.basicutils;

import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class StringUtils {


    public final static String UTF_8 = "utf-8";


    public static String toArrayString(List list) {

        return list.toString().replace("[", "").replace("]", "").trim();
    }


    /**
     * 判断字符串是否有值，如果为null或者是空字符串或者只有空格或者为"null"字符串，则返回true，否则则返回false
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim()) && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断多个字符串是否相等，如果其中有一个为空字符串或者null，则返回false，只有全相等才返回true
     */
    public static boolean isEquals(String... agrs) {
        String last = null;
        for (int i = 0; i < agrs.length; i++) {
            String str = agrs[i];
            if (isEmpty(str)) {
                return false;
            }
            if (last != null && !str.equalsIgnoreCase(last)) {
                return false;
            }
            last = str;
        }
        return true;
    }

    /**
     * 返回一个高亮spannable
     *
     * @param content 文本内容
     * @param color   高亮颜色
     * @param start   起始位置
     * @param end     结束位置
     * @return 高亮spannable
     */
    public static CharSequence getHighLightText(String content, int color, int start, int end) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        start = start >= 0 ? start : 0;
        end = end <= content.length() ? end : content.length();
        SpannableString spannable = new SpannableString(content);
        CharacterStyle span = new ForegroundColorSpan(color);
        spannable.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    /**
     * 获取链接样式的字符串，即字符串下面有下划线
     *
     * @param resId 文字资源
     * @return 返回链接样式的字符串
     */
    public static Spanned getHtmlStyleString(int resId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"\"><u><b>").append(UIUtils.getString(resId)).append(" </b></u></a>");
        return Html.fromHtml(sb.toString());
    }

    /**
     * 格式化文件大小，不保留末尾的0
     */
    public static String formatFileSize(long len) {
        return formatFileSize(len, false);
    }

    /**
     * 格式化文件大小，保留末尾的0，达到长度一致
     */
    public static String formatFileSize(long len, boolean keepZero) {
        String size;
        DecimalFormat formatKeepTwoZero = new DecimalFormat("#.00");
        DecimalFormat formatKeepOneZero = new DecimalFormat("#.0");
        if (len < 1024) {
            size = String.valueOf(len + "B");
        } else if (len < 10 * 1024) {
            // [0, 10KB)，保留两位小数
            size = String.valueOf(len * 100 / 1024 / (float) 100) + "KB";
        } else if (len < 100 * 1024) {
            // [10KB, 100KB)，保留一位小数
            size = String.valueOf(len * 10 / 1024 / (float) 10) + "KB";
        } else if (len < 1024 * 1024) {
            // [100KB, 1MB)，个位四舍五入
            size = String.valueOf(len / 1024) + "KB";
        } else if (len < 10 * 1024 * 1024) {
            // [1MB, 10MB)，保留两位小数
            if (keepZero) {
                size = String.valueOf(formatKeepTwoZero.format(len * 100 / 1024 / 1024 / (float) 100)) + "MB";
            } else {
                size = String.valueOf(len * 100 / 1024 / 1024 / (float) 100) + "MB";
            }
        } else if (len < 100 * 1024 * 1024) {
            // [10MB, 100MB)，保留一位小数
            if (keepZero) {
                size = String.valueOf(formatKeepOneZero.format(len * 10 / 1024 / 1024 / (float) 10)) + "MB";
            } else {
                size = String.valueOf(len * 10 / 1024 / 1024 / (float) 10) + "MB";
            }
        } else if (len < 1024 * 1024 * 1024) {
            // [100MB, 1GB)，个位四舍五入
            size = String.valueOf(len / 1024 / 1024) + "MB";
        } else {
            // [1GB, ...)，保留两位小数
            size = String.valueOf(len * 100 / 1024 / 1024 / 1024 / (float) 100) + "GB";
        }
        return size;
    }

    /**
     * @param string  图片的拼接地址
     * @param baseUrl 图片所对应的地址
     * @return 图片的地址
     */
    public static String[] toImageUrlArray(String string, String baseUrl) {
        try {
            if (string == null)
                return null;
            String[] split = string.split(",");
            String[] str = new String[split.length];
            for (int i = 0; i < split.length; i++) {
                str[i] = baseUrl + split[i].trim();
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }

    }

    /**
     * 截取小数点后面的数据
     */

    public static String CutPoint(String number) {
        String str = "";
        if (number.contains(".")) {
            int i = number.indexOf(".");
            str = number.substring(0,5);

        } else {
//            str = number;
        }
        return str;
    }

    /**
     * 把一个字符串 转成Map
     */

    public static HashMap<String, String> toMap(String names) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        if (!TextUtils.isEmpty(names.trim())) {
            String[] split = names.replace("{", "").trim().replace("}", "").trim().split(",");
            for (String string : split) {
                String[] split1 = string.split("=");
                stringStringHashMap.put(split1[0].trim(), split1[1].trim());
            }
            return stringStringHashMap;
        }
        return stringStringHashMap;
    }


    /**
     * 秒变日期格式
     */

    public static String getFormatedDateTime(long tiem) {
        String day = "";
        String hour = "00";
        String minute = ":00:";
        String second = "00";
        long d = tiem / (60 * 60 * 24);
        if (d > 0) {
            day = d + "天";
        }
        long h = tiem % (60 * 60 * 24) / (60 * 60);
        if (h > 0) {
            if (h < 10) {
                hour = "0" + h + "";
            } else {
                hour = h + "";
            }
        }

        long m = tiem % (60 * 60 * 24) % (60 * 60) / 60;
        if (m > 0) {
            if (m < 10) {

                minute = ":0" + m + ":";
            } else {

                minute = ":" + m + ":";
            }
        }

        long s = tiem % (60 * 60 * 24) % (60 * 60) % 60;
        if (s > 0) {
            if (s < 10) {

                second = "0" + s + "";
            } else {
                second = s + "";

            }
        }
        return day + hour + minute + second;
    }

    public static String getFormatedDateTime1(long tiem) {
        String day = "";
        String hour = "00";
        String minute = ":00:";
        String second = "00";
        long d = tiem / (60 * 60 * 24);

        long h = tiem / (60 * 60);
        if (h > 0) {
            if (h < 10) {
                hour = "0" + h + "";
            } else {
                hour = h + "";
            }
        }

        long m = tiem % (60 * 60 * 24) % (60 * 60) / 60;
        if (m > 0) {
            if (m < 10) {

                minute = ":0" + m + ":";
            } else {

                minute = ":" + m + ":";
            }
        }

        long s = tiem % (60 * 60 * 24) % (60 * 60) % 60;
        if (s > 0) {
            if (s < 10) {

                second = "0" + s + "";
            } else {
                second = s + "";

            }
        }
        return day + hour + minute + second;
    }

    public static String getFormatedDateTime3(long tiem) {
        String day = "";
        String hour = "0时";
        String minute = "0分";
        String second = "0秒";
        long d = tiem / (60 * 60 * 24);
        if (d > 0) {
            day = d + "天";
        }
        long h = tiem % (60 * 60 * 24) / (60 * 60);
        if (h > 0) {
            if (h < 10) {
                hour = "0" + h + "时";
            } else {
                hour = h + "时";
            }
        }

        long m = tiem % (60 * 60 * 24) % (60 * 60) / 60;
        if (m > 0) {
            if (m < 10) {

                minute = "0" + m + "分";
            } else {

                minute = m + "分";
            }
        }

        long s = tiem % (60 * 60 * 24) % (60 * 60) % 60;
        if (s > 0) {
            if (s < 10) {

                second = "0" + s + "秒";
            } else {
                second = s + "秒";

            }
        }
        return day + hour + minute + second;
    }


    /**
     * 把数值改成金钱模式的数值
     */
    public static String getMoneyNumber(String num) {
        //        CharSequence s = addComma(num);
        CharSequence s = num;
        String number = "";
        if (num.contains(".")) {
            if (num.length() - 1 - num.indexOf(".") > 2) {
                s = num.substring(0,
                        num.indexOf(".") + 3);
                number = s.toString();
            }
        }
        if (num.trim().substring(0).equals(".")) {
            s = "0" + s;
            number = s.toString();
        }
        if (num.startsWith("0")
                && num.trim().length() > 1) {
            if (!num.substring(1, 2).equals(".")) {
                number = num;
            }
        }
        return number;
    }

    /**
     * 02
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     * 03
     * <p/>
     * 04
     *
     * @param str 无逗号的数字
     *            05
     *            <a href="http://home.51cto.com/index.php?s=/space/34010" target="_blank">@return_normal</a> 加上逗号的数字
     *            06
     */
    public static String addComma(String str) {
        if (str.contains(",")) {
            str = str.replace(",", "");
        }

        if (str.toString().contains(".")) {
            if (str.length() - 1 - str.toString().indexOf(".") > 2) {
                str = str.toString().substring(0,
                        str.toString().indexOf(".") + 3);
            }
        }
        if (str.toString().trim().substring(0).equals(".")) {
            str = "0" + str;
        }
        if (str.toString().startsWith("0")
                && str.toString().trim().length() > 1) {
            if (!str.toString().substring(1, 2).equals(".")) {
                str = str.substring(0, 1);
            }
        }


        if (!str.contains(".")) {
            // 将传进数字反转
            String reverseStr = new StringBuilder(str).reverse().toString();
            String strTemp = "";
            for (int i = 0; i < reverseStr.length(); i++) {
                if (i * 3 + 3 > reverseStr.length()) {
                    strTemp += reverseStr.substring(i * 3, reverseStr.length());
                    break;
                }
                strTemp += reverseStr.substring(i * 3, i * 3 + 3) + ",";
            }
            // 将[789,456,] 中最后一个[,]去除
            if (strTemp.endsWith(",")) {
                strTemp = strTemp.substring(0, strTemp.length() - 1);
            }
            // 将数字重新反转
            String resultStr = new StringBuilder(strTemp).reverse().toString();
            return resultStr;
        } else {
            String[] split = str.split("\\.");


            String reverseStr = new StringBuilder(split[0]).reverse().toString();
            String strTemp = "";
            for (int i = 0; i < reverseStr.length(); i++) {
                if (i * 3 + 3 > reverseStr.length()) {
                    strTemp += reverseStr.substring(i * 3, reverseStr.length());
                    break;
                }
                strTemp += reverseStr.substring(i * 3, i * 3 + 3) + ",";
            }
            // 将[789,456,] 中最后一个[,]去除
            if (strTemp.endsWith(",")) {
                strTemp = strTemp.substring(0, strTemp.length() - 1);
            }
            // 将数字重新反转
            String resultStr = new StringBuilder(strTemp).reverse().toString();


            return resultStr + "." + split[1].trim();
        }
    }

}
