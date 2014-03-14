package net.niceandroid.jsonparsing;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

	Context cont;
	LayoutInflater lInflater;
	ArrayList<User> objects;

	Adapter(Context context, ArrayList<User> mylist) {
		cont = context;
		objects = mylist;
		lInflater = (LayoutInflater) cont
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return objects.size();
	}

	public Object getItem(int position) {
		return objects.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// используем созданные, но не используемые view
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.list_item, parent, false);
		}

		User user = ((User) getItem(position));

		((TextView) view.findViewById(R.id.email)).setText(user.name);
		((TextView) view.findViewById(R.id.name)).setText(user.surname);
		((TextView) view.findViewById(R.id.mobile)).setText(user.title);
		((TextView) view.findViewById(R.id.post_date)).setText((user.post_date));
		((TextView) view.findViewById(R.id.textView1)).setText(user.age);

		return view;
	}

}
