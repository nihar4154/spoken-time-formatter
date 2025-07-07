package com.smartbear.britishtime.formatter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TimeFormatterFactory {
  private static final Map<String, SpokenTimeFormatter> FORMATTERS = new HashMap<>();

  static {
    FORMATTERS.put("british", new BritishTimeFormatter());
    // Add more formatters here as needed
  }

  public static SpokenTimeFormatter getFormatter(String locale) {
    final SpokenTimeFormatter formatter = FORMATTERS.get(locale.toLowerCase(Locale.ROOT));
    if (formatter == null) {
      throw new IllegalArgumentException("Unknown formatter: " + locale);
    }
    return formatter;
  }
}
