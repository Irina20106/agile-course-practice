package ru.unn.agile.numbersIn-words.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersInWordsTest {

  /*
    @Test

    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(1, 1), z);
    }
//*/
    @Test
    public void canConvertZero() {
        String convertString = NumbersInWords.convert(0);
        assertEquals(convertString, "zero");
    }

    @Test
    public void canConvertaNumberOfSeveralZeros() {
        String convertString = NumbersInWords.convert(000);
        assertEquals(convertString, "zero");
    }

    @Test
    public void can convertTheTopTenNumbers() {
        String convertString = NumbersInWords.convert(6);
        assertEquals(convertString, "Six");
    }

    @Test
    public void can convertMultiplesOfTen() {
        String convertString = NumbersInWords.convert(80);
        assertEquals(convertString, "Eighty");
    }

    @Test
    public void canConvertNumbersToHundreds() {
        String convertString = NumbersInWords.convert(54);
        assertEquals(convertString, "Fifty One");
    }

    @Test
    public void can convertMultiplesOfHundred() {
        String convertString = NumbersInWords.convert(200);
        assertEquals(convertString, "Two hundred");
    }

    @Test
    public void canConvertLessThousand() {
        String convertString = NumbersInWords.convert(115);
        assertEquals(convertString, "One hundred Fifteen");
    }

    @Test
    public void can convertMultiplesOfThousand() {
        String convertString = NumbersInWords.convert(3000);
        assertEquals(convertString, "Three thousand");
    }

    @Test
    public void canConvertLessMillion() {
        String convertString = NumbersInWords.convert(29076);
        assertEquals(convertString, "Twenty Nine thousand Seventy Six");
    }

    @Test
    public void can convertMultiplesOfMillion() {
        String convertString = NumbersInWords.convert(9000000);
        assertEquals(convertString, "Nine million");
    }

    @Test
    public void canConvertLessBillion() {
        String convertString = NumbersInWords.convert(7832504);
        assertEquals(convertString, "Seven million Eight hundred Thirty Two thousand Five hundred Four");
    }









}