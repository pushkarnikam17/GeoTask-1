package com.scs.geotask.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scs.geotask.R;
import com.scs.geotask.library.NavDrawerItem;

public class NavDrawerListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItem;

	public NavDrawerListAdapter(Context context,
			ArrayList<NavDrawerItem> navDrawerItem) {
		this.context = context;
		this.navDrawerItem = navDrawerItem;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return navDrawerItem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return navDrawerItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.drawer_list_item, null);

		}
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		TextView txtcount = (TextView) convertView.findViewById(R.id.counter);

		imgIcon.setImageResource(navDrawerItem.get(position).getIcon());
		txtTitle.setText(navDrawerItem.get(position).getTitle());

		if (navDrawerItem.get(position).getCounterVisibility()) {
			txtcount.setText(navDrawerItem.get(position).getCount());
		} else {
			txtcount.setVisibility(View.GONE);

		}

		return convertView;
	}
}
