package com.itcast.douban;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MeActivity extends Activity {
	private ListView melistview;
	private static String[] arr = {"�Ҷ�...","����...","�ҿ�...","����...","�ҵ��ռ�","�ҵ�����","С��"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meactivity);
		
		melistview = (ListView) findViewById(R.id.melistview);
		melistview.setAdapter(new ArrayAdapter<String>(this, R.layout.me_item, R.id.fav_title, arr));
	}

}
