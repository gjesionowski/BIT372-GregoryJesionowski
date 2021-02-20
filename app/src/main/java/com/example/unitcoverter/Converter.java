package com.example.unitcoverter;

import android.annotation.SuppressLint;

public class Converter {
    public static float toFeet(float input) {
        return (float) (input * 3.281);
    }

    public static float toKilograms(float input) {
        return (float) (input * 0.45359237);
    }

    public static float toOranges(float input) {
        return input + 3;
    }

    public static float toMilliliters(float input) {
        return (float) (input * 29.574);
    }

    @SuppressLint("DefaultLocale")
    public String convertValues(int pos, float input) {
        switch (pos) {
            case 0:
                double output = Converter.toOranges(input);
                return String.format("%.2f Oranges", output);
            case 1:
                output = Converter.toFeet(input);
                return String.format("%.2f Feet", output);
            case 2:
                output = Converter.toMilliliters(input);
                return String.format("%.2f ml", output);
            case 3:
                output = Converter.toKilograms(input);
                return String.format("%.2f Kg", output);
            default:
                throw new IllegalStateException("Unexpected value: " + pos);
        }
    }
}
