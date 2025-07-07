# Spoken Time Formatter

![Build Status](https://github.com/nihar4154/spoken-time-formatter/actions/workflows/ci.yml/badge.svg)

#### A Java CLI application that converts 24-hour formatted time (e.g., `13:45`) into its spoken English form (e.g., `quarter to two`).
Supports multiple locales (currently British; easily extensible).
---

## Features

- Converts time in `HH:mm` format to spoken English (British style)
- Handles special cases: midnight, noon, quarters, half past, etc.
- Extensible for multiple locales (see below)
- Error handling for invalid input and unknown locales
- Code quality enforced with Checkstyle, PMD, Spotless, and code coverage

---

####  Example Usage
```src/ 
13:00 -> one o'clock  
13:15 -> quarter past one  
13:45 -> quarter to two  
00:00 -> midnight  
12:00 -> noon  
25:00 -> InvalidTimeFormatException
```

## Build, Run and Test
```
./gradlew build
./gradlew run
```
You will be prompted to enter a time in HH:mm format.
Type exit to quit.

To run tests and check code quality:
```
./gradlew test
./gradlew jacocoTestReport
./gradlew check
```
### Code Coverage Report: ``build/reports/jacoco/html/index.html``
<hr></hr>

## Multi-Locale Support  
- The application is designed to support multiple spoken time formats (locales).  
- Default locale: british  
- To add a new locale:  
Implement SpokenTimeFormatter for the new locale.  
Register it as a Spring bean in AppConfig.java with a unique name.  
Pass the desired locale name to the CLI (see below).  

How to change locale:  
Currently, the locale is hardcoded in Main.java (final String locale = "british";).  
To support other locales, change this value or make it configurable via command-line arguments.

## Dependencies
- Java 11+, Spring Context, Gradle, JUnit 5
- Checkstyle, PMD, Spotless, Jacoco

---

##  Project Structure  
```
src/
  main/
    java/
      com.smartbear.britishtime/
        cli/         # CLI and Main class
        config/      # Spring configuration
        exception/   # Custom exceptions
        formatter/   # Spoken time formatters (per locale)
        service/     # Service layer
        util/        # Utilities (e.g., number to words)
  test/
    java/            # Unit tests

```

## CI (GitHub Actions) 
Runs tests and checks on every push/PR.  
[CI Status](https://github.com/nihar4154/spoken-time-formatter/actions) 
