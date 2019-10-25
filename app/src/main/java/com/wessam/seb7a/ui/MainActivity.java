package com.wessam.seb7a.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.wessam.seb7a.model.Data;
import com.wessam.seb7a.R;
import com.wessam.seb7a.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutDirection();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mData = new Data(this);

        mBinding.setController(this);
        mBinding.setData(mData);

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
            startActivity(new Intent(this, NightModeActivity.class));
        }
    }

    public void showNightModeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.open_night_mood)
                .setMessage(R.string.night_mood_msg)
                .setPositiveButton(R.string.oK, (dialog, id) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
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