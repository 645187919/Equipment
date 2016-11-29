package com.hzy.equipment.fragment.setting;

import com.hzy.equipment.R;

/*
 * @author ��տ��
 * @version 1.0
 * 
 * ����ʱ��  2015/8/15
 * 
 * ��������1.0��ʵ�ֻ������������塢����ʱ��Ļ����ϣ������˱任���ӱ����Ĺ��ܡ�
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

public class AlarmAlert extends Activity {
	MediaPlayer mediaPlayer1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mediaPlayer1 = MediaPlayer.create(this, R.raw.music);
		mediaPlayer1.start();

		new AlertDialog.Builder(AlarmAlert.this)
				
				.setTitle("闹铃响了")
				.setMessage("小懒猪，快起床！！！")
				.setPositiveButton("再睡会~~~",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								mediaPlayer1.stop();
								AlarmAlert.this.finish();
							}
						}).show();
		
		//AlarmAlert.PlaySound(getApplicationContext());
	}
	
	/*public static int PlaySound(final Context context) { 
        NotificationManager mgr = (NotificationManager) context 
                .getSystemService(Context.NOTIFICATION_SERVICE); 
        Notification nt = new Notification(); 
        nt.sound=Uri.parse("android.resource://" +"/" +R.raw.music); 
        nt.defaults = Notification.DEFAULT_SOUND; 
        int soundId = new Random(System.currentTimeMillis()) 
                .nextInt(Integer.MAX_VALUE); 
        mgr.notify(soundId, nt); 
        return soundId; 
    }*/
}
