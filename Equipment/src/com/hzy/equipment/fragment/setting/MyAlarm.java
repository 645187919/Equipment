package com.hzy.equipment.fragment.setting;

import java.util.Calendar;


import com.hzy.equipment.R;
import com.hzy.equipment.receiver.RingAlarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MyAlarm extends Activity {
	private ToggleButton bt_wakeUp;
	private RelativeLayout rl_wakeUp;
	private TextView tv_timeWakeUp;
	boolean isClicked = false ;
	private Calendar c = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_myalarm);
		initView();
	}
	private void initView() {
		bt_wakeUp=(ToggleButton) findViewById(R.id.button_alarm_switch);
		rl_wakeUp=(RelativeLayout) findViewById(R.id.rl_alarm);
		tv_timeWakeUp=(TextView) findViewById(R.id.text_time);
		rl_wakeUp.setOnClickListener(new RelativeLayout.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				c.setTimeInMillis(System.currentTimeMillis());  
		        int mHour_0=c.get(Calendar.HOUR_OF_DAY);  
		        int mMinute_0=c.get(Calendar.MINUTE);  
		        new TimePickerDialog(MyAlarm.this,  
			             new TimePickerDialog.OnTimeSetListener()  
			             {                  
			               public void onTimeSet(TimePicker view,int hourOfDay,  
			                                     int minute)  
			               {  
			            	   c.setTimeInMillis(System.currentTimeMillis());  
				                 
				                 c.set(Calendar.HOUR_OF_DAY,hourOfDay);  
				                 c.set(Calendar.MINUTE,minute);  
				                 c.set(Calendar.SECOND,0);  
				                 c.set(Calendar.MILLISECOND,0);  
				                 
				                 long date = c.getTimeInMillis();
				                 
				                 if(c.getTimeInMillis() < System.currentTimeMillis()){ 
				                     c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1); 
				                 } 
				                   
				                 Intent intent = new Intent(MyAlarm.this,RingAlarm.class);  
				                 PendingIntent sender=PendingIntent.getBroadcast(  
				                		 MyAlarm.this,0, intent, 0);  
				                 AlarmManager am;  
				                 am = (AlarmManager)getSystemService(ALARM_SERVICE);  
				                 am.set(AlarmManager.RTC_WAKEUP,  
				                        c.getTimeInMillis(),  
				                        sender  
				                  );  
				                 
				                 String str = format(hourOfDay)+":"+format(minute);  
				                 tv_timeWakeUp.setText(str);
				                 SharedPreferences textChange = getPreferences(0);  
				                 SharedPreferences.Editor editor_1 = textChange.edit();  
				                 editor_1.putString("TIME1", str);  
				                 editor_1.commit();
				                 //times[0].replaceAll(times[0].toString(),tmpS);
				       
				                 //SharedPreferences保存数据，并提交  
				                 SharedPreferences timeShare = getPreferences(0);  
				                 SharedPreferences.Editor editor = timeShare.edit();  
				                 editor.putString("TIME1", str);  
				                 editor.commit();  
				                   
				                 Toast.makeText(MyAlarm.this,"我的闹钟时间为"+str,  
				                   Toast.LENGTH_SHORT)  
				                   .show();
			            	   
			                
			                	 am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 
											1 * 60 * 1000, sender);
			                	 isClicked = false;
			                 }

						private String format(int x) {
							 
					        String s=""+x;  
					       if(s.length()==1) s="0"+s;  
					       return s;  
						}
			               }            
			             ,mHour_0,mMinute_0,true).show();
				
				
			}
			
		});
		
	bt_wakeUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			 if (isChecked) {
		            // The toggle is enabled
		        } else {
		        	Intent intent = new Intent(MyAlarm.this, RingAlarm.class);
					PendingIntent pi = PendingIntent.getBroadcast(MyAlarm.this, 0,
							intent, 0);
					AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
					//取消警报
					am.cancel(pi);
					tv_timeWakeUp.setText("闹钟取消");
					//取消闹钟的同时取消音乐
					stopService(new Intent("com.example.alarm1.MUSIC"));
		        }			
		}
	});	
	}
}
	
