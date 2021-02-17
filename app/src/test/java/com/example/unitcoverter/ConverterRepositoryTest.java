package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterRepositoryTest {
    @Test
    public void oranges_conversion_isCorrect() {
        assertEquals(35, ConverterRepository.toOranges(32),0.01);
    }
    @Test
    public void meters_conversion_isCorrect() {
        assertEquals(30.48, ConverterRepository.toMeters(100),0.01);
    }
    @Test
    public void milliliters_conversion_isCorrect() {
        assertEquals(2957.35, ConverterRepository.toMilliliters(100),0.01);
    }
    @Test
    public void pounds_conversion_isCorrect() {
        assertEquals(45.36, ConverterRepository.toKilograms(100),0.01);
    }
}