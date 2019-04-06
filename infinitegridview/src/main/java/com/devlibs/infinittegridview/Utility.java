package com.devlibs.infinittegridview;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class Utility {

	public static Bitmap getBitmap(Activity mActivity,Uri uri)
	{
		Bitmap bitmap,newBitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream(mActivity.getContentResolver().openInputStream(uri));
			if (bitmap != null) {
				newBitmap = Bitmap.createScaledBitmap(bitmap, 213, 160,true);
				bitmap.recycle();
				return newBitmap;
			}
		} catch (IOException e) {
		}
		return newBitmap;
	}


	public static float getRatioX(float value) {
		//for calculate font size in %
		return ( (value * 100) / 320) / 100;
	}



	 static float getActualDimensionsX(float ratio,float screenWidth) {
		//for calculate font size according to screen width
		return ratio * screenWidth;
	}
}
