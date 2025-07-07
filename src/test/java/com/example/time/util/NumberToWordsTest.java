package com.example.time.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberToWordsTest {

  @Test
  void testBelowTwenty() {
    assertEquals("zero", NumberToWords.convert(0));
    assertEquals("one", NumberToWords.convert(1));
    assertEquals("twelve", NumberToWords.convert(12));
    assertEquals("nineteen", NumberToWords.convert(19));
  }

  @Test
  void testMultiplesOfTen() {
    assertEquals("twenty", NumberToWords.convert(20));
    assertEquals("thirty", NumberToWords.convert(30));
    assertEquals("forty", NumberToWords.convert(40));
    assertEquals("fifty", NumberToWords.convert(50));
  }

  @Test
  void testMixedValues() {
    assertEquals("twenty five", NumberToWords.convert(25));
    assertEquals("thirty one", NumberToWords.convert(31));
    assertEquals("forty seven", NumberToWords.convert(47));
    assertEquals("fifty nine", NumberToWords.convert(59));
  }

  @Test
  void testInvalidLow() {
    final Exception ex =
        assertThrows(IllegalArgumentException.class, () -> NumberToWords.convert(-1));
    assertTrue(ex.getMessage().contains("range"));
  }

  @Test
  void testInvalidHigh() {
    final Exception ex =
        assertThrows(IllegalArgumentException.class, () -> NumberToWords.convert(60));
    assertTrue(ex.getMessage().contains("range"));
  }
}
