package com.forsxj.badgekiller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

import badge_lib.BadgeUtil;

public class MainActivity extends AppCompatActivity
{
	private Button m_clear;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		m_clear = (Button) findViewById(R.id.clear);
		m_clear.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{

			}
		});
	}

	//清除所有应用的未读消息角标
	public static void clearBadge(Context context)
	{
		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(
				intent, 0);
		for (int i = 0; i < list.size(); i++)
		{
			ActivityInfo activityInfo = list.get(i).activityInfo;
			String activityName = activityInfo.name;
			String packageName = activityInfo.applicationInfo.packageName;
			BadgeUtil.setBadgeOfMadMode(context.getApplicationContext(), 0, packageName, activityName);
		}
	}
}
