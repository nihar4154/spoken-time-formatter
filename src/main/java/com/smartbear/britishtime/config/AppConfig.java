package com.smartbear.britishtime.config;

import com.smartbear.britishtime.formatter.BritishTimeFormatter;
import com.smartbear.britishtime.formatter.SpokenTimeFormatter;
import com.smartbear.britishtime.service.TimeFormatterService;
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
