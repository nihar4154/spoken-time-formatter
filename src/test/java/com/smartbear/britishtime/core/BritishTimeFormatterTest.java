package com.smartbear.britishtime.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class BritishTimeFormatterTest {

  private final SpokenTimeFormatter formatter = new BritishTimeFormatter();

  @Test
  void testMidnight() {
    assertEquals("midnight", formatter.format(LocalTime.of(0, 0)));
  }

  @Test
  void testNoon() {
    assertEquals("noon", formatter.format(LocalTime.of(12, 0)));
  }

  @Test
  void testFullHour() {
    assertEquals("two o'clock", formatter.format(LocalTime.of(2, 0)));
    assertEquals("noon", formatter.format(LocalTime.of(12, 0))); // updated
  }

  @Test
  void testQuarterPast() {
    assertEquals("quarter past three", formatter.format(LocalTime.of(3, 15)));
  }

  @Test
  void testHalfPast() {
    assertEquals("half past seven", formatter.format(LocalTime.of(7, 30)));
  }

  @Test
  void testQuarterTo() {
    assertEquals("quarter to six", formatter.format(LocalTime.of(5, 45)));
  }

  @Test
  void testPastTimes() {
    assertEquals("twenty five past four", formatter.format(LocalTime.of(4, 25)));
    assertEquals("one past one", formatter.format(LocalTime.of(1, 1)));
  }

  @Test
  void testToTimes() {
    assertEquals("twenty to nine", formatter.format(LocalTime.of(8, 40)));
    assertEquals("five to twelve", formatter.format(LocalTime.of(11, 55)));
  }

  @Test
  void testFallbackEdge() {
    assertEquals("twenty nine to eight", formatter.format(LocalTime.of(7, 31)));
    assertEquals("twenty nine past two", formatter.format(LocalTime.of(2, 29)));
  }

  @Test
  void testSingleDigitHour() {
    assertEquals("ten past one", formatter.format(LocalTime.of(1, 10)));
  }

  @Test
  void testLateNight() {
    assertEquals("quarter to twelve", formatter.format(LocalTime.of(11, 45)));
    assertEquals("twenty five to one", formatter.format(LocalTime.of(0, 35)));
  }
}
