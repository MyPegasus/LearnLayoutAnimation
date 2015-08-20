package com.example.mypegasus.learnlayoutanimation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class InLinearLayoutActivityFragment extends Fragment {

	public InLinearLayoutActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_in_linear, container, false);

		ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
		sa.setDuration(3000);

		LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5f);
//		lac.setOrder(LayoutAnimationController.ORDER_REVERSE);
		lac.setOrder(LayoutAnimationController.ORDER_RANDOM);

		rootView.setLayoutAnimation(lac);

		return rootView;
	}
}
