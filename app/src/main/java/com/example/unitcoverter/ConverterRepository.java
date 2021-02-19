package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ConverterRepository {
    private List<String> conversion_options = List.of(
            "Apples to Oranges", "Meters to Feet", "Fluid Ounces to Milliliters", "Pounds to Kilograms"
    );

    private MutableLiveData<String> currentConversion;

    public LiveData<String> getCurrentConversion(){
        if(currentConversion == null){
            currentConversion = new MutableLiveData<>();
            currentConversion.setValue(conversion_options.get(0));
        }
        return currentConversion;
    }

    public String updateCurrentConversion(int pos){
        this.currentConversion.setValue(conversion_options.get(pos));
        return this.currentConversion.getValue();
    }
}
