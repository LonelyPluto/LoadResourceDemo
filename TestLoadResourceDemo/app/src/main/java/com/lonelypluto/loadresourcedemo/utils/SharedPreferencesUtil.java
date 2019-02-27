/**
 *
 */
package com.lonelypluto.loadresourcedemo.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.lonelypluto.loadresourcedemo.constants.SPConsts;

/**
 * @Description:
 * @author: sts
 * @time: 2018/9/6 9:03
 */
public class SharedPreferencesUtil {


    private static SharedPreferences sharedPreferences;

    /**
     * 初始化 在application中
     *
     * @param application
     */
    public static void init(Application application) {

        sharedPreferences = application.getSharedPreferences(SPConsts.SP_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 资源路径
     *
     * @return (def " ")
     */
    public static String getResourcePath() {
        String str_resourcePath;
        str_resourcePath = sharedPreferences.getString(SPConsts.SP_RESOURCE_PATH, "");
        return str_resourcePath;
    }

    /**
     * 插入
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value.getClass() == Boolean.class) {
            editor.putBoolean(key, (Boolean) value);
        }
        if (value.getClass() == String.class) {
            editor.putString(key, (String) value);
        }
        if (value.getClass() == Integer.class) {
            editor.putInt(key, ((Integer) value).intValue());
        }

        editor.commit();
    }


    /**
     * 清空所有
     * @param context
     * @param keys
     */
    public static void cleanStringValue(Context context, String... keys) {
        for (String key : keys) {
            SharedPreferences settings = context.getSharedPreferences(
                    SPConsts.SP_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            if (settings.contains(key)) {
                editor.remove(key).commit();
            }
        }
    }

    /**
     * 删除
     */
    public static void delete() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(SPConsts.SP_RESOURCE_PATH);
        editor.commit();
    }

}
