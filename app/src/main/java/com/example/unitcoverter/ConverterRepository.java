package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ConverterRepository {
    private List<String> conversionTypes = List.of(
            "Apples to Oranges", "Feet to Meters", "Pounds to Kilograms", "Ounces to Milliliters");

    private MutableLiveData<String> currentConversionType;
    private MutableLiveData<Float> input;
    private MutableLiveData<Float> output;

/*    public ConverterRepository(String currentConversionType, Float input, Float output) {
        this.currentConversionType = new MutableLiveData<>();
        this.currentConversionType.setValue(currentConversionType);
        this.input = new MutableLiveData<>();
        this.input.setValue(input);
        this.output = new MutableLiveData<>();
        this.output.setValue(output);
    }*/

    public static float toMeters(float input) { return (float) (input * 3.281); }

    public static float toKilograms(float input) {
        return (float) (input * 0.45359237);
    }

    public static float toOranges(float input) { return input + 3; }

    public static float toMilliliters(float input) {return (float) (input * 29.574); }



    public LiveData<String> getCurrentConversionType() {
        if (currentConversionType == null) {
            // Default conversion type is "apples to oranges"
            currentConversionType = new MutableLiveData<>();
            currentConversionType.setValue(conversionTypes.get(0));
        }
        return currentConversionType;
    }

    public String getConversionType(int userChoice) {
        return conversionTypes.get(userChoice);
    }

    public void changeConversionType(int userChoice) {
        this.currentConversionType.setValue(getConversionType(userChoice));
    }

    public float calculateConversionValues(float in) {
        this.input.setValue(in);
        return toOranges(input.getValue());
    };
}
