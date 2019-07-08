package pers.dg.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loadUrl();
    }

    private void loadUrl() {
        webView.loadUrl("http://www.baidu.com");
    }

    private void initView() {

        webView = findViewById(R.id.webview);

        webView.setWebViewClient(new CustomWebViewClient());

        setWebViewDefaultSettings(webView);
    }

    private void setWebViewDefaultSettings(WebView webView){
        WebSettings settings = webView.getSettings();

        //允许调用js，默认false
        settings.setJavaScriptEnabled(true);

        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(true);
        settings.setBuiltInZoomControls(true);
    }
}
