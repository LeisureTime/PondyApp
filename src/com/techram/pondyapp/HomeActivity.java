package com.techram.pondyapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import com.google.ads.AdView;
import com.techram.R;
public class HomeActivity extends Activity {
	private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || 
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                //we are connected to a network
                connected = true;
            }
            else
            	showPopUp();
        
        if(connected){
        Handler handler = new Handler();
        
        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
            public void run() {
                // make sure we close the splash screen so the user won't come back when it presses back key
 
                finish();
                // start the home screen
 
                Intent intent = new Intent(HomeActivity.this, NewsList.class);
                HomeActivity.this.startActivity(intent);
 
            }
 
        }, 2000); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
 
        }
     /*   TextView t1 = (TextView) findViewById(R.id.textView1);        
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
       */ 
        /*if (adView == null) {
			adView = (AdView)this.findViewById(R.id.AdView);
			adView.loadAd(new AdRequest());

		} else {
			adView.loadAd(new AdRequest());
		}*/
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }*/
    /*
    @Override
   public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }*/

    private void showPopUp() {

    	 AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
    	 helpBuilder.setTitle("Connection failed");
    	 helpBuilder.setMessage("Application requires internet connection. Enable your mobile network or wifi");
    	 helpBuilder.setPositiveButton("Close",
    	   new DialogInterface.OnClickListener() {

    	    public void onClick(DialogInterface dialog, int which) {
    	     // Do nothing but close the dialog
    	    	finish();
    	    }
    	   });

    	 // Remember, create doesn't show the dialog
    	 AlertDialog helpDialog = helpBuilder.create();
    	 helpDialog.show();

    	}
}
