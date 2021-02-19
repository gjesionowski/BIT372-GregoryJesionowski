package com.example.unitcoverter;

public class Converter {
    public static float toMeters(float input) { return (float) (input * 3.281); }

    public static float toKilograms(float input) {
        return (float) (input * 0.45359237);
    }

    public static float toOranges(float input) { return input + 3; }

    public static float toMilliliters(float input) {return (float) (input * 29.574); }

}
