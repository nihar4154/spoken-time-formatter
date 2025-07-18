package com.example.time.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.time.exception.InvalidTimeFormatException;
import com.example.time.formatter.BritishTimeFormatter;
import com.example.time.formatter.SpokenTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeFormatterServiceTest {

  private TimeFormatterService service;
  private static final String LOCALE = "british";

  @BeforeEach
  void setup() {
    final Map<String, SpokenTimeFormatter> formatterMap = new HashMap<>();
    formatterMap.put(LOCALE, new BritishTimeFormatter());
    service = new TimeFormatterService(formatterMap);
  }

  @Test
  void testValidTimes() {
    assertEquals("half past seven", service.format("07:30", LOCALE));
    assertEquals("quarter past two", service.format("14:15", LOCALE));
    assertEquals("quarter to nine", service.format("08:45", LOCALE));
    assertEquals("noon", service.format("12:00", LOCALE));
    assertEquals("midnight", service.format("00:00", LOCALE));
  }

  @Test
  void testInvalidFormat() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format("not-a-time", LOCALE));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("0730", LOCALE));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("7:3", LOCALE));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("24:01", LOCALE));
  }

  @Test
  void testNullInput() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format(null, LOCALE));
  }

  @Test
  void testEmptyInput() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format("", LOCALE));
    assertThrows(InvalidTimeFormatException.class, () -> service.format(" ", LOCALE));
  }

  @Test
  void testUnknownLocale() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format("07:30", "unknown"));
  }
}
