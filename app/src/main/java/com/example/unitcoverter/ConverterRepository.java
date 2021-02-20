package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ConverterRepository {
    private final String defaultOutput = "";

    private MutableLiveData<String> conversionOutput;

    public LiveData<String> getConversionOutput() {
        if (conversionOutput == null){
            conversionOutput = new MutableLiveData<>();
            conversionOutput.setValue(defaultOutput);
        }
        return conversionOutput;
    }

    public String updateConversionOutput(String in){
        this.conversionOutput.setValue(in);
        return this.conversionOutput.getValue();
    }

    private final List<String> conversion_options = List.of(
            "Apples to Oranges", "Meters to Feet", "Fluid Ounces to Milliliters", "Pounds to Kilograms"
    );

    private MutableLiveData<String> currentConversion;

    public LiveData<String> getCurrentConversion() {
        if (currentConversion == null) {
            currentConversion = new MutableLiveData<>();
            currentConversion.setValue(conversion_options.get(0));
        }
        return currentConversion;
    }

    public String updateCurrentConversion(int pos) {
        this.currentConversion.setValue(conversion_options.get(pos));
        return this.currentConversion.getValue();
    }
}
