package com.techram.pondyapp;
import com.techram.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.techram.controller.ActivityWeatherSetting;
public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        TextView t1 = (TextView) findViewById(R.id.textView1);        
        t1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this, NewsList.class);
				startActivity(intent);
			}
		});
        
        TextView t2 = (TextView) findViewById(R.id.textView2);        
        t2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this, ActivityWeatherSetting.class);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }

    
}
