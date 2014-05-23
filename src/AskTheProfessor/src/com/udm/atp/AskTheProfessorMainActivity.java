package com.udm.atp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.udm.atp.player.ATPPlayer;

public class AskTheProfessorMainActivity extends Activity implements OnClickListener{
	Timer timer;
	TimerTask timertask;
	ImageView logo;
	boolean contin = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        logo = (ImageView)findViewById(R.id.ATP_Logo);
        logo.setOnClickListener(this);
        
        timer = new Timer(true);
        timertask = new TimerTask() {
			
			@Override
			public void run() {
				contin = true;
			}
		};
        timer.schedule(timertask, 2000);
    }

	public void onClick(View v) {
		if(contin)
		{
			Intent intent = new Intent(this, ATPPlayer.class);
			startActivity(intent);
		}
	}  
}