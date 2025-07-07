package com.smartbear.britishtime.formatter;

import com.smartbear.britishtime.util.NumberToWords;
import java.time.LocalTime;
import org.springframework.stereotype.Component;

@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
@Component
public class BritishTimeFormatter implements SpokenTimeFormatter {

  private static final int MIDNIGHT_HOUR = 0;
  private static final int NOON_HOUR = 12;
  private static final int ZERO_MINUTES = 0;
  private static final int QUARTER_PAST = 15;
  private static final int HALF_PAST = 30;
  private static final int QUARTER_TO = 45;
  private static final int MINUTES_IN_HOUR = 60;

  @Override
  public String format(LocalTime time) {
    final int hour = time.getHour();
    final int minute = time.getMinute();

    if (isMidnight(hour, minute)) {
      return "midnight";
    }
    if (isNoon(hour, minute)) {
      return "noon";
    }

    final int displayHour = formatHour12(hour);
    final int nextHour = formatHour12(hour + 1);

    if (minute == ZERO_MINUTES) {
      return formatFullHour(displayHour);
    }

    if (minute == QUARTER_PAST) {
      return formatQuarterPast(displayHour);
    }

    if (minute == HALF_PAST) {
      return formatHalfPast(displayHour);
    }

    if (minute == QUARTER_TO) {
      return formatQuarterTo(nextHour);
    }

    if (minute < HALF_PAST) {
      return formatPast(minute, displayHour);
    }
    return formatTo(MINUTES_IN_HOUR - minute, nextHour);
  }

  private boolean isMidnight(int hour, int minute) {
    return hour == MIDNIGHT_HOUR && minute == ZERO_MINUTES;
  }

  private boolean isNoon(int hour, int minute) {
    return hour == NOON_HOUR && minute == ZERO_MINUTES;
  }

  private int formatHour12(int hour) {
    return hour % 12 == 0 ? 12 : hour % 12;
  }

  private String formatFullHour(int hour) {
    return NumberToWords.convert(hour) + " o'clock";
  }

  private String formatQuarterPast(int hour) {
    return "quarter past " + NumberToWords.convert(hour);
  }

  private String formatHalfPast(int hour) {
    return "half past " + NumberToWords.convert(hour);
  }

  private String formatQuarterTo(int hour) {
    return "quarter to " + NumberToWords.convert(hour);
  }

  private String formatPast(int minute, int hour) {
    return NumberToWords.convert(minute) + " past " + NumberToWords.convert(hour);
  }

  private String formatTo(int minute, int hour) {
    return NumberToWords.convert(minute) + " to " + NumberToWords.convert(hour);
  }
}
