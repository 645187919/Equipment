package com.hzy.equipment.activity;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;


import com.baidu.mapapi.SDKInitializer;
import com.hzy.equipment.service.LocationService;

public class LocationApplication extends Application {
	private static Context context;
 
	public LocationService locationService;
      public Vibrator mVibrator;
    @Override
    public void onCreate() {
        super.onCreate();
        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());  
       
    }


	
	
	public static Context getContext() {
		return context;
	}

}
