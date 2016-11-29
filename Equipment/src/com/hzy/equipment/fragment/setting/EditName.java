package com.hzy.equipment.fragment.setting;

import com.hzy.equipment.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditName extends Activity implements OnClickListener{
	private EditText eText;
	private Button btsave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_editname);
		eText=(EditText) findViewById(R.id.ed_text);
		btsave=(Button) findViewById(R.id.bt_save);

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_save:
			if(eText.getText()==null){
				Toast.makeText(getApplicationContext(), "请输入ID",1000).show();
			}
			
				Intent intent=new Intent();
				String iD=eText.getText().toString();
				intent.putExtra("ID", iD);
				setResult(RESULT_OK, intent);
				finish();
				
			
			break;

		default:
			break;
		}
		
	}

}
