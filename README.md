# LoadResourceDemo
android动态加载外部资源文件
# Screenshots
![](screenshot/LoadResource.gif.gif)
# 说明
进入程序时下载不同的资源文件包对应不同的图片、文字和颜色（有点类似替换主题）。通过ClassLoader获取apk中资源的.R返回资源id，创建Resources对象设置资源id得到具体的图片、文字和颜色。
文件夹中LoadResourceDemo为程序运行demo，TestResourceApk1和TestResourceApk2为资源项目，testResource1.apk和testResource2.apk是生成好的资源apk文件可直接放到手机中作为读取。
