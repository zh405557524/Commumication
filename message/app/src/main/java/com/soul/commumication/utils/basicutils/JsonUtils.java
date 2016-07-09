package com.soul.commumication.utils.basicutils;

import com.google.gson.Gson;

/**
 * * @author Administrator
 *
 * @作者：祝明
 * @描述：TODO
 * @创建时间：2015/12/18 14:15
 */
public class JsonUtils<BEAN> {

    public String getJsonString(BEAN bean) {
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        String jsonStr = "{\"1\":" + json + "}";
        return jsonStr;
    }

    public String getJsonString(BEAN bean, String number) {
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        String jsonStr = "\"" + number + "\":" + json + "";
        return jsonStr;
    }

    public static String getJsonString(String[] parameter) {
        String str = "{";
        for (int x = 0; x < parameter.length; x++) {
            if (x == parameter.length - 1) {
                str = str + parameter[x] + "}";
            } else {
                str = str + parameter[x] + ",";
            }
        }
        return str;
    }
    
}
