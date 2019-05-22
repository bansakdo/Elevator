package com.example.projectaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{


    public static ArrayList<Activity> actList = new ArrayList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        actList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGachon = (Button)findViewById(R.id.btnGachon);
        Button btnIt = (Button)findViewById(R.id.btnIt);
        Button btnVision = (Button)findViewById(R.id.btnVision);
        Button btnGlobal = (Button)findViewById(R.id.btnGolobal);
        TextView tvGc = (TextView)findViewById(R.id.tv_main_gc);


        Toolbar toolbar = findViewById(R.id.tbMain);
        setSupportActionBar(toolbar);                           //toolbar를 액티비티의 appbar로 지정
        ActionBar ab = getSupportActionBar();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼




        btnGachon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Gachon.class);
                startActivity(in);
            }
        });
        tvGc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Gachon.class);
                startActivity(in);
            }
        });


        btnGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Global.class);
                startActivity(in);
            }
        });

        btnVision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Vision.class);
                startActivity(in);
            }
        });

        btnIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), It.class);
                startActivity(in);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_upside, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item ){
        Intent in = null;
        switch(item.getItemId()){
//            case android.R.id.home:
//                finish();
//                return true;
            case R.id.mitemHome:
//                in = new Intent(getApplicationContext(), MainActivity.class);
//                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                for(int i = 0; i < MainActivity.actList.size(); i++)
//                    MainActivity.actList.get(i).finish();
//                startActivity(in);
//                finish();
                break;
            case R.id.mitemGachon:
                in = new Intent(getApplicationContext(), Gachon.class);
                break;
            case R.id.mitemGlobal:
                in = new Intent(getApplicationContext(), Global.class);
                break;
            case R.id.mitemIt:
                in = new Intent(getApplicationContext(), It.class);
                break;
            case R.id.mitemVision:
                in = new Intent(getApplicationContext(), Vision.class);
                break;
            case R.id.mitemSetting:
                in = new Intent(getApplicationContext(), Setting.class);
                break;
        }
        if(in != null) {
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }

}
