package com.murraycole.appusagesample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class butter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter);
    }
    public void back1(View v3)
    {
        Intent ibb = new Intent(this, carrot.class);
        startActivity(ibb);
    }

}
