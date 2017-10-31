package com.grass.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 * Gson 工具类
 */
public final class GsonQuick {
    /**
     * Json 解析器
     */
    private static final JsonParser PARSER = new JsonParser();

    private static Gson gson = null;

    /**
     * 设置一个通用的Gson
     *
     * @param gs
     */
    public static void setGson(Gson gs) {
        gson = gs;
    }

    public static Gson getGson() {
        if (gson == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            builder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
            builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            gson = builder.create();
        }
        return gson;
    }

    /**
     * 获取Json对象里面的键, 并将其值以String返回.<br/>
     * 当值为json对象或者json数组时,返回其json格式的字符串
     *
     * @param json
     * @param key
     * @return
     */
    public static String getString(String json, String key) {
        JsonElement element = PARSER.parse(json);
        if (element.isJsonObject()) {
            JsonObject obj = element.getAsJsonObject();
            JsonElement value = obj.get(key);
            if (value != null) {
                if (value instanceof JsonPrimitive) {
                    return value.getAsString();
                } else if (value instanceof JsonNull) {
                    return null;
                } else {
                    return value.toString();
                }
            }
        }
        return null;
    }

    /**
     * 将json解析为一个JsonObject
     *
     * @param json
     * @return
     */
    public static JsonObject toJsonObject(String json) {
        JsonElement element = PARSER.parse(json);
        return element.getAsJsonObject();
    }

    /**
     * 将json解析为一个JsonArray
     *
     * @param json
     * @return
     */
    public static JsonArray toJsonArray(String json) {
        JsonElement element = PARSER.parse(json);
        return element.getAsJsonArray();
    }

    /**
     * 将json对象序列化为一个对象实例
     *
     * @param json
     * @param clss 要序列化为的对象
     * @return
     */
    public static <T> T toObject(String json, Class<T> clss) {
        Gson gson = getGson();
        return gson.fromJson(json, clss);
    }

    /**
     * 将json数组序列化为一个对象的List实例
     *
     * @param json
     * @param clss 对象类型
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clss) {
        JsonElement element = PARSER.parse(json);
        if (element.isJsonArray()) {
            Gson gson = getGson();
            JsonArray array = element.getAsJsonArray();
            int size = array.size();
            ArrayList<T> result = new ArrayList<T>(size);
            for (int i = 0; i < size; i++) {
                JsonElement item = array.get(i);
                T t = gson.fromJson(item, clss);
                result.add(t);
            }
            return result;
        }
        return null;
    }

    /***
     * 将对象转换成相对应的字符串
     *
     * @return json字符串
     */
    public static String toJsonFromBean(Object obj) {
        try {
            Gson gson = getGson();
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 将list集合转换成相对应的字符串
     *
     * @param lists
     *            需要转换的list集合
     * @return
     */
    public static <T> String toJsonFromList(List<T> lists) {
        try {
            Gson gson = getGson();
            TypeToken<List<T>> type = new TypeToken<List<T>>() {
            };
            return gson.toJson(lists, type.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将map集合转换成相对应的字符串
     *
     * @param map
     * @return
     */
    public static <T> String toJsonFromMap(Map<String, T> map) {
        try {
            Gson gson = getGson();
            TypeToken<Map<String, T>> type = new TypeToken<Map<String, T>>() {
            };
            return gson.toJson(map, type.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将list<map<>>集合转换成相对应的字符串
     *
     * @param listMaps
     * @return
     */
    public static <T> String toJsonFromListMap(List<Map<String, T>> listMaps) {
        try {
            Gson gson = getGson();
            TypeToken<List<Map<String, T>>> type = new TypeToken<List<Map<String, T>>>() {
            };
            return gson.toJson(listMaps, type.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能:将请求参数转换成数组形式
     *
     * @param parms
     * @return
     * @author: huchao
     * @date:2015-5-27下午5:19:44
     */
    public static String paramsToJson(Map<String, String> parms) {
        List<Map<String, String>> jsonArray = new ArrayList<Map<String, String>>();
        jsonArray.add(parms);
        return toJsonFromList(jsonArray);
    }

    /**
     * created by ascend
     * 移除list集合中每个对象特定的属性
     *
     * @param list
     * @param proptery
     * @return
     */
    public static String removePropertyFromList(List list, String proptery) {
        JsonArray retJsonArray = new JsonArray();
        Gson gson = getGson();
        JsonElement sources = gson.toJsonTree(list);
        if (sources.isJsonArray()) {
            Iterator<JsonElement> it = sources.getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonElement element = it.next();
                if (element.isJsonObject()) {
                    JsonObject object = element.getAsJsonObject();
                    object.remove(proptery);
                    retJsonArray.add(object);
                }
            }
        }
        return retJsonArray.toString();
    }

    /**
     * created by ascend
     * 移除list集合中每个对象特定的属性
     *
     * @param list
     * @param properties 字符串数组
     * @return
     */
    public static String removePropertyFromList(List list, String[] properties) {
        JsonArray retJsonArray = new JsonArray();
        Gson gson = getGson();
        JsonElement sources = gson.toJsonTree(list);
        if (sources.isJsonArray()) {
            Iterator<JsonElement> it = sources.getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonElement element = it.next();
                if (element.isJsonObject()) {
                    JsonObject object = element.getAsJsonObject();
                    for (String property : properties) {
                        object.remove(property);
                    }
                    retJsonArray.add(object);
                }
            }
        }
        return retJsonArray.toString();
    }

    /**
     * created by ascend
     * 移除对象中的制定的属性
     *
     * @param object     制定对象
     * @param properties 字符串数组
     * @return
     */
    public static String removePropertiesFromObject(Object object, String[] properties) {
        Gson gson = getGson();
        JsonElement jsonElement = gson.toJsonTree(object);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (String property : properties) {
            jsonObject.remove(property);
        }
        return jsonObject.toString();
    }

    /**
     * created by ascend
     * 移除list集合中每个对象特定的属性
     *
     * @param list
     * @param properties
     * @param <T>
     * @return 返回原类型
     */
    public static <T> List removePropertiesFromList(List<T> list, String[] properties) {
        JsonArray retJsonArray = new JsonArray();
        Gson gson = getGson();
        JsonElement sources = gson.toJsonTree(list);
        if (sources.isJsonArray()) {
            Iterator<JsonElement> it = sources.getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonElement element = it.next();
                if (element.isJsonObject()) {
                    JsonObject object = element.getAsJsonObject();
                    for (String property : properties) {
                        object.remove(property);
                    }
                    retJsonArray.add(object);
                }
            }
        }
        Type type = new TypeToken<T>() {
        }.getType();
        return gson.fromJson(retJsonArray, type);
    }


}
