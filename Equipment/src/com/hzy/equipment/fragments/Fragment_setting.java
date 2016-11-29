package com.hzy.equipment.fragments;


import com.hzy.equipment.R;
import com.hzy.equipment.fragment.setting.AboutUs;
import com.hzy.equipment.fragment.setting.MyAlarm;
import com.hzy.equipment.fragment.setting.MyGoal;
import com.hzy.equipment.fragment.setting.Myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class Fragment_setting extends Fragment implements OnClickListener{
	RelativeLayout re_myInfo;
	RelativeLayout re_myGoal;
	RelativeLayout re_myAlarm;
	RelativeLayout re_aboutUs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_setting, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		intView();
		
	}
/*	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	        RelativeLayout re_myinfo = (RelativeLayout) getView().findViewById(
	                R.id.re_myinfo);
	        re_myinfo.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                startActivity(new Intent(getActivity(),
	                        MyUserInfoActivity.class));
	            }

	        });
	        RelativeLayout re_setting = (RelativeLayout) getView().findViewById(
	                R.id.re_setting);
	        re_setting.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                startActivity(new Intent(getActivity(), SettingActivity.class));
	            }

	        });
	       
	       
	    }

	    

 * 
 * */
	private void intView() {
		re_myInfo=(RelativeLayout) getView().findViewById(R.id.layout_profile);
		re_myGoal=(RelativeLayout) getView().findViewById(R.id.layout_goal);		
		re_myAlarm=(RelativeLayout) getView().findViewById(R.id.layout_alarm);		
		re_aboutUs=(RelativeLayout) getView().findViewById(R.id.layout_about_us);
		re_aboutUs.setOnClickListener(this);
		re_myAlarm.setOnClickListener(this);
		re_myGoal.setOnClickListener(this);
		re_myInfo.setOnClickListener(this);

		

	}
@Override
public void onClick(View v) {
	switch (v.getId()) {
	case R.id.layout_about_us:
		Intent intent1=new Intent(getContext(),AboutUs.class);
		startActivity(intent1);
		break;
case R.id.layout_alarm:
	Intent intent2=new Intent(getContext(),MyAlarm.class);
	startActivity(intent2);
		break;
case R.id.layout_goal:
	Intent intent3=new Intent(getContext(),MyGoal.class);
	startActivity(intent3);
	break;
case R.id.layout_profile:
	Intent intent4=new Intent(getContext(),Myinfo.class);
	startActivity(intent4);
	break;

	default:
		break;
	}
	
}
}
