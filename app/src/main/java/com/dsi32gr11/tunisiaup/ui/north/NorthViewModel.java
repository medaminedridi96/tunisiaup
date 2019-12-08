package com.dsi32gr11.tunisiaup.ui.north;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NorthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NorthViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}