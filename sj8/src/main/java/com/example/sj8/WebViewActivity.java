package com.example.sj8;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.taobao.com");
        WebSettings settings = webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
        settings.setJavaScriptEnabled(true);
        WebView.setWebContentsDebuggingEnabled(true);
    }
}