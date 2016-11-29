package com.hzy.equipment.fragments.sports;



import com.hzy.equipment.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class XinLvTest extends Activity{
	RingView mringView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xinlv);
		
		 mringView =(RingView) findViewById(R.id.ringView);
		findViewById(R.id.startHeartBeatTest).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mringView.startAnim();
			}
		});
	}

}



