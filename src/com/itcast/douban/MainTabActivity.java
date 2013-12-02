package com.itcast.douban;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainTabActivity extends TabActivity {
	private TabHost mTabHost;
	private LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab);
		inflater = LayoutInflater.from(this);
		mTabHost = getTabHost();
		mTabHost.addTab(this.getMyDouban());
		mTabHost.addTab(this.getNewBook());
		mTabHost.setCurrentTabByTag("myDouban");
	}

	private TabSpec getMyDouban() {
		TabSpec tabSpec = mTabHost.newTabSpec("myDouban");
		// 指定标签的内容，激活的activity对应的intent对象
		Intent intent = new Intent(this, MeActivity.class);
		tabSpec.setContent(intent);
		// 设置标签的文字和样式
		tabSpec.setIndicator(getIndicatorView("我的豆瓣",R.drawable.tab_main_nav_me));
		return tabSpec;
	}

	private TabSpec getNewBook() {
		TabSpec tabSpec = mTabHost.newTabSpec("newBook");
		// 指定标签的内容，激活的activity对应的intent对象
		Intent intent = new Intent(this, TestActivity1.class);
		tabSpec.setContent(intent);
		// 设置标签的文字和样式
		tabSpec.setIndicator(getIndicatorView("豆瓣新书",R.drawable.tab_main_nav_book));
//		Drawable icon = getResources().getDrawable(R.drawable.ic_launcher);
//		tabSpec.setIndicator("我的豆瓣1", icon);
		return tabSpec;
	}

	/**
	 * 获取条目显示的view对象
	 */
	private View getIndicatorView(String name, int iconid) {
		View view = inflater.inflate(R.layout.tab_main_nav, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
		TextView textView = (TextView) view.findViewById(R.id.tvTitle);
		imageView.setImageResource(iconid);
		textView.setText(name);
		return view;
	}
}
