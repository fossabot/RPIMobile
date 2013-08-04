package rpi.edu.rpimobile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import rpi.edu.rpimobile.model.RSSObject;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class RSSListAdapter extends BaseAdapter {
 
    // Declare Variables
    Context context;
	ArrayList<RSSObject> items;
    LayoutInflater inflater;
 
    public RSSListAdapter(Context context, ArrayList<RSSObject> items_) {
        this.context = context;
        this.items = items_;

    }
 
    @Override
    public int getCount() {
        return items.size();
    }
 
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txttitle;
        TextView txtheading;
        
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.rss_list_item, parent,
                false);
        
        itemView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(items.get(position).link));
				context.startActivity(browserIntent);
				
			}
		});
        
        
        // Locate the TextViews in drawer_list_item.xml
        txttitle = (TextView) itemView.findViewById(R.id.rsstitle);
        txtheading = (TextView) itemView.findViewById(R.id.rssheading);
        
        // Set the results into TextViews
        txttitle.setText(items.get(position).title);

        SimpleDateFormat dtime = new SimpleDateFormat("h:mm a, MMM d");
        txtheading.setText(items.get(position).category+" | "+dtime.format(items.get(position).time));
        
        // Set the results into ImageView
        
 
        return itemView;
    }
 
}