package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.R)
public class SpinnerRepository {
    private List<String> conversionTypes = List.of(
            "Apples to Oranges", "Feet to Meters", "Pounds to Kilograms", "Ounces to Milliliters");

    private MutableLiveData<String> currentConversionType;

    public LiveData<String> getCurrentConversionType() {
        if (currentConversionType == null) {
            // Default conversion type is apples to oranges
            currentConversionType = new MutableLiveData<>();
            currentConversionType.setValue(conversionTypes.get(0));
        }
        return currentConversionType;
    }

    public String getRandomFruitName() {
        Random rand = new Random();
        return conversionTypes.get(rand.nextInt(conversionTypes.size()));
    }

    public void changeCurrentRandomFruitName() {
        this.currentConversionType.setValue(getRandomFruitName());
    }
}
