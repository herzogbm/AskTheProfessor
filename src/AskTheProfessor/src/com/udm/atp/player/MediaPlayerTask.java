package com.udm.atp.player;

import java.lang.ref.WeakReference;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MediaPlayerTask extends TimerTask implements Runnable, OnSeekBarChangeListener{
	private final WeakReference<MediaPlayer> player;
	private final WeakReference<SeekBar> seekbar;
	Handler handler;
	
	public MediaPlayerTask(MediaPlayer mplayer, SeekBar seek, Handler handler)
	{
		player = new WeakReference<MediaPlayer>(mplayer);
		seekbar = new WeakReference<SeekBar>(seek);
		seek.setOnSeekBarChangeListener(this);
		this.handler = handler; 
	}

	@Override
	public void run() {
		handler.post(new Runnable() {
			
			public void run() {
				int pos, duration;
				MediaPlayer mPlayer = player.get();
				SeekBar seek = seekbar.get();
				
				pos = mPlayer.getCurrentPosition();
				duration = mPlayer.getDuration();
				seek.setMax(duration);
				seek.setProgress(pos);
			}
		});
	}
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if(fromUser)
		{
			MediaPlayer mPlayer = player.get();
			mPlayer.seekTo(progress);
		}
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
