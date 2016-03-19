package com.zhx.testanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private ImageView img1, img2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		img1 = (ImageView) findViewById(R.id.img1);
		img2 = (ImageView) findViewById(R.id.img2);
		new animModel(img1).start(1);
		new animModel(img2).start(2);
	}

	public class animModel {
		private Animation oneAction, twoAction;
		private ImageView imageView;

		public animModel(ImageView img) {
			super();
			// TODO Auto-generated constructor stub
			this.imageView = img;
			oneAction = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.anim_big_one);
			oneAction.setFillAfter(true);
			twoAction = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.anim_big_two);
			twoAction.setFillAfter(true);
			oneAction.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
							(int) (imageView.getWidth() * 1.2),
							(int) (imageView.getHeight() * 1.2));
					lp.addRule(RelativeLayout.CENTER_IN_PARENT);
					imageView.setLayoutParams(lp);
					imageView.startAnimation(twoAction);
				}
			});
			twoAction.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
							(int) (imageView.getWidth() / 1.2),
							(int) (imageView.getHeight() / 1.2));
					lp.addRule(RelativeLayout.CENTER_IN_PARENT);
					imageView.setLayoutParams(lp);
					imageView.startAnimation(oneAction);
				}
			});
		}

		public void start(int index) {
			switch (index) {
			case 1:
				imageView.startAnimation(oneAction);
				break;
			case 2:
				imageView.startAnimation(twoAction);
				break;

			default:
				imageView.startAnimation(oneAction);
				break;
			}

		}

	}
}
