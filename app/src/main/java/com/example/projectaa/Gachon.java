package com.example.projectaa;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class Gachon extends Activity {

    TextView elv1, elv2, elv3, elv4;
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

}
