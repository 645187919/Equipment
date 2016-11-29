package com.hzy.equipment.fragments;

import java.util.List;
import java.util.zip.Inflater;

import com.hzy.equipment.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FunctionsAdapter extends ArrayAdapter<Functions> {
	private int resourceId;

	public FunctionsAdapter(Context context, int resource, List<Functions> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Functions functions=getItem(position);
		View view;
		ViewHolder holder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			holder=new ViewHolder();
			holder.functions=(TextView) view.findViewById(R.id.textfunction);
			view.setTag(holder);
		}else{
			view=convertView;
			holder=(ViewHolder) view.getTag();
		}
		holder.functions.setText(functions.getTextView());
		return view;
	}
	class ViewHolder{
		TextView functions; 
	}
	
	
	
	
	

	
}
