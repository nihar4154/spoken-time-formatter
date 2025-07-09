package com.example.time.util;

/**
 * Converts minute/hour numbers (0-59) to English words. Precomputes all values during class
 * initialization for O(1) runtime lookup.
 */
public final class NumberToWords {

  // Range configuration
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 59;
  private static final int TWENTY_START = 20;

  // Vocabulary definitions
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

  private static final String[] TENS = {
    null, null, // Unused for 0-9
    "twenty", "thirty", "forty", "fifty"
  };

  // Precomputed word mappings
  private static final String[] NUMBER_WORDS = new String[MAX_VALUE - MIN_VALUE + 1];

  // Error message template
  private static final String ERROR_TEMPLATE =
      "Invalid number: %d. Must be between %d and %d inclusive.";

  static {
    // Initialize 0-19
    System.arraycopy(BELOW_TWENTY, 0, NUMBER_WORDS, 0, BELOW_TWENTY.length);

    // Initialize 20-59
    for (int num = TWENTY_START; num <= MAX_VALUE; num++) {
      final int tensDigit = num / 10;
      final int unitsDigit = num % 10;

      final String tensWord = TENS[tensDigit];

      if (unitsDigit == 0) {
        NUMBER_WORDS[num] = tensWord; // Exact tens
      } else {
        NUMBER_WORDS[num] = tensWord + " " + BELOW_TWENTY[unitsDigit]; // Composite
      }
    }
  }

  private NumberToWords() {}

  /**
   * Converts a number to its English spoken form.
   *
   * @param number Value between 0-59 (inclusive)
   * @return English words representation
   * @throws IllegalArgumentException for invalid numbers
   */
  public static String convert(int number) {
    if (number < MIN_VALUE || number > MAX_VALUE) {
      throw new IllegalArgumentException(
          String.format(ERROR_TEMPLATE, number, MIN_VALUE, MAX_VALUE));
    }
    return NUMBER_WORDS[number];
  }
}
