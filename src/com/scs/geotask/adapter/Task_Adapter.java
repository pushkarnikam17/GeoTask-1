package com.scs.geotask.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.scs.geotask.R;

public class Task_Adapter extends ArrayAdapter<Task> {

	Activity activity;

	int layoutResourceId;

	Task user;

	LayoutInflater mInflater;

	ArrayList<Task> data = new ArrayList<Task>();

	public Task_Adapter(Activity act, int layoutResourceId, ArrayList<Task> data) {

		super(act, layoutResourceId, data);

		mInflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		this.layoutResourceId = layoutResourceId;

		this.activity = act;

		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ViewHolder holder;

		if (convertView == null) {

			mInflater = LayoutInflater.from(activity);
			convertView = mInflater.inflate(layoutResourceId, parent, false);

			holder = new ViewHolder();
			holder.text = (TextView) convertView.findViewById(R.id.list_text);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();

		}

		user = data.get(position);
		holder.text.setText(user.getName());

		return convertView;
	}

	static class ViewHolder {
		TextView text;
	}

	@Override
	public boolean isEnabled(int position) {

		return true;
	}

}
