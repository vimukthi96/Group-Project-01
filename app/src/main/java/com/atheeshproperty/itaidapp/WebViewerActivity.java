package com.atheeshproperty.itaidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewerActivity extends AppCompatActivity {
    private WebView webView;
    // String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        String sub =i.getStringExtra("subtitle");
        String lang=i.getStringExtra("title");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String quote = databaseAccess.getLink(sub,lang);
        databaseAccess.close();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView =(WebView) this.<View>findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(quote);


    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

