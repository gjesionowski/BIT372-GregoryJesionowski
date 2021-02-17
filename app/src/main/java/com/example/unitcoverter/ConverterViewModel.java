package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ConverterViewModel extends ViewModel {
    private ConverterRepository repo = new ConverterRepository();

    public MutableLiveData<Float> editTextContent = new MutableLiveData<>();

    private MutableLiveData<String> displayedEditTextContent = new MutableLiveData<>();

    public LiveData<String> getCurrentConversionType() {
        return repo.getCurrentConversionType();
    }

    public float onConvertInputClick(Float in) {
        float out = repo.calculateConversionValues(in);
        return out;
    }

    public void on() {
        repo.changeConversionType(1);
    }
}
