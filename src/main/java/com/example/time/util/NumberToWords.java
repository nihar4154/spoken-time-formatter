package com.example.time.util;

/** Utility to convert numbers (0–59) into their English word representation. */
public final class NumberToWords {

  private static final int LOWER_BOUND = 0;
  private static final int UPPER_BOUND = 59;
  private static final int TWENTY = 20;
  private static final int TEN = 10;

  private static final String[] BELOW_TWENTY = {
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  };

  private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty"};

  // Prevent instantiation
  private NumberToWords() {}

  /**
   * Converts a number between 0 and 59 to its English spoken form.
   *
   * @param number the number to convert (must be between 0 and 59)
   * @return the number in English words (e.g. 42 → "forty two")
   * @throws IllegalArgumentException if the number is outside [0, 59]
   */
  public static String convert(int number) {
    if (number < LOWER_BOUND || number > UPPER_BOUND) {
      throw new IllegalArgumentException(
          "Number out of range: "
              + number
              + ". Must be between "
              + LOWER_BOUND
              + " and "
              + UPPER_BOUND
              + ".");
    }

    if (number < TWENTY) {
      return BELOW_TWENTY[number];
    }

    final int tens = number / TEN;
    final int ones = number % TEN;

    return ones == 0 ? TENS[tens] : TENS[tens] + " " + BELOW_TWENTY[ones];
  }
}
