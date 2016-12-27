package com.wangly.utilslibary;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangly on 2016/12/27.
 */

public class FastJsonUtils {
    /**
     * 将JsonString 转换为 JavaBean
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T getJsonObject(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将JsonString 转换为 List<JavaBean>、List<String>
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> List<T> getJsonsArray(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将JsonString 转换为 List<JavaBean>、List<String>
     *
     * @param jsonString
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getJsonArray(String jsonString) {
        List<T> list = new ArrayList<T>();
        try {
            list = (List<T>) JSON.parseArray(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 将JsonString 转换为 List<Map<String,Object>>
     * @param jsonString
     * @return
     */
    public static List<Map<String, Object>> getJsonListMap(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {

            list = JSON.parseObject(jsonString,
                    new TypeReference<List<Map<String, Object>>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将JavaBean 反序列化为 JsonString 文本
     * @param cls
     * @return
     */
    public static <T> String getSerializeObject(Class<T> cls){
        String jsonString = "";
        try {
            jsonString = JSON.toJSONString(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
