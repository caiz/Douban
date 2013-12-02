package com.itcast.douban;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MeActivity extends Activity {
	private ListView melistview;
	private static String[] arr = {"我读...","我听...","我看...","我评...","我的日记","我的资料","小组"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meactivity);
		
		melistview = (ListView) findViewById(R.id.melistview);
		melistview.setAdapter(new ArrayAdapter<String>(this, R.layout.me_item, R.id.fav_title, arr));
	}

}
