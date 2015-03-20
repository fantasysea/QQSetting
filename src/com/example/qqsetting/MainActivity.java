package com.example.qqsetting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener ,OnGestureListener {
	public int displayWith = 0;
	public int displayHeight = 0;
	ViewFlipper viewFlipper = null;
	float startX;
	float endX;
	Button fonstSize;
	Button searchEngine;
	LinearLayout second_ly;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	private void init() {
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display d = wm.getDefaultDisplay();
		this.displayWith = d.getWidth();
		this.displayHeight = d.getHeight();
		viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
		fonstSize = (Button) this.findViewById(R.id.fonstSize);
		searchEngine = (Button) this.findViewById(R.id.searchEngine);
		second_ly = (LinearLayout) this.findViewById(R.id.second_ly);
		fonstSize.setOnClickListener(this);
		searchEngine.setOnClickListener(this);
	}

	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startX = event.getX();
			break;
		case MotionEvent.ACTION_UP:
			endX = event.getX();
			if (event.getX() > startX) { // 向右滑动
				viewFlipper.setInAnimation(this, R.anim.in_leftright);
				viewFlipper.setOutAnimation(this, R.anim.out_leftright);
				viewFlipper.showNext();
			} else if (event.getX() < startX) { // 向左滑动
				viewFlipper.setInAnimation(this, R.anim.in_rightleft);
				viewFlipper.setOutAnimation(this, R.anim.out_rightleft);
				viewFlipper.showPrevious();
			}
			break;

		case MotionEvent.ACTION_MOVE:
			endX = event.getX();
			break;
		}

		return super.onTouchEvent(event);
	}

	@Override
	public void onClick(View v) {
		second_ly.removeAllViews();
		View view = null;
		LayoutParams layoutParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		switch (v.getId()) {
		case R.id.fonstSize:
			view = getLayoutInflater().inflate(R.layout.fontsize, null);
			break;
		case R.id.searchEngine:
			view = getLayoutInflater().inflate(R.layout.searchengine, null);
			break;

		default:
			break;
		}
		view.setLayoutParams(layoutParams);
		second_ly.addView(view);
		viewFlipper.setInAnimation(this, R.anim.in_rightleft);
		viewFlipper.setOutAnimation(this, R.anim.out_rightleft);
		viewFlipper.showPrevious();
		viewFlipper.getInAnimation().setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				Log.e("sea", "distanceX = ");
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		});

//		viewFlipper.getOutAnimation().setAnimationListener(listener);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		Log.e("sea", "distanceX = "+distanceX+"distanceY = "+distanceY);
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
