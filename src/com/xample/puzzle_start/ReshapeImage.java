package com.xample.puzzle_start;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ReshapeImage {
	public ReshapeImage()
	{
	 
	}
	
	public  Bitmap getResizedBitmap(Object bm, int newHeight,int newWidth) {
		int width = ((Bitmap) bm).getWidth();
		int height = ((Bitmap) bm).getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// CREATE A MATRIX FOR THE MANIPULATION
		Matrix matrix = new Matrix();
		// RESIZE THE BIT MAP
		matrix.postScale(scaleWidth, scaleHeight);
		// RECREATE THE NEW BITMAP
		Bitmap resizedBitmap = Bitmap.createBitmap((Bitmap) bm, 0, 0, width, height,
				matrix, false);
		return resizedBitmap;}

}
