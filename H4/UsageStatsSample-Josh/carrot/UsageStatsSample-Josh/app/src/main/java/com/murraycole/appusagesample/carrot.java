package com.murraycole.appusagesample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class carrot extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrot);
    }

    public void carrottobutter(View v2)
    {
        Intent ib = new Intent(this, butter.class);
        startActivity(ib);
    }
}


