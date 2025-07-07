package com.smartbear.britishtime.cli;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.service.TimeFormatterService;
import java.util.Scanner;

public class CommandLineInterface {
  private final TimeFormatterService service;

  public CommandLineInterface(TimeFormatterService service) {
    this.service = service;
  }

  /**
   * Starts the command line interface for time formatting.
   *
   * @param locale the locale to use for formatting (e.g., "british")
   */
  @SuppressWarnings({"PMD.CloseResource", "PMD.DataflowAnomalyAnalysis"})
  public void start(String locale) {
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
        final String spokenTime = service.format(input, locale);
        System.out.println(spokenTime);
      } catch (InvalidTimeFormatException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
    // Do not close scanner to avoid closing System.in (Closing the Scanner would also close
    // System.in for the entire JVM)
  }
}
