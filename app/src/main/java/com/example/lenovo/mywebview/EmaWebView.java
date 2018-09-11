package com.example.lenovo.mywebview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EmaWebView extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    WebView mWebView;
    String mURL;
    SwipeRefreshLayout mSwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ema_web_view);

        mURL="https://www.prothomalo.com/";
        mSwp=(SwipeRefreshLayout) findViewById(R.id.swp);
        mSwp.setOnRefreshListener(this);
        mWebView=findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().getLoadsImagesAutomatically();
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.loadUrl(mURL);
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onRefresh() {
    mWebView.reload();
    mSwp.setRefreshing(false);

    }
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack())
        {
            mWebView.goBack();
        }
        else

            super.onBackPressed();
    }


}
