package com.smartbear.britishtime.service;

import static org.junit.jupiter.api.Assertions.*;

import com.smartbear.britishtime.core.BritishTimeFormatter;
import com.smartbear.britishtime.core.SpokenTimeFormatter;
import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeFormatterServiceTest {

  private TimeFormatterService service;

  @BeforeEach
  void setup() {
    final SpokenTimeFormatter formatter = new BritishTimeFormatter();
    service = new TimeFormatterService(formatter);
  }

  @Test
  void testValidTimes() throws InvalidTimeFormatException {
    assertEquals("half past seven", service.format("07:30"));
    assertEquals("quarter past two", service.format("14:15"));
    assertEquals("quarter to nine", service.format("08:45"));
    assertEquals("noon", service.format("12:00"));
    assertEquals("midnight", service.format("00:00"));
  }

  @Test
  void testInvalidFormat() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format("not-a-time"));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("0730"));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("7:3"));
    assertThrows(InvalidTimeFormatException.class, () -> service.format("24:01"));
  }

  @Test
  void testNullInput() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format(null));
  }

  @Test
  void testEmptyInput() {
    assertThrows(InvalidTimeFormatException.class, () -> service.format(""));
    assertThrows(InvalidTimeFormatException.class, () -> service.format(" "));
  }
}
