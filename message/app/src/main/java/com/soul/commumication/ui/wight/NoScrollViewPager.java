package com.soul.commumication.ui.wight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class NoScrollViewPager extends LazyViewPager {

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public NoScrollViewPager(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		//不拦截子控件的触摸事件
		return false;
//		return super.onInterceptTouchEvent(ev);
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		//不去消费touch
		
		return false;
	}
	
	
	
}
