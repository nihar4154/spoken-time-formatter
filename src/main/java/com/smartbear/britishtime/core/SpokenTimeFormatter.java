package com.smartbear.britishtime.core;

import java.time.LocalTime;

public interface SpokenTimeFormatter {
  String format(LocalTime time);
}
