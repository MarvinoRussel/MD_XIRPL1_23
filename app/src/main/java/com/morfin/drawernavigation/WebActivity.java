package com.morfin.drawernavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView web;
    ProgressDialog load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        load = new ProgressDialog(WebActivity.this);
        load.setMessage("Loading . . . .");
        load.show();

        getActionBar().setDisplayHomeAsUpEnabled(true);
        web = findViewById(R.id.webView);
        web.loadUrl("https://www.youtube.com");
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                load.dismiss();
                getSupportActionBar().setTitle(web.getTitle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()){
            web.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
