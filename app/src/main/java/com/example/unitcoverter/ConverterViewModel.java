package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ConverterViewModel extends ViewModel {
    private ConverterRepository repo = new ConverterRepository();

    public MutableLiveData<String> conversionOutput = new MutableLiveData<>();

    public LiveData<String> getConversionOutput() {
        return repo.getConversionOutput();
    }

    public void updateConversionOutput(String in) {
        conversionOutput.setValue(repo.updateConversionOutput(in));
    }

    public MutableLiveData<String> conversion = new MutableLiveData<>();

    public LiveData<String> getCurrentConversion() {
        return repo.getCurrentConversion();
    }

    public void updateCurrentConversion(int pos) {
        conversion.setValue(repo.updateCurrentConversion(pos));
    }
}
