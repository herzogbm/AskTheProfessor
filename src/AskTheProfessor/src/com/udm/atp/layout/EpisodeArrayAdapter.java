package com.udm.atp.layout;
import java.util.List;

import com.udm.atp.RSSItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * 
 */

/**
 * @author Brandon
 *
 */
public class EpisodeArrayAdapter extends ArrayAdapter<RSSItem> {

	public EpisodeArrayAdapter(Context context, int textViewResourceId,
			List<RSSItem> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return new EpisodeLayout(this.getContext(), this.getItem(position));
	}
}
