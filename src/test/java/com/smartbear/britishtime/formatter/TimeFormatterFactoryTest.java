package com.smartbear.britishtime.formatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeFormatterFactoryTest {

  @Test
  void testGetFormatterWithKnownLocale() {
    final SpokenTimeFormatter formatter = TimeFormatterFactory.getFormatter("british");
    assertNotNull(formatter);
    assertInstanceOf(BritishTimeFormatter.class, formatter);
  }

  @Test
  void testGetFormatterWithUnknownLocale() {
    final Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              TimeFormatterFactory.getFormatter("unknown");
            });
    assertEquals("Unknown formatter: unknown", exception.getMessage());
  }
}
