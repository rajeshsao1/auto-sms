package com.autosms.myapplicationcallevent;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class AboutAppActivity extends AppCompatActivity {
    String url = "http://eagleitsolutions.in/AutoTextSms";
    WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_about_app);
        WebView webView2 = (WebView) findViewById(R.id.webview);
        this.webView = webView2;
        webView2.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
