package com.wessam.seb7a.model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.wessam.seb7a.utils.Constants;

public class Data extends BaseObservable {

    private SharedPreferences mSharedPreferences;

    public Data(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setCount(int count) {
        mSharedPreferences.edit().putInt(Constants.COUNT, count).apply();
        notifyPropertyChanged(BR.count);
    }

    @Bindable
    public int getCount() {
        return mSharedPreferences.getInt(Constants.COUNT, 0);
    }

    public void setTotalCount(int totalCount) {
        mSharedPreferences.edit().putInt(Constants.TOTAL_COUNT, totalCount).apply();
        notifyPropertyChanged(BR.totalCount);
    }

    @Bindable
    public int getTotalCount() {
        return mSharedPreferences.getInt(Constants.TOTAL_COUNT, 0);
    }

    public void setFirstLogin(boolean firstLogin) {
        mSharedPreferences.edit().putBoolean(Constants.FIRST_LOGIN, firstLogin).apply();
    }

    public boolean getFirstLogin() {
        return mSharedPreferences.getBoolean(Constants.FIRST_LOGIN, true);
    }

}