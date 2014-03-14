package net.niceandroid.jsonparsing;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AndroidJSONParsingActivity extends ListActivity {

	private static String url = "http://www.json-generator.com/j/eZmU?indent=4";

	private static final String TAG_RESULT = "result";
	private static final String TAG_LIKED_BY_ME = "liked_by_me";
	private static final String TAG_SURNAME = "surname";
	private static final String TAG_NAME = "name";
	private static final String TAG_TITLE = "title";
	private static final String TAG_GENDER = "gender";
	private static final String TAG_AGE = "age";
	private static final String TAG_POST_DATE = "post_date";
	private static final String TAG_AVATAR = "avatar";
	private static final String TAG_TEXT = "text";
	private static final String TAG_AVATAR_THUMB = "avatar_thumb";
	private static final String TAG_QUID = "guid";
	private static final String TAG_ID = "id";
	private static final String TAG_LIKES = "likes";

	JSONArray result = null;
	
	String avatar2;
	String age2;
	String text2;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

		ArrayList<User> contactList = new ArrayList<User>();

		JSONParser jParser = new JSONParser();

		JSONObject json = jParser.getJSONFromUrl(url);

		try {

			result = json.getJSONArray(TAG_RESULT);

			for (int i = 0; i < result.length(); i++) {
				JSONObject c = result.getJSONObject(i);

				String liked_by_me = c.getString(TAG_LIKED_BY_ME);
				String surname = c.getString(TAG_SURNAME);
				String name = c.getString(TAG_NAME);
				String title = c.getString(TAG_TITLE);
				String gender = c.getString(TAG_GENDER);
				String avatar = c.getString(TAG_AVATAR);
				Long post_date = c.getLong(TAG_POST_DATE);
				String age = c.getString(TAG_AGE);
				String text = c.getString(TAG_TEXT);
				
				avatar2 = avatar;
				text2 = text;
				
				Date date = new Date(post_date);
				String post_date1 = date.toString();
		
				
				contactList.add(new User(surname, name, title, post_date1, age));

				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ListAdapter adapter = new Adapter(this, contactList);

		setListAdapter(adapter);

		ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				String surname2 = ((TextView) view.findViewById(R.id.name))
						.getText().toString();
				String name2 = ((TextView) view.findViewById(R.id.email))
						.getText().toString();
				String title2 = ((TextView) view.findViewById(R.id.mobile))
						.getText().toString();
				String post_date2 = ((TextView) view.findViewById(R.id.post_date))
						.getText().toString();
				String age2 = ((TextView) view.findViewById(R.id.textView1))
						.getText().toString();

				Intent in = new Intent(getApplicationContext(),
						SingleMenuItemActivity.class);
				in.putExtra(TAG_SURNAME, surname2);
				in.putExtra(TAG_NAME, name2);
				in.putExtra(TAG_TITLE, title2);
				in.putExtra(TAG_AVATAR, avatar2);
				in.putExtra(TAG_AGE, age2);
				in.putExtra(TAG_TEXT, text2);
				in.putExtra(TAG_POST_DATE, post_date2);
				startActivity(in);

			}
		});

	}

}