package com.devlibs.infinittegridview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class Cell implements VideoManager {



    private Bitmap mVideoThumbnail;
    private RectF mVideoRect;
    private Line mX;
    private Line mY;
    private final int PADDING_10 = 2;
    private final int PADDING_5 = 5;
    boolean isImageLoaded;
    private float mVideoWidthHalf;
    private float mVideoHeightHalf;
    private RectF mVideoTitleRect;



    private LoadedImage mImage;

    public interface VideoClickListener {
        /*
         *
         * */
        void onVideoClick(Cell video);
    }

     Cell(Line x, Line y, float imgWidth, float imgHeight, Bitmap img) {
        mVideoThumbnail = scaleBitmapAndKeepRation(img, imgWidth, imgHeight);
        mX = x;
        mY = y;
        mVideoHeightHalf = imgHeight / 2;
        mVideoWidthHalf = imgWidth / 2;
        mVideoRect = new RectF(mX.getLineX() - mVideoWidthHalf + PADDING_10, mY.getLineY() - mVideoHeightHalf + PADDING_10, mX.getLineX() + mVideoWidthHalf - PADDING_10, mY.getLineY() + mVideoHeightHalf - PADDING_10);
        mVideoTitleRect = new RectF(mVideoRect.left + (PADDING_10 * 2), mVideoRect.bottom - (mVideoHeightHalf / 3),
                mVideoRect.right - (PADDING_10 * 2), mVideoRect.bottom - (PADDING_5 * 2));
    }

    public void setmVideoThumbnail(Bitmap mVideoThumbnail) {
        this.mVideoThumbnail = mVideoThumbnail;
    }

    public void setmImage(LoadedImage mImage) {
        this.mImage = mImage;
    }

     Bitmap scaleBitmapAndKeepRation(Bitmap targetBmp, float reqHeightInPixels, float reqWidthInPixels) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0, 0, targetBmp.getWidth(), targetBmp.getHeight()), new RectF(0, 0, reqWidthInPixels, reqHeightInPixels), Matrix.ScaleToFit.CENTER);
        Bitmap scaledBitmap = Bitmap.createBitmap(targetBmp, 0, 0, targetBmp.getWidth(), targetBmp.getHeight(), matrix, true);
        return scaledBitmap;
    }


    public LoadedImage getCellData() {
        return mImage;
    }

    @Override
    public void render(Canvas canvas, Paint paint, Paint labelBg) {
        if (mVideoThumbnail != null) {
            canvas.drawBitmap(mVideoThumbnail, null, mVideoRect, paint);
        }

        if (mImage != null && mImage.getLabel() != null) {
            canvas.drawRect(mVideoTitleRect, labelBg);
            canvas.drawText(mImage.getLabel(), mVideoTitleRect.left + 10, mVideoTitleRect.centerY() + (getTextHeight(mImage.getLabel(), paint) / 2), paint);
        }

    }


    private int getTextHeight(String text, Paint paint) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int height = bounds.bottom - bounds.top;
        return height;
    }

    public RectF getImgRect() {
        return mVideoRect;
    }


    @Override
    public void reset(float x, float y) {
        mX.setLineX(x);
        mY.setLineY(y);
        move();
    }

     Line getmX() {
        return mX;
    }

    public void setmX(Line mX) {
        this.mX = mX;
    }

     Line getmY() {
        return mY;
    }

    public void setmY(Line mY) {
        this.mY = mY;
    }

     boolean isContain(float x, float y) {
        return mVideoRect.contains(x, y);
    }

    @Override
    public void move() {
        mVideoRect.set(mX.getLineX() - mVideoWidthHalf + PADDING_10, mY.getLineY() - mVideoHeightHalf + PADDING_10, mX.getLineX() + mVideoWidthHalf - PADDING_10, mY.getLineY() + mVideoHeightHalf - PADDING_10);
        mVideoTitleRect.set(mVideoRect.left + (PADDING_10 * 2), mVideoRect.bottom - (mVideoHeightHalf / 3),
                mVideoRect.right - (PADDING_10 * 2), mVideoRect.bottom - (PADDING_5 * 2));
    }

     void setVideo(Activity mActivity, LoadedImage image) {
        mImage = image;
        isImageLoaded = true;
        if (image != null) {
            if (image.getUri() != null) {
                mVideoThumbnail = Utility.getBitmap(mActivity, image.getUri());
                mVideoThumbnail = scaleBitmapAndKeepRation(mVideoThumbnail, mVideoWidthHalf * 2, mVideoHeightHalf * 2);
                isImageLoaded = true;
            } else if (image.getUrl() != null && image.getUrl().contains("http")) {

                Glide.with(mActivity)
                        .asBitmap().load(image.getUrl())
                        .listener(new RequestListener<Bitmap>() {
                                      @Override
                                      public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                                          return false;
                                      }

                                      @Override
                                      public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                                          mVideoThumbnail = resource;
                                          return false;
                                      }
                                  }
                        ).submit();
            }
        }
    }
}
