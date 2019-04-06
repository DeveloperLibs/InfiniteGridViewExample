package com.devlibs.infinittegridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;



class CustomImageLoader {
    /*
     *
     * */

//    private ImageLoader mImageLoader;
//    private DisplayImageOptions mOptions;
//
//    CustomImageLoader(Context context) {
//        mImageLoader = ImageLoader.getInstance();
//        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
//        mImageLoader.init(configuration);
//        mOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
//                .resetViewBeforeLoading(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565)
//                .displayer(new SimpleBitmapDisplayer()).build();
//    }
//
//    void getImage(String thumbNail, final Cell video) {
//        mImageLoader.loadImage(thumbNail, mOptions,
//                new ImageLoadingListener() {
//                    @Override
//                    public void onLoadingStarted(String imageUri, View view) {
//
//                    }
//
//                    @Override
//                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                    }
//
//                    @Override
//                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                        video.setVideoThumnail(loadedImage);
//                    }
//
//                    @Override
//                    public void onLoadingCancelled(String imageUri, View view) {
//
//                    }
//                });
//    }
}
