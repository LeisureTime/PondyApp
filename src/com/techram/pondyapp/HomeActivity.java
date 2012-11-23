package com.techram.pondyapp;
import com.techram.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.ads.*;
import com.techram.controller.ActivityWeatherSetting;
public class HomeActivity extends Activity {
	private AdView adView;
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
        
        /*if (adView == null) {
			adView = (AdView)this.findViewById(R.id.AdView);
			adView.loadAd(new AdRequest());

		} else {
			adView.loadAd(new AdRequest());
		}*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    /*
    @Override
   public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }*/

    
}
