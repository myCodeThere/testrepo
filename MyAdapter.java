package net.niceandroid.jsonparsing;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private int[] mTo;
	private String[] mFrom;
	private List<? extends Map<String, ?>> mData;

	private int mResource;
	private int mDropDownResource;
	private LayoutInflater mInflater;
	Context mContext;

	public MyAdapter(Context context, List<? extends Map<String, ?>> data,
			int resource, String[] from, int[] to) {
		mData = data;
		mResource = mDropDownResource = resource;
		mFrom = from;
		mTo = to;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		mContext = context;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ViewHolder содержит ссылки на виджеты для избежания ненужных вызовов
		// метода findViewById()
		// в каждом новом видимом элементе списка
		ViewHolder holder = null;
		// Получение объекта inflater из контекста
		mInflater = LayoutInflater.from(mContext);

		// Если convertView не null, мы используем его напрямую, нет
		// необходимости повторно
		// вызывать inflate
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, parent, false);

			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.email);
			holder.surname = (TextView) convertView.findViewById(R.id.name);
			holder.title = (TextView) convertView.findViewById(R.id.mobile);
			holder.post_date = (TextView) convertView
					.findViewById(R.id.post_date);
			holder.age = (TextView) convertView.findViewById(R.id.textView1);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		AndroidJSONParsingActivity a = null;

		holder.name.setText("aaaaaaaaaaaaaa");
		holder.surname.setText(a.avatar2);
		holder.title.setText(a.avatar2);
		holder.post_date.setText(a.avatar2);
		holder.age.setText(a.avatar2);

		return convertView;
	}

	static class ViewHolder {
		TextView name;
		TextView surname;
		TextView title;
		TextView post_date;
		TextView age;
	}

}
