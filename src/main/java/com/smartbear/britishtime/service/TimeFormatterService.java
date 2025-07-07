package com.smartbear.britishtime.service;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.formatter.SpokenTimeFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Service for formatting time into spoken language based on locale.
 *
 * <p>This service uses a map of locale-specific time formatters to convert a time string in HH:mm
 * format into a spoken representation.
 */
@Component
public class TimeFormatterService {

  private final Map<String, SpokenTimeFormatter> formatterMap;

  private static final DateTimeFormatter TIME_FORMATTER =
      new DateTimeFormatterBuilder()
          .appendValue(ChronoField.HOUR_OF_DAY, 1, 2, java.time.format.SignStyle.NOT_NEGATIVE)
          .appendPattern(":mm")
          .toFormatter();

  public TimeFormatterService(Map<String, SpokenTimeFormatter> formatterMap) {
    this.formatterMap = formatterMap;
  }

  public String format(String timeStr, String locale) throws InvalidTimeFormatException {
    try {
      final SpokenTimeFormatter formatter =
          formatterMap.get(locale.toLowerCase(java.util.Locale.ROOT));

      if (formatter == null) {
        throw new InvalidTimeFormatException("Unknown locale: " + locale);
      }

      return formatter.format(LocalTime.parse(timeStr, TIME_FORMATTER));
    } catch (DateTimeParseException e) {

      throw new InvalidTimeFormatException("Invalid time format. Use HH:mm (e.g. 07:30).", e);
    } catch (Exception e) {

      throw new InvalidTimeFormatException("Error formatting time: " + e.getMessage(), e);
    }
  }
}
