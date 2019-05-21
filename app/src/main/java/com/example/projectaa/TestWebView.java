package com.example.projectaa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class TestWebView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_test);

        TextView tv = (TextView)findViewById(R.id.tvWv);
        Button btn = (Button)findViewById(R.id. btnWv);
        WebView wv = (WebView)findViewById(R.id.wv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String url =
            }
        });
    }
}
