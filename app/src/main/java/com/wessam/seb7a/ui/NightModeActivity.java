package com.wessam.seb7a.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.wessam.seb7a.R;
import com.wessam.seb7a.databinding.ActivityNightModeBinding;
import com.wessam.seb7a.model.Data;

public class NightModeActivity extends AppCompatActivity {

    private Data mData;
    private WindowManager.LayoutParams mParams;
    private int currentApiVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fullScreenView();

        ActivityNightModeBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_night_mode);

        mData = new Data(this);

        mBinding.setController(this);
        mBinding.setData(mData);

    }

    @Override
    protected void onResume() {
        super.onResume();
        changeScreenBrightness();
    }

    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        mParams = params;
        super.onWindowAttributesChanged(params);
    }

    //hide navigation bar and status bar
    @SuppressLint("NewApi")
    private void fullScreenView() {
        currentApiVersion = android.os.Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(flags);
                }
            });
        }
    }

    //make action when user click volume key
    @SuppressLint("NewApi")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    increaseCount();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    finishAfterTransition();
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    //reduce screen brightness
    private void changeScreenBrightness(){
        mParams.screenBrightness = 0.01f;
        getWindow().setAttributes(mParams);
    }

    public void increaseCount() {
        int x = mData.getCount();
        x++;
        mData.setCount(x);

        int y = mData.getTotalCount();
        y++;
        mData.setTotalCount(y);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }

}