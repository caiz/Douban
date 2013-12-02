package com.itcast.douban;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = new TextView(this);
		textView.setText("test2");
		setContentView(textView);
	}

}
