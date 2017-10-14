package com.murraycole.appusagesample;

import android.app.Activity;
import android.app.usage.UsageStats;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.ActionBarActivity;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Map;

public class CatActivity extends Activity {

    private String catName;
    private int daysAlive;
    private int status;
    private int catLife;
    private long lastTime;
    private long currentTime;

    private long totalTime;

    private TextView catNametv;
    private TextView daysAlivetv;
    private TextView catlives;
    private int i=1;


    private ImageView imv;
    private int[] imageArray;
    private long[] timeArray;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {

                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {


                        //UStats.getUsageStatsList(CatActivity.this);
                            //Intent uintent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                            //startActivity(uintent);



                        String string = bundle.getString(YourService.FILEPATH);
                        timeArray[0] = bundle.getLong(YourService.TIME0);
                        timeArray[1] = bundle.getLong(YourService.TIME1);
                        timeArray[2] = bundle.getLong(YourService.TIME2);
                        timeArray[3] = bundle.getLong(YourService.TIME3);
                        //int updateCat = bundle.getInt(YourService.UPDATECAT);
                        //int asd = updateCat / 5000;
                        currentTime += (timeArray[0] + timeArray[1] + timeArray[2] + timeArray[3]);
                        if(lastTime != 0){
                            //totalTime += currentTime - lastTime;

                        }
                        lastTime += (timeArray[0] + timeArray[1] + timeArray[2] + timeArray[3]);

                        System.out.println(totalTime+" is the time");

                        if(totalTime > 10000){
                            if(catLife<6) {
                                catLife++;
                                i++;
                            }
                            totalTime = 0;

                        }

                        catlives.setText(5-catLife + "");
                        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_cat);
                        layout.setBackgroundResource(imageArray[catLife]);



                        //imv.setImageDrawable(imageArray[asd]);
                        //imv.setImageResource(imageArray[asd]);
                        //Toast.makeText(CatActivity.this,
                        //        string,
                        //Toast.LENGTH_LONG).show();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        timeArray = new long[4];
        catLife = 0;
        totalTime = 0;
        catlives = (TextView) findViewById(R.id.cat_lives);
        lastTime = 0;
        currentTime=0;
//        Intent intent = getIntent();
//        catName = intent.getExtras().getParcelable("name");
//        catName = intent.getExtras("name");
        Bundle extras = getIntent().getExtras();
        catName = extras.getString("name");
//        catName="MEOW";
        daysAlive = 0;

        catNametv = (TextView)findViewById(R.id.cat_name);
        catNametv.setText(catName);

        String days = Integer.toString(daysAlive) +" days alive";
        daysAlivetv = (TextView)findViewById(R.id.cat_days);
        daysAlivetv.setText(days);

        //In oncreate
        imageArray = new int[6];
        imageArray[0] =R.drawable.happiercat_filled;
        imageArray[1] =R.drawable.happycat_filled;
        imageArray[2] =R.drawable.damagedcat_filled;
        imageArray[3] =R.drawable.abusedcat_filled;
        imageArray[4] = R.drawable.deadcat_filled;
        imageArray[5] =R.drawable.ghostcat_filled;

        imv = (ImageView) findViewById(R.id.imageView);

//Starts Service

        Intent intent = new Intent(this, YourService.class);
// add infos for the service which file to download and where to store
        intent.putExtra(YourService.FILENAME, "index.html");
        intent.putExtra(YourService.URL,
                "http://www.vogella.com/index.html");
        Toast.makeText(CatActivity.this,
                "Service Started",
                Toast.LENGTH_LONG).show();
        startService(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        totalTime = 10001;
        registerReceiver(receiver, new IntentFilter(
               YourService.NOTIFICATION));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
    public void cat_goStats(View view){
        Intent intent = new Intent(this, DisplayAppUsage.class);
        intent.putExtra("name", catName);
        startActivity(intent);
    }

}
