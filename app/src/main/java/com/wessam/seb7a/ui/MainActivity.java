package com.wessam.seb7a.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;

import com.wessam.seb7a.databinding.DialogNightModeBinding;
import com.wessam.seb7a.model.Data;
import com.wessam.seb7a.R;
import com.wessam.seb7a.databinding.ActivityMainBinding;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Data mData;
    private Dialog nightModeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutDirection();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mData = new Data(this);

        mBinding.setController(this);
        mBinding.setData(mData);

        setupWindowAnimations();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBinding.textView2.setText(String.valueOf(mData.getCount()));
        mBinding.textView4.setText(String.valueOf(mData.getTotalCount()));
    }

    private void layoutDirection() {
        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("ar"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    public void onNightModeButtonClicked() {
        if (mData.getFirstLogin()) {
            showNightModeDialog();
            mData.setFirstLogin(false);
        } else {
            startNightModeActivityWithTransition();
        }
    }

    public void startNightModeActivityWithTransition() {
        if (nightModeDialog != null) {
            nightModeDialog.dismiss();
        }
        Intent intent = new Intent(this, NightModeActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, mBinding.textView2,
                        Objects.requireNonNull(ViewCompat.getTransitionName(mBinding.textView2)));
        startActivity(intent, options.toBundle());
    }

    private void setupWindowAnimations() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slideTransition = new Slide();
            slideTransition.setSlideEdge(Gravity.START);
            slideTransition.setDuration(600);

            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    public void showNightModeDialog() {
        DialogNightModeBinding mDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.dialog_night_mode, null, false);
        mDialogBinding.setController(this);

        nightModeDialog = new Dialog(this);
        nightModeDialog.setContentView(mDialogBinding.getRoot());
        Objects.requireNonNull(nightModeDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        nightModeDialog.setCancelable(false);
        nightModeDialog.show();
    }

    public void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.delet_title)
                .setIcon(R.drawable.ic_warning)
                .setMessage(R.string.delete_msg)
                .setPositiveButton(R.string.confirm, (dialog, id) -> clearTotalCount())
                .setNegativeButton(R.string.cancel, (dialog, id) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void increaseCount() {
        int x = mData.getCount();
        x++;
        mData.setCount(x);

        int y = mData.getTotalCount();
        y++;
        mData.setTotalCount(y);
    }

    public void clearCount() {
        mData.setCount(0);
    }

    public void clearTotalCount() {
        mData.setCount(0);
        mData.setTotalCount(0);
    }

}