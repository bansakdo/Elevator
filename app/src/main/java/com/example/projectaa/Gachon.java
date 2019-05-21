package com.example.projectaa;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Gachon extends Activity {

    TextView elv1, elv2, elv3, elv4;
    String imgUrl = "http://bansakdo123.iptime.org/phpMyAdmin/data/appimg";
    Bitmap bmImg;
    phpDown task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.actList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gachon);

        Toolbar tb = (Toolbar)findViewById(R.id.tbGachon);
        setActionBar(tb);
        ActionBar ab = getActionBar();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ab.setTitle("가천관");
        elv1 = (TextView)findViewById(R.id.tv_gachon_elv1);
        elv2 = (TextView)findViewById(R.id.tv_gachon_elv2);
        elv3 = (TextView)findViewById(R.id.tv_gachon_elv3);
        elv4 = (TextView)findViewById(R.id.tv_gachon_elv4);

//        task.execute("http://bansakdo123.iptime.org/web/phpMyAdmin/data/connect_mysql.php");
//        task.execute("http://bansakdo123.iptime.org/phpMyAdmin/data/connect_mysql.php");
//        task.execute("http://bansakdo123.iptime.org/run/mysqld/mysqld10.sock/data/connect_mysql.php");
}


    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    protected void onStart() {
        super.onStart();

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
            case android.R.id.home:
                finish();
                return true;
            case R.id.mitemHome:
                in = new Intent(getApplicationContext(), MainActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
/*                for(int i = 0; i < MainActivity.actList.size(); i++)
                    MainActivity.actList.get(i).finish();
                startActivity(in);
                finish();*/
                break;
            case R.id.mitemGachon:
//                in = new Intent(getApplicationContext(), Gachon.class);
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



    private class back extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);

            } catch(Exception e) {
                e.printStackTrace();
            }
            return bmImg;
        }

//        protected void onPostExecute(Bitmap img) {
//            imView.setImageBitmap(bitImg);
//        }
    }

    private class phpDown extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder jsonHtml = new StringBuilder();
            try {
                // 연결 url 설정
                URL url = new URL(urls[0]);
                //connection 객체 생성
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //연결 됬으면
                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    //연결되었음 코드기 리턴되면(연결 확인되면)
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        while(true) {
                            //웹상에 보여지는 텍스트를 라인 단위로 읽어 저장
                            String line = br.readLine();
                            if(line == null) break;
                            //저장된 텍스트 라인을 jsonHtml에 붙여넣음
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            return jsonHtml.toString();
        }

        protected void onPostExcute(String str) {
            elv1.setText(str);
        }

    }

}



