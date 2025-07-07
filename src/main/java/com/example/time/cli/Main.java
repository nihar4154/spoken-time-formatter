package com.example.time.cli;

import com.example.time.config.AppConfig;
import com.example.time.service.TimeFormatterService;
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
