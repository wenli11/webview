# webview

打开网页错误

ERR_CLEARTEXT_NOT_PERMITTED

因为Android 9.0对未加密的流量不信任，添加了新的权限

解决方法：在 Android 的 mainfest.mxl 中的 application 中加入配置 android:usesCleartextTraffic="true"

ERR_CACHE_MISS

ERR_NAME_NOT_RESOLVED


跳转浏览器，不是在本应用内打开网页

解决方法：重写 WebViewClient 的 shouldOverrideUrlLoading(WebView view, String url) 方法，并执行 WebView.setWebViewClient();