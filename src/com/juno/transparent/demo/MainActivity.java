package com.juno.transparent.demo;


import com.juno.transparent.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("TestAppActivity", "onCreate");
		setContentView(R.layout.main);

		Button btnNewAct = (Button) findViewById(R.id.btn_new_activity);
		btnNewAct.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btn_new_activity:
			Intent intent = new Intent(getBaseContext(), TransparentActivity.class);	
			startActivity(intent);
		default:
			break;
		}
	}
}
