package com.hzy.equipment.activity;



import java.util.ArrayList;
import java.util.List;

import com.hzy.equipment.R;
import com.hzy.equipment.fragments.Fragment_finding;
import com.hzy.equipment.fragments.Fragment_setting;
import com.hzy.equipment.fragments.Fragment_sports;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements  OnClickListener{
	private ViewPager myViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragment=new ArrayList<Fragment>();
	private LinearLayout mSport;
	private LinearLayout mFinding;
	private LinearLayout mSetting;
	private ImageButton mImgSport;
	private ImageButton mImgFinding;
	private ImageButton mImgSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
	}

	private void initEvent() {
		mFinding.setOnClickListener(this);
		mSetting.setOnClickListener(this);
		mSport.setOnClickListener(this);
		myViewPager.setOnPageChangeListener(
				new OnPageChangeListener() {
					
					@Override
					public void onPageSelected(int arg0) {

						int currentPager=myViewPager.getCurrentItem();
						switch (currentPager) {
						case 0:
							restImg();
							mImgSport.setImageResource(R.drawable.ic_steps_select);
							break;
						case 1:
							restImg();
							mImgFinding.setImageResource(R.drawable.ic_distance_select);
							break;
						case 2:
							restImg();
							mImgSetting.setImageResource(R.drawable.icon_settings_pressed);
							break;

						default:
							
							break;
						}
						
					}
					
				

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onPageScrollStateChanged(int arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		
		
	
	}
	private void restImg() {
		 mImgFinding.setImageResource(R.drawable.ic_distance_normal);
		 mImgSetting.setImageResource(R.drawable.icon_settings_normal);
		 mImgSport.setImageResource(R.drawable.ic_steps_normal);
		
	}

	private void initView() {
		myViewPager=(ViewPager) findViewById(R.id.Viewpager);
		mSport=(LinearLayout) findViewById(R.id.id_tab_yundong);
				mFinding=(LinearLayout) findViewById(R.id.id_tab_dingwei);
				mSetting=(LinearLayout) findViewById(R.id.id_tab_setting);
				mImgFinding=(ImageButton) findViewById(R.id.id_tab_dingwei_img);
				mImgSetting=(ImageButton) findViewById(R.id.id_tab_setting_img);
				mImgSport=(ImageButton) findViewById(R.id.id_tab_yundong_img);
				mFragment=new ArrayList<Fragment>();
				Fragment mSport1=new Fragment_sports();
				Fragment mFinding1=new Fragment_finding();
				Fragment mSetting1=new Fragment_setting();
				
				mFragment.add(mSport1);
				mFragment.add(mFinding1);
				mFragment.add(mSetting1);
				mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
					
					@Override
					public int getCount() {
						// TODO Auto-generated method stub
						return mFragment.size();
					}
					
					@Override
					public Fragment getItem(int arg0) {
						// TODO Auto-generated method stub
						return mFragment.get(arg0);
					}
				};
				myViewPager.setAdapter(mAdapter);




	}

	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab_yundong:
			myViewPager.setCurrentItem(0);
			restImg();
			mImgSport.setImageResource(R.drawable.ic_steps_select);
			
			
			break;
        case R.id.id_tab_dingwei:
        	myViewPager.setCurrentItem(1);
        	restImg();
        	mImgFinding.setImageResource(R.drawable.ic_distance_select);
			
			break;
			case R.id.id_tab_setting:
				myViewPager.setCurrentItem(2);
				restImg();
				mImgSetting.setImageResource(R.drawable.icon_settings_pressed);
				
				break;

		default:
			break;
		}		
	}

	
	
}