package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {
    @Test
    public void apples_conversion_isCorrect() {
        assertEquals(103.00, Converter.toOranges(100),0.01);
    }

    @Test
    public void pounds_conversion_isCorrect() {
        assertEquals(45.36, Converter.toKilograms(100),0.01);
    }

    @Test
    public void ounces_conversion_isCorrect() {
        assertEquals(2957.40, Converter.toMilliliters(100),0.01);
    }

    @Test
    public void feet_conversion_isCorrect() {
        assertEquals(328.10, Converter.toFeet(100),0.01);
    }
}