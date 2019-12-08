package com.dsi32gr11.tunisiaup.ui.cap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class capViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public capViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}