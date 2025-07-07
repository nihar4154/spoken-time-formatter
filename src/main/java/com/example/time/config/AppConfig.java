package com.example.time.config;

import com.example.time.formatter.BritishTimeFormatter;
import com.example.time.formatter.SpokenTimeFormatter;
import com.example.time.service.TimeFormatterService;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean("british")
  public SpokenTimeFormatter spokenTimeFormatter() {
    return new BritishTimeFormatter();
  }

  // Add other formatters as needed
  /* @Bean("us")
  public SpokenTimeFormatter usTimeFormatter() {
      return new USTimeFormatter();
  }*/

  @Bean
  public TimeFormatterService timeFormatterService(Map<String, SpokenTimeFormatter> formatterMap) {
    return new TimeFormatterService(formatterMap);
  }
}
