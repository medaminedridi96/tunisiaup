package com.dsi32gr11.tunisiaup.ui.definition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DefinitonViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DefinitonViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}