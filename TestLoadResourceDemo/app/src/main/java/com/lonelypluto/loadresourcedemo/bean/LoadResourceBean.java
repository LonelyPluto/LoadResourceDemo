package com.lonelypluto.loadresourcedemo.bean;

import android.content.res.Resources;

/**
 * @Description: 资源加载bean
 * @author: ZhangYW
 * @time: 2018/9/17 10:48
 */
public class LoadResourceBean {
    /**
     * 资源
     */
    private Resources resources;
    /**
     *  包名
     */
    private String packageName;
    /**
     * 类加载器
     */
    private ClassLoader classLoader;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
