package com.example.unitcoverter;

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

    public String convertValues(int pos, float input) {
        switch (pos) {
            case 0:
                double output = Converter.toOranges(input);
                String str = String.format("%.2f Oranges", output);
                return str;
            case 1:
                output = Converter.toFeet(input);
                str = String.format("%.2f Feet", output);
                return str;
            case 2:
                output = Converter.toMilliliters(input);
                str = String.format("%.2f ml", output);
                return str;
            case 3:
                output = Converter.toKilograms(input);
                str = String.format("%.2f Kg", output);
                return str;
            default:
                throw new IllegalStateException("Unexpected value: " + pos);
        }
    }
}
