# British Spoken Time Formatter

### Github Actions Build Status:  
![Build Status](https://github.com/nihar4154/spoken-time-formatter/actions/workflows/ci.yml/badge.svg)

#### This Java project converts 24-hour formatted time (like `13:45`) into its equivalent British spoken English form.

####  Example
```src/ 
13:00 -> one o'clock  
13:15 -> quarter past one  
13:45 -> quarter to two  
00:00 -> midnight  
12:00 -> noon  
25:00 -> InvalidTimeFormatException
```

## Build, Run and Test
```src/
./gradlew build
./gradlew run
```
Enter time in HH:mm (e.g., 14:30)  
Invalid input (e.g., hello) shows an error.  
Type exit to quit the program
```
./gradlew test
./gradlew jacocoTestReport
```
### Code Coverage Report: ``build/reports/jacoco/html/index.html``

---
## Tools
- Java 11+, Gradle, JUnit 5
- Checkstyle, PMD, Spotless for code quality

```
./gradlew check
```

---

##  Project Structure
```src/
core/       -> Time logic  
service/    -> Service class  
util/       -> Number to words  
exception/  -> Invalid time exception  
test/       -> Unit tests

```

## CI
Built with GitHub Actions  
Runs tests and checks on every push/PR.  
https://github.com/nihar4154/spoken-time-formatter/actions
