package com.mj.agritech;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Reportclass extends Fragment {
    private WebView webView;
    ProgressBar  searchprogressBar;
    TextView prog,patient;
    CountDownTimer countDownTimer;
    Handler handler;
    int i=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reportview, container, false);
        searchprogressBar=view.findViewById(R.id.reportprogress);
        patient=view.findViewById(R.id.patient);
         prog=view.findViewById(R.id.progress);
         handler=new Handler();
new Thread(new Runnable() {
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            final int prg=i;
            try {
                Thread.sleep(1000);

            }catch (Exception e){


            }


        handler.post(new Runnable() {
            @Override
            public void run() {
                prog.setText(prg+"");
            }
        });
        }
        }
}).start();


        webView = (WebView) view.findViewById(R.id.webView1);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://theagriculture.tech/and_files/allreports.php");
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        return  view;
    }
public class WebViewClient extends android.webkit.WebViewClient{

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        searchprogressBar.setVisibility(View.INVISIBLE);
        prog.setVisibility(View.INVISIBLE);
        patient.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        searchprogressBar.setVisibility(View.INVISIBLE);
    }
}
}

