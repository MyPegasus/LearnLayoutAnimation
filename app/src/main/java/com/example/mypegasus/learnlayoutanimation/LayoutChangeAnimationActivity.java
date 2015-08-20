package com.example.mypegasus.learnlayoutanimation;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutChangeAnimationActivity extends AppCompatActivity {

	private LinearLayout rootView;
	private View.OnClickListener btnOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			rootView.removeView(v);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_change_animation);
		rootView = (LinearLayout) findViewById(R.id.rootView);

		LayoutTransition transition = new LayoutTransition();
//		ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.scale_object_animator);
		/*ObjectAnimator oa = ObjectAnimator.ofFloat(this, "rotationX", 0f, 20f);
		oa.setRepeatCount(50);
		oa.setRepeatMode(ValueAnimator.REVERSE);*/

		ObjectAnimator oa = ObjectAnimator.ofInt(this,
				"backgroundColor", Color.RED, Color.BLUE, Color.GRAY,
				Color.GREEN);
		oa.setInterpolator(new DecelerateInterpolator());
		oa.setDuration(1500);
		oa.setRepeatCount(-1);
		oa.setRepeatMode(ValueAnimator.REVERSE);
		/*
		 * ArgbEvaluator：这种评估者可以用来执行类型之间的插值整数值代表ARGB颜色。
		 * FloatEvaluator：这种评估者可以用来执行浮点值之间的插值。
		 * IntEvaluator：这种评估者可以用来执行类型int值之间的插值。
		 * RectEvaluator：这种评估者可以用来执行类型之间的插值矩形值。
		 *
		 * 由于本例是改变View的backgroundColor属性的背景颜色所以此处使用ArgbEvaluator
		 */

		oa.setEvaluator(new ArgbEvaluator());


		transition.setAnimator(LayoutTransition.APPEARING, oa);
		rootView.setLayoutTransition(transition);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_layout_change_animation, menu);
		return true;
	}

	private void addButton() {
		Button btn = new Button(this);
		btn.setText("Remove me");
		rootView.addView(btn);


		btn.setOnClickListener(btnOnClickListener);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}*/

		switch (item.getItemId()) {
			case R.id.action_settings:
				return true;
			case R.id.action_add:
				addButton();
				break;
			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}
}
