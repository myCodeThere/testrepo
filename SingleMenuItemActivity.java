package net.niceandroid.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.androidquery.AQuery;

public class SingleMenuItemActivity extends Activity {

	private static final String TAG_SURNAME = "surname";
	private static final String TAG_NAME = "name";
	private static final String TAG_TITLE = "title";
	private static final String TAG_AVATAR = "avatar";
	private static final String TAG_AGE= "age";
	private static final String TAG_TEXT = "text";
	private static final String TAG_POST_DATE = "post_date";
	
	private AQuery aq;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_list_item);
		
		// создаем объект AQuery
		aq = new AQuery(this);

		Intent in = getIntent();

		String surname2 = in.getStringExtra(TAG_SURNAME);
		String name2 = in.getStringExtra(TAG_NAME);
		String title2 = in.getStringExtra(TAG_TITLE);
		String avatar2 = in.getStringExtra(TAG_AVATAR);
		String age2 = in.getStringExtra(TAG_AGE);
		String text2 = in.getStringExtra(TAG_TEXT);
		String post_date2 = in.getStringExtra(TAG_POST_DATE);

		TextView lblSurname = (TextView) findViewById(R.id.surname);
		TextView lblName = (TextView) findViewById(R.id.name);
		TextView lblTitle = (TextView) findViewById(R.id.title);
		TextView lblAge = (TextView) findViewById(R.id.age);
		TextView lblText = (TextView) findViewById(R.id.text);
		TextView lblPost_date = (TextView) findViewById(R.id.post_date);

		lblSurname.setText(surname2);
		lblName.setText(name2);
		lblTitle.setText(title2);
		lblAge.setText(age2);
		lblPost_date.setText(post_date2);
		lblText.setText(text2);
		
		// загружаем картинку в ImageView из сети
		aq.id(R.id.imageView1).image(avatar2);

	}
}
