package com.hzy.equipment.receiver;



import android.content.Context;  
import android.content.Intent;

import com.hzy.equipment.fragment.setting.AlarmAlert;

import android.content.BroadcastReceiver;  
import android.os.Bundle;  
  
public class RingAlarm extends BroadcastReceiver  
{  
  @Override  
  public void onReceive(Context context, Intent intent)  
  {  
    Intent i = new Intent(context, AlarmAlert.class);     
    Bundle bundleRet = new Bundle();  
    bundleRet.putString("STR_CALLER", "");  
    i.putExtras(bundleRet);  
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
    context.startActivity(i);  
  }  
}  