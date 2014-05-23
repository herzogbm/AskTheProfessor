/**
 * 
 */
package com.udm.atp;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.udm.atp.layout.EpisodeArrayAdapter;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Brandon
 *
 */
public class RSSParserAsyncTask extends AsyncTask<URL, Integer, Integer> {
	static final String rss_source = "http://www.udmercy.edu/atp/atp.rss";
	List<RSSItem> items = null;
	ListView listview = null;

	@Override
	protected Integer doInBackground(URL... url) {
		try {
			/* Create a URL we want to load some xml-data from. */
			//URL url = new URL("http://www.udmercy.edu/atp/atp.rss");

			/* Get a SAXParser from the SAXPArserFactory. */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			/* Get the XMLReader of the SAXParser we created. */
			XMLReader xr = sp.getXMLReader();
			/* Create a new ContentHandler and apply it to the XML-Reader*/ 
			RSSParserHandler myExampleHandler = new RSSParserHandler();
			xr.setContentHandler(myExampleHandler);
			
			/* Parse the xml-data from our URL. */
			xr.parse(new InputSource(url[0].openStream()));
			/* Parsing has finished. */

			/* Our ExampleHandler now provides the parsed data to us. */
			items =	myExampleHandler.getMessages();
			return items.size();
		} catch (Exception e) {
			/* Display any Error to the GUI. */
			Log.e("Parsing", "WeatherQueryError", e);
		}
		return 0;
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		ArrayAdapter<RSSItem> adapter = new EpisodeArrayAdapter(listview.getContext(),android.R.layout.simple_list_item_1,items);
		listview.setAdapter(adapter);
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}
	
	public void setListView(ListView listview)
	{
		this.listview = listview;
	}

}
