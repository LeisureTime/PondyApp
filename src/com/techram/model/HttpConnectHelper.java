/******************************************************************************
 * Class       : HttpConnectHelper.java		        		         		  *
 * Main Weather activity, in this demo apps i use API from yahoo, you can     *
 * use other weather web service which you prefer                             *
 *                                                                            *
 * Version     : v1.0                                                         *
 * Date        : May 09, 2011                                                 *
 * Copyright (c)-2011 DatNQ some right reserved                               *
 * You can distribute, modify or what ever you want but WITHOUT ANY WARRANTY  *
 * Be honest by keep credit of this file                                      *
 *                                                                            *
 * If you have any concern, feel free to contact with me via email, i will    *
 * check email in free time                                                   * 
 * Email: nguyendatnq@gmail.com                                               *
 * ---------------------------------------------------------------------------*
 * Modification Logs:                                                         *
 *   KEYCHANGE  DATE          AUTHOR   DESCRIPTION                            *
 * ---------------------------------------------------------------------------*
 *    -------   May 09, 2011  DatNQ    Create new                             *
 ******************************************************************************/
package com.techram.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


import android.os.AsyncTask;
import android.util.Log;

/*******************************************************************************
 * Connect to server helper
 * @author DatNQ
 *
 ******************************************************************************/
public class HttpConnectHelper {
	/** TAG for debugging */
	private static final String TAG = "HttpConnectHelper";

	private Document docData = null;
	public Document getDocData() {
		return docData;
	}

	public void setDocData(Document docData) {
		this.docData = docData;
	}

	/** HTTP Connection */
	private HttpURLConnection httpConnection;

	/***************************************************************************
	 * Connect server
	 * @param strURL URL
	 * @throws IOException
	 * @date May 9, 2011
	 * @time 1:38:18 AM
	 * @author DatNQ
	 **************************************************************************/
	private void requestConnectServer(String strURL) throws IOException {	
		httpConnection = (HttpURLConnection)new URL(strURL).openConnection();
		httpConnection.connect();
		
		if(httpConnection.getResponseCode() != HttpURLConnection.HTTP_OK){
			Log.e(TAG,"Something wrong with connection");
			httpConnection.disconnect();
			throw new IOException("Error in connection: "+ httpConnection.getResponseCode());
		}
	}
	
	/***************************************************************************
	 * Close connection
	 * @date May 9, 2011
	 * @time 1:39:33 AM
	 * @author DatNQ
	 **************************************************************************/
	private void requestDisconnect(){
		if(httpConnection != null){
			httpConnection.disconnect();
		}
	}
	
	/***************************************************************************
	 * Get Document XML
	 * @param strURL URL string
	 * @return
	 * @throws IOException
	 * @date May 9, 2011
	 * @time 1:40:54 AM
	 * @author DatNQ
	 **************************************************************************/
	public void getDocumentFromURL(String strURL) throws IOException {		
		/* Connect to server */
		//requestConnectServer(strURL);
		new loadingTask().execute(strURL);
	}
	
	/***************************************************************************
	 * Get xml document
	 * @return string xml
	 * @throws IOException
	 * @date May 9, 2011
	 * @time 1:43:28 AM
	 * @author DatNQ
	 **************************************************************************/

	
	

	class loadingTask extends AsyncTask<String, Void, String> {

		protected String doInBackground(String... urls) {
			StringBuffer strBuf = new StringBuffer();	
	try{
			HttpURLConnection	httpConnection = (HttpURLConnection)new URL(urls[0]).openConnection();
			httpConnection.connect();
			if(httpConnection.getResponseCode() != HttpURLConnection.HTTP_OK){
				Log.e("Error","Something wrong with connection");
				httpConnection.disconnect();
				throw new IOException("Error in connection: "+ httpConnection.getResponseCode());
			}
			
			String strValue = null;
			InputStream inputStream = httpConnection.getInputStream();
			if (inputStream == null){
				Log.e("Error", "Get input tream error");
				return null;
			}
			
				
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
			String strLine = "";
			
			while ((strLine = buffReader.readLine()) != null){
				strBuf.append(strLine+"\n");
				strValue +=strLine+"\n";
			}
			
			/* Release resource to system */
			buffReader.close();
			inputStream.close();
			httpConnection.disconnect();
			
			
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return strBuf.toString();
		}

		protected void onPostExecute(String s) {			
				Log.i("Data From Yahoo Weather:", s);
				if (s == null){
					Log.e(TAG,"Can not get xml content");
				}
				
				int strContentSize = s.length();
				StringBuffer strBuff = new StringBuffer();
				strBuff.setLength(strContentSize+1);
				strBuff.append(s);
				ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db;
				
				
				try {
					db = dbf.newDocumentBuilder();
					setDocData(db.parse(is));
				} catch (Exception e) {
					Log.e(TAG,"Parser data error");
				}
			
		}
	}
}




/*******************************************************************************
 * END OF FILE
 ******************************************************************************/
