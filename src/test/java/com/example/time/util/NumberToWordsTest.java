package com.example.time.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberToWordsTest {

  @ParameterizedTest(name = "input: {0} => word: {1}")
  @CsvSource({
    "0, zero",
    "1, one",
    "2, two",
    "3, three",
    "4, four",
    "5, five",
    "6, six",
    "7, seven",
    "8, eight",
    "9, nine",
    "10, ten",
    "11, eleven",
    "12, twelve",
    "13, thirteen",
    "14, fourteen",
    "15, fifteen",
    "16, sixteen",
    "17, seventeen",
    "18, eighteen",
    "19, nineteen",
    "20, twenty",
    "21, twenty one",
    "29, twenty nine",
    "30, thirty",
    "31, thirty one",
    "32, thirty two",
    "33, thirty three",
    "34, thirty four",
    "35, thirty five",
    "36, thirty six",
    "37, thirty seven",
    "38, thirty eight",
    "39, thirty nine",
    "40, forty",
    "41, forty one",
    "42, forty two",
    "43, forty three",
    "44, forty four",
    "45, forty five",
    "46, forty six",
    "47, forty seven",
    "48, forty eight",
    "49, forty nine",
    "50, fifty",
    "51, fifty one",
    "52, fifty two",
    "53, fifty three",
    "54, fifty four",
    "55, fifty five",
    "56, fifty six",
    "57, fifty seven",
    "58, fifty eight",
    "59, fifty nine"
  })
  void testConvert(int number, String expected) {
    assertEquals(expected, NumberToWords.convert(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 60, 99})
  void testOutOfRangeThrows(int invalid) {
    assertThrows(IllegalArgumentException.class, () -> NumberToWords.convert(invalid));
  }
}
