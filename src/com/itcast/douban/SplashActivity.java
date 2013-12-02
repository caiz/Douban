package com.itcast.douban;
import com.itcast.douban.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.BulletSpan;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {
	private TextView versionNumber;
	private LinearLayout mlinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash);
		mlinearLayout = (LinearLayout) this.findViewById(R.id.LinearLayout01);
		versionNumber = (TextView) this.findViewById(R.id.versionNumber);
		versionNumber.setText(this.getVersion());
		
		// 判断当前网络是否可用
		if(isNetWorkConnected()){
			// splash 做一个动画，进入主界面
			AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
			aa.setDuration(2000);
			mlinearLayout.setAnimation(aa);
			mlinearLayout.startAnimation(aa);
			// 通过handler，延迟2秒执行r任务
			new Handler().postDelayed(new LoadMainTabTask(), 2000);
		}else{
			showSetNetWorkDialog();
		}
	}

	private class LoadMainTabTask implements Runnable{

		@Override
		public void run() {
			Intent intent = new Intent(SplashActivity.this, MainTabActivity.class);
			startActivity(intent);
			finish();
		}
		
	}
	
	private void showSetNetWorkDialog() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("设置网络");
		builder.setMessage("网络错误请检查网络状态");
		builder.setPositiveButton("设置网络", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent();
				intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
				startActivity(intent);
				finish();
			}
		});
		builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		builder.create().show();
	}

	private String getVersion() {
		String version = "Version ";
		try {
			PackageInfo packInfo = getPackageManager().getPackageInfo(
					getPackageName(), 0);
			version = version + packInfo.versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return version;
	}

	/**
	 * 判断网络状态
	 * @return
	 */
	private boolean isNetWorkConnected(){
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		return (info != null && info.isConnected());
	}
}
