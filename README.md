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

ERR_UNKNOW_URL_SCHEME

无法识别自定义的 scheme 协议，例如：alipays://，weixin://，baidumap://xxx；webview只能识别 http:// 或 https:// 开头的 url

解决方法：
如果对自定义的 scheme 协议进行处理：
public boolean shouldOverrideUrlLoading(WebView view, String url) {

    if(url.startsWith("baidumap://")){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        return true;
    }
    return super.shouldOverrideUrlLoading(view, url);
}
如果不想对自定义的 scheme 协议进行处理：
public boolean shouldOverrideUrlLoading(WebView view, String url) {

    if(url.startsWith("http://") || url.startsWith("https://")){
        view.loadUrl(url);
        return true;
    }
    return super.shouldOverrideUrlLoading(view, url);
}


跳转浏览器，不是在本应用内打开网页

解决方法：重写 WebViewClient 的 shouldOverrideUrlLoading(WebView view, String url) 方法，并执行 WebView.setWebViewClient();


使用document.referrer 获取前一页的 url 为空

如果返回 true，url会交给app本身处理，返回 false，url会交给webview处理

解决方法：重写 WebViewClient 的 shouldOverrideUrlLoading(WebView view, String url) 方法，返回 false