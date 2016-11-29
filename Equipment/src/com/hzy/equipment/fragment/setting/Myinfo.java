package com.hzy.equipment.fragment.setting;

import com.hzy.equipment.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Myinfo extends Activity  {
	private RelativeLayout re_name;
	private TextView text_name;
	
		
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_myinfo);
		re_name=(RelativeLayout) findViewById(R.id.layout_name);
		text_name=(TextView) findViewById(R.id.text_name);
		text_name.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("点击事件", "点击事件被执行了");
				final EditText localEditText = new EditText(getApplicationContext());
				AlertDialog.Builder aDialog=new AlertDialog.Builder(getApplicationContext());
				aDialog.setTitle("请输入名字")
				.setView(localEditText)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.i("点击事件", "编辑框点击事件被执行了");
						String string=localEditText.getText().toString();

						if(string!=null){
							Myinfo.this.text_name.setText(string);
							return;
							
							
						}
				        Toast.makeText(getApplicationContext(), "请输入ID", 1000).show();

					}
				});
				
			}
		});
		
				
				/*setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final EditText localEditText = new EditText(getApplicationContext());
				AlertDialog.Builder aDialog=new AlertDialog.Builder(getApplicationContext());
				aDialog.setTitle("请输入名字")
				.setView(localEditText)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String string=localEditText.getText().toString();

						if(string!=null){
							Myinfo.this.text_name.setText(string);
							return;
							
							
						}
				        Toast.makeText(getApplicationContext(), "请输入ID", 1000).show();

					}
				});
			/*	new AlertDialog.Builder(this).setTitle("请输入").setIcon(
					     android.R.drawable.ic_dialog_info).setView(
					     new EditText(this)).setPositiveButton("确定", null)
					     .setNegativeButton("取消", null).show();
				
			}
		});*/
		
	
	}
	/*@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case 1:
			if(resultCode==RESULT_OK){
				String id=data.getStringExtra("ID");
				text_name.setText(id);
			}
			
			break;

		default:
			break;
		}
	}

*/


	
}
	