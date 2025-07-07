package com.smartbear.britishtime.formatter;

import java.time.LocalTime;

public interface SpokenTimeFormatter {
  String format(LocalTime time);
}
