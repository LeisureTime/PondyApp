
package com.techram.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import com.techram.model.WeatherDataModel;
import com.techram.model.WeatherPreferences;
import com.techram.R;


public class ActivityScreenLocation extends Activity implements OnClickListener {
	/** For debugging */
	private static final String TAG = "ActivityScreenLocation";

	/** Querry to get location */
	private static final String GET_LOCATION_WOEID = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20geo.places%20where%20text%3D%22";	
	
	/** Location error*/
	private static final int LOCATION_ERROR = -1;
	
	/** Locattion OK */
	private static final int LOCATION_OK = 0;
	
	/** NO WOEID */
	private static final int LOCATION_NOWOEID = 1;
	
	/** Get data failed */
	private static final int LOCATION_GET_FAILED = 2;
	
	/** Request get location */
	private static final int REG_GET_LOCATION_SATRT = 100;
	
	/** Request get location finish */
	private static final int REG_GET_LOCATION_FINISH = 101;
	
	/** Request searching */
	private static final int REG_GET_LOCATION_SEARCHING = 102;
	
	/** Search button */
	private Button m_btnSearch;
	
	/** Input country */
	private EditText m_Country;
	
	/** Input city */
	//private EditText m_City;
	
	/** Data model */
	private WeatherDataModel m_DataModel;
	
	/** Preference */
	private WeatherPreferences m_Preference;
	
	/** Dialog */
	ProgressDialog m_Dialog;
	
	
	/** Handle request */
	Handler m_HandleRequest;
	
	/** Request result */
	private int m_RequestResult = LOCATION_ERROR;
	

	/*********************************************************
	 * Call when first create activity
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * @author DatNQ
	 *********************************************************/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_location);
		/* Draw screen */
		drawScreen();
	}
	

	/***************************************************************************
	 * Draw screen
	 * @date May 10, 2011
	 * @time 8:49:53 PM
	 * @author DatNQ
	 **************************************************************************/
	private void drawScreen() {
		drawTitle();

	}

	/***************************************************************************
	 * Draw title
	 * @date May 10, 2011
	 * @time 8:49:36 PM
	 * @author DatNQ
	 **************************************************************************/
	private void drawTitle() {
	    setTitle(R.string.strSettingLocationTitle);
	}
	
	
	
	
	/***************************************************************************
	 * Create query to get WOEID
	 * @param strQuerry Location
	 * @return
	 * @date May 9, 2011
	 * @time 9:28:07 PM
	 * @author DatNQ
	 **************************************************************************/
	public static String createQuerryGetWoeid(String strQuerry){
		if (strQuerry == null){
			return null;
		}
		
		StringBuffer strQuerryBuf = new StringBuffer(GET_LOCATION_WOEID);
		strQuerryBuf.append(strQuerry);
		strQuerryBuf.append("%22&format=xml");

		return strQuerryBuf.toString();				
	}


	/***************************************************************************
	 * When button press
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * @author DatNQ
	 **************************************************************************/
	public void onClick(View arg0) {
		/* Get woeid */
		getWoeIDByLocation();
	}
	
	/***************************************************************************
	 * Get woeid by location
	 * @date May 10, 2011
	 * @time 8:52:04 PM
	 * @author DatNQ
	 ***************************************************************************/
	private void getWoeIDByLocation(){
		Message regSearchLocation = new Message();
		regSearchLocation.what = REG_GET_LOCATION_SATRT;
		m_HandleRequest.sendMessage(regSearchLocation);
	}
	

}