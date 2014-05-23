package com.udm.atp.layout;

import com.udm.atp.RSSItem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EpisodeLayout extends LinearLayout 
{
	RSSItem item;
	TextView textView_title, textView_description, textView_duration;
	LinearLayout layout_row1, layout_row2;

	public EpisodeLayout(Context context) 
	{
		super(context);
		init(context);
	}
	
	public EpisodeLayout(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		init(context);
	}
	
	public EpisodeLayout(Context context, RSSItem rssItem) 
	{
		super(context);
		init(context);
		this.item = rssItem;
		textView_description.setText(item.getDescription());
		textView_duration.setText(item.getDuration());
		textView_title.setText(item.getTitle());
	}
	
	void init(Context context)
	{
		layout_row1 = new LinearLayout(context);
		layout_row1.setOrientation(LinearLayout.HORIZONTAL);
		
		textView_title = new TextView(context);
		textView_title.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1));
		layout_row1.addView(textView_title);
		
		textView_duration = new TextView(context);
		textView_duration.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1));
		layout_row1.addView(textView_duration);
		
		layout_row2 = new LinearLayout(context);
		layout_row2.setOrientation(LinearLayout.HORIZONTAL);
		
		textView_description = new TextView(context);
		layout_row2.addView(textView_description);
		
		item = null;
		this.setOrientation(LinearLayout.VERTICAL);
		this.addView(layout_row1);
		this.addView(layout_row2);
	}
	
	public String getTitle()
	{
		return item.getTitle();
	}
	
	public void setTitle(String title)
	{
		item.setTitle(title);
		textView_title.setText(title);
	}
	
	public String getDuration()
	{
		return item.getDuration();
	}
	
	public void setDuration(String duration)
	{
		item.setDuration(duration);
		textView_duration.setText(duration);
	}
	
	public String getDescription()
	{
		return item.getDescription();
	}
	
	public void setDescription(String description)
	{
		item.setDescription(description);
		textView_description.setText(description);
	}
	
	public void setItem(RSSItem rssItem)
	{
		this.item = rssItem;
		textView_description.setText(item.getDescription());
		textView_duration.setText(item.getDuration());
		textView_title.setText(item.getTitle());
	}

}
