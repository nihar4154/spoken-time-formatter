package com.smartbear.britishtime.cli;

import com.smartbear.britishtime.config.AppConfig;
import com.smartbear.britishtime.service.TimeFormatterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    final String locale = "british"; // Default locale, can be changed to support other formats

    try (AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class)) {
      final TimeFormatterService service = context.getBean(TimeFormatterService.class);
      final CommandLineInterface cli = new CommandLineInterface(service);
      cli.start(locale);
    }
  }
}
