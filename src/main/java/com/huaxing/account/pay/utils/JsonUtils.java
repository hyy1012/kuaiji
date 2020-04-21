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

    /**
     * layui table返回的固定格式
     *
     * @param code  状态码
     * @param count list全部的数量
     * @param msg   消息
     * @param data  数据
     * @return
     */
    public static JSONObject page(Integer code, long count, String msg, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("count", count);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject;
    }

    /**
     * 不返回dto的json
     * @param code 状态码
     * @param msg 消息
     * @return
     */
    public static JSONObject common(Integer code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject;
    }
}
