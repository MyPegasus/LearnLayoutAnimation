package com.example.mypegasus.learnlayoutanimation;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
		transition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.scale_object_animator));
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
