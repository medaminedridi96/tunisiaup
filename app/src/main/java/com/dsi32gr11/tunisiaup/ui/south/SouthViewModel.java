package com.dsi32gr11.tunisiaup.ui.south;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SouthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SouthViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}