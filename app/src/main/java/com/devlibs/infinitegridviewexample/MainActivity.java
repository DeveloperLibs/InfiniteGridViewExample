package com.devlibs.infinitegridviewexample;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.devlibs.infinitegridviewexample.model.RandomUser;
import com.devlibs.infinitegridviewexample.model.Result;
import com.devlibs.infinitegridviewexample.network.ApiClient;
import com.devlibs.infinitegridviewexample.network.ApiInterface;
import com.devlibs.infinittegridview.Cell;
import com.devlibs.infinittegridview.GalleryView;
import com.devlibs.infinittegridview.LoadedImage;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements Cell.VideoClickListener, LocalImage.ImageNotifier, View.OnClickListener {

    private GalleryView galleryView;
    public static final int RUN_TIME_STORAGE_PERMISSION_REQUEST_CODE = 999;
    private boolean isRandomUserActive = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        galleryView = new GalleryView(this, false, this);
        findViewById(R.id.view_change_item).setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.view_grid)).addView(galleryView);
//        loadExternalImages();
        getRandomUsers();
    }

    private void getRandomUsers() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<RandomUser> call = apiService.getRandomUser("70", "gender,name,picture");
        call.enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                if (response.isSuccessful()) {
                    displayUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {
                Log.i("s", "s");
            }
        });
    }

    private void displayUser(RandomUser body) {
        for (Result user : body.getResults()) {
            LoadedImage loadedImage = new LoadedImage(user.getPicture().getLarge(), 0, user.getName().getFirst());
            loadedImage.setCustomData(user);
            galleryView.imageLoaded(loadedImage);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        if (requestCode == RUN_TIME_STORAGE_PERMISSION_REQUEST_CODE) {
            loadExternalImages();
        }
    }

    public void loadExternalImages() {
        if (checkRequiredAppPermission()) {
            new LocalImage(this, this);
        }
    }

    /**
     * Check run time permission and display a message for active it if not active.
     *
     * @return true if all permission active.
     */
    public boolean checkRequiredAppPermission() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, getString(com.devlibs.infinittegridview.R.string.storage_permission),
                    RUN_TIME_STORAGE_PERMISSION_REQUEST_CODE, perms);
            return false;
        } else {
            return true;
        }
    }

    protected void onResume() {
        super.onResume();
        galleryView.setRunThread(true);
    }

    protected void onPause() {
        super.onPause();
        galleryView.setRunThread(false);
    }

    @Override
    public void onVideoClick(Cell video) {
        if ((video.getCellData().getCustomData()) != null) {
            Toast.makeText(this,  ((Result) video.getCellData().getCustomData()).getName().getFirst(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void imageLoaded(LoadedImage video) {
        galleryView.imageLoaded(video);
    }

    @Override
    public void onClick(View view) {
        galleryView.resetCell();
        if (isRandomUserActive) {
            loadExternalImages();
        } else {
            getRandomUsers();
        }
        isRandomUserActive = !isRandomUserActive;
    }
}