package com.hzy.equipment.fragments;

import com.hzy.equipment.R;
import com.hzy.equipment.fragments.sports.LocationFilter;
import com.hzy.equipment.fragments.sports.XinLvTest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_sports extends Fragment implements OnClickListener{
	private Button routeTest;
	private Button xlTest;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_sport, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		routeTest=(Button) getView().findViewById(R.id.button_SportRoute);
		xlTest=(Button) getView().findViewById(R.id.button_xinlv);
		routeTest.setOnClickListener(this);
		xlTest.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button_SportRoute:
			Intent intent11=new Intent(getContext(),LocationFilter.class);
			startActivity(intent11);
			break;
		case R.id.button_xinlv:
			Intent intent12=new Intent(getContext(),XinLvTest.class);
			startActivity(intent12);
			break;
		
		default:
			break;
		}
	}

}
