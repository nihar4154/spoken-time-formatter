package com.smartbear.britishtime.service;

import com.smartbear.britishtime.core.SpokenTimeFormatter;
import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeFormatterService {
  private final SpokenTimeFormatter formatter;
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

  public TimeFormatterService(SpokenTimeFormatter formatter) {
    this.formatter = formatter;
  }

  /**
   * Converts a time string in HH:mm format to British spoken time.
   *
   * @param timeStr input time string
   * @return spoken English representation
   * @throws InvalidTimeFormatException if input is invalid or malformed
   */
  public String format(String timeStr) throws InvalidTimeFormatException {
    try {
      final LocalTime time = LocalTime.parse(timeStr, TIME_FORMATTER);
      return formatter.format(time);
    } catch (DateTimeParseException e) {
      throw new InvalidTimeFormatException("Invalid time format. Use HH:mm (e.g. 07:30).", e);
    } catch (Exception e) {
      throw new InvalidTimeFormatException("Error formatting time: " + e.getMessage(), e);
    }
  }
}
