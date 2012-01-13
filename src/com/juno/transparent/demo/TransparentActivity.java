package com.juno.transparent.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class TransparentActivity extends Activity implements OnClickListener {

	private int mDeviceScreenWidth;
	private int mDeviceScreenHeight;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transparent_activity);
		
		Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		mDeviceScreenWidth = display.getWidth();
		mDeviceScreenHeight = display.getHeight();
		
		ImageButton btnAuth = (ImageButton) findViewById(R.id.imgbtn_do_sth);
		btnAuth.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.imgbtn_do_sth:
			Toast.makeText(this, "Button Clicked!!!!", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
        	
			int x = (int)event.getX();
			int y = (int)event.getY();
        	
        	Bitmap bitmapScreen = Bitmap.createBitmap(mDeviceScreenWidth, mDeviceScreenHeight, Bitmap.Config.ARGB_8888);
        	
        	if(x < 0 || y < 0)
        		return false;
        	
        	int ARGB = bitmapScreen.getPixel(x, y);

        	if(Color.alpha(ARGB) == 0) {
        		finish();
        	}

            return true;
        }
        return false;
	}
}
