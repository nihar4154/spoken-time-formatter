package com.example.time.formatter;

import java.time.LocalTime;

/** An interface for formatting time into spoken language. */
public interface SpokenTimeFormatter {
  String format(LocalTime time);
}
