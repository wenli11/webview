# webview

打开网页错误

ERR_CLEARTEXT_NOT_PERMITTED

因为Android 9.0对未加密的流量不信任，添加了新的权限

解决方法：在 Android 的 mainfest.mxl 中的 application 中加入配置 android:usesCleartextTraffic="true"

ERR_CACHE_MISS

缺少网络权限

解决方法：在 Android 的 mainfest.mxl 中加入权限 <uses-permission android:name="android.permission.INTERNET"/>

ERR_NAME_NOT_RESOLVED

1、可能没有网络

解决方法：1、查看有没有网络，打开wifi或者流量


跳转浏览器，不是在本应用内打开网页

解决方法：重写 WebViewClient 的 shouldOverrideUrlLoading(WebView view, String url) 方法，并执行 WebView.setWebViewClient();


使用document.referrer 获取前一页的 url 为空

如果返回 true，url会交给app本身处理，返回 false，url会交给webview处理

解决方法：重写 WebViewClient 的 shouldOverrideUrlLoading(WebView view, String url) 方法，返回 false