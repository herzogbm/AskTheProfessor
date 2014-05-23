package com.udm.atp.player;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.ActionBar;
import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.udm.atp.R;
import com.udm.atp.RSSParserAsyncTask;

public class ATPPlayer extends Activity implements OnClickListener, OnSeekBarChangeListener, OnItemClickListener
{
    RSSParserAsyncTask fetchEpisodes;
    //MediaController controller;
    // The tag we put on debug messages
    final static String TAG = "ATPPlayer";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list_layout);
        
        // Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.DISPLAY_SHOW_TITLE);
		actionBar.setDisplayHomeAsUpEnabled(false);
		
		// Set click listeners
		((ImageButton)findViewById(R.id.button_next)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.button_play_pause)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.button_previous)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.button_shuffle)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.button_stop)).setOnClickListener(this);
		((SeekBar)findViewById(R.id.seekBar)).setOnSeekBarChangeListener(this);
		
        ListView listview = (ListView)findViewById(R.id.listView_episodes);
        listview.setOnItemClickListener(this);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        fetchEpisodes = new RSSParserAsyncTask();
        fetchEpisodes.setListView(listview);
        
        try 
        {
			fetchEpisodes.execute(new URL("http://www.udmercy.edu/atp/atp.rss"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	

    }
    
	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.button_next:
			break;
		case R.id.button_play_pause:
			break;
		case R.id.button_previous:
			break;
		case R.id.button_shuffle:
			break;
		case R.id.button_stop:
			break;
		default:Log.d(TAG, "Unhandled button click!");
			break;
		}
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if(seekBar.getId() != R.id.seekBar)
		{
			Log.d(TAG, "Unhandled seekBar!");
			return;
		}
		else
		{
			if(fromUser)
			{
				// Seek to stop location
			}
		}
	}
	
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		// Pause playing
	}
	
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		// Resume playing?
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}
}