package com.huaxing.account.pay.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Class Name: com.huaxing.account.pay.utils.JsonUtils
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 16:45
 * Description: JsonUtils
 * ==================================
 */
public class JsonUtils {

    public static JSONObject page(Integer code, String count, String msg, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("count", count);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject;
    }
}
