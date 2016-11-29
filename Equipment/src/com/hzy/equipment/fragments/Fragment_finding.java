package com.hzy.equipment.fragments;

import java.util.ArrayList;
import java.util.List;


import com.hzy.equipment.R;
import com.hzy.equipment.activity.LocationApplication;
import com.hzy.equipment.fragment.functions.BusLineSearchDemo;
import com.hzy.equipment.fragment.functions.Compass;
import com.hzy.equipment.fragment.functions.PoiSearchDemo;
import com.hzy.equipment.fragment.functions.RoutePlanDemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Fragment_finding extends Fragment implements OnItemClickListener {
	private ListView mlistView;
	private List<Functions> functionsList=new ArrayList<Functions>();
	private FunctionsAdapter fAdapter;
	
	
	
	
	@Override
	public void onAttach(Context context) {
		// TODO Auto-generated method stub
		super.onAttach(context);
		functionsList=inItFunctions();
		fAdapter =new FunctionsAdapter(context, R.layout.item,functionsList);
	}
     private List<Functions> inItFunctions() {
		Functions f1=new Functions("POI搜索");
		functionsList.add(f1);
		Functions f2=new Functions("路线规划");
		functionsList.add(f2);
		Functions f3=new Functions("公交线路查询");
		functionsList.add(f3);
		Functions f4=new Functions("指南针");
		functionsList.add(f4);
		return functionsList;
	}
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View v=inflater.inflate(R.layout.fragment_finding, container, false);
	 
	mlistView=(ListView) v.findViewById(R.id.weiqiu_listView);
	mlistView.setAdapter(fAdapter);
	mlistView.setOnItemClickListener(this);
	
	return v;
}
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	Functions ft=functionsList.get(position);
	if (ft.getTextView()=="POI搜索") {
		Intent intent1=new Intent(getContext(),PoiSearchDemo.class);
		startActivity(intent1);
	}else if (ft.getTextView()=="路线规划") {
		Intent intent2=new Intent(getContext(),RoutePlanDemo.class);
		startActivity(intent2);
	}else if (ft.getTextView()=="公交线路查询") {
		Intent intent3=new Intent(getContext(),BusLineSearchDemo.class);
		startActivity(intent3);
	}else if (ft.getTextView()=="指南针") {
		Intent intent4=new Intent(getContext(),Compass.class);
		startActivity(intent4);
	
}
}}
/*
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		News news=newsList.get(position);
		if(news.getTitle()=="ZZ"){
			Intent intent=new Intent(MyApplication.getContext(),ChatActivity.class);
			startActivity(intent);
			
		}
		
	}


}

 * */
