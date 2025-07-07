package com.smartbear.britishtime.cli;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.formatter.SpokenTimeFormatter;
import com.smartbear.britishtime.formatter.TimeFormatterFactory;
import com.smartbear.britishtime.service.TimeFormatterService;
import java.util.Scanner;

@SuppressWarnings("PMD")
public class Main {

  public static void main(String[] args) {

    final String locale = "british"; // This can be changed to support different locales
    final SpokenTimeFormatter formatter = TimeFormatterFactory.getFormatter(locale);
    final TimeFormatterService service = new TimeFormatterService(formatter);

    final Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a time in HH:mm format (or type 'exit' to quit):");

    while (true) {
      System.out.print("> ");
      final String input = scanner.nextLine().trim();

      if (input.equalsIgnoreCase("exit")) {
        System.out.println("Goodbye!");
        break;
      }

      try {
        final String spokenTime = service.format(input);
        System.out.println(spokenTime);
      } catch (InvalidTimeFormatException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    scanner.close();
  }
}
