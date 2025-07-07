package com.example.time.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.time.exception.InvalidTimeFormatException;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BritishTimeFormatterTest {

  private final SpokenTimeFormatter formatter = new BritishTimeFormatter();

  @ParameterizedTest(name = "input: {0} => spoken: {1}")
  @CsvSource({
    "00:00, midnight",
    "00:01, one past twelve",
    "00:15, quarter past twelve",
    "00:30, half past twelve",
    "00:45, quarter to one",
    "01:01, one past one",
    "01:59, one to two",
    "05:29, twenty nine past five",
    "05:31, twenty nine to six",
    "06:45, quarter to seven",
    "11:59, one to twelve",
    "12:00, noon",
    "12:01, one past twelve",
    "12:30, half past twelve",
    "12:45, quarter to one",
    "13:29, twenty nine past one",
    "13:31, twenty nine to two",
    "18:00, six o'clock",
    "23:00, eleven o'clock",
    "23:01, one past eleven",
    "23:45, quarter to twelve"
  })
  void testToSpokenTime(String inputTime, String expectedSpoken) {
    final LocalTime time = LocalTime.parse(inputTime);
    final String spoken = formatter.format(time);
    assertEquals(expectedSpoken, spoken);
  }

  @Test
  void testNullTime() {
    assertThrows(
        InvalidTimeFormatException.class,
        () -> {
          formatter.format(null);
        });
  }
}
