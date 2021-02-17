package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Converter {

    public MutableLiveData<Float> input;
    public MutableLiveData<Float> output;

    public Converter(Float input, Float output) {
        this.input = new MutableLiveData<>();
        this.input.setValue(input);
        this.output = new MutableLiveData<>();
        this.output.setValue(output);
    }

    public static float toMeters(float input) { return (float) (input * 3.281); }

    public static float toKilograms(float input) {
        return (float) (input * 0.45359237);
    }

    public static float toOranges(float input) { return input + 3; }

    public static float toMilliliters(float input) {return (float) (input * 29.574); }

}

