# British Spoken Time Formatter

![Build Status](https://github.com/nihar4154/spoken-time-formatter/actions/workflows/ci.yml/badge.svg)

This Java project converts 24-hour formatted time (like `13:45`) into its equivalent British spoken English form.

### 🕒 Example Conversions
13:00 → one o'clock
13:15 → quarter past one
13:45 → quarter to two
00:00 → midnight
12:00 → noon


---

## 🚀 Features

- Converts 24-hour time to British-style spoken time
- Special handling for `midnight` and `noon`
- Custom exception handling for invalid time input
- Clean, modular design (formatter, service, utility)
- Comprehensive unit test coverage
- Static code analysis with PMD, Checkstyle
- Auto-formatting with Spotless

---

## 🛠 Tech Stack

- Java 11+
- Gradle
- JUnit 5
- JaCoCo – Code Coverage
- Checkstyle – Google Java Style
- PMD – Static Code Analysis
- Spotless – Code Formatting

---

## 📦 Build & Run

### 🔧 Build the project

```bash
 ./gradlew build
```
### ▶️ Run the CLI
```bash
 ./gradlew run
```

Enter a time in HH:mm format (or type 'exit' to quit):
````
> 13:45  
→ quarter to two  

> 00:00  
→ midnight  

> hello  
✖ Error: Invalid time format: hello
````
You can keep entering inputs, or type exit to quit the program.
### ⌨️ Input Format
Enter time in `HH:mm` 24-hour format (e.g., `13:45`).

- Valid: `00:00`, `12:30`, `23:59`
- Invalid: `25:61`, `hello`, `123`

Invalid input will throw a custom `InvalidTimeFormatException`.

You'll be prompted to enter a time like 14:30, and the app will respond with:

`half past two`
### 🧪 Run Tests
```bash
 ./gradlew test
```

### 📊 Generate Code Coverage Report
```bash
  ./gradlew jacocoTestReport
```
Then open the report in your browser: `build/reports/jacoco/html/index.html`

## 🧼 Code Quality Tools

| Tool       | Command                  | Report Location             |
|------------|--------------------------|-----------------------------|
| Checkstyle | ./gradlew checkstyleMain | build/reports/checkstyle/   |
| PMD        | ./gradlew pmdMain        | build/reports/pmd/main.html |
| Spotless   | ./gradlew spotlessApply  | (autoformats code inline)   |

Run everything together:

```bash
  ./gradlew check
```

##  📁 Project Structure
```src/
├── main/java/com/smartbear/britishtime/
│ ├── core/ → Time formatting logic
│ ├── service/ → Entry-point service layer
│ ├── util/ → Number to words converter
│ └── exception/ → Custom exception for invalid format
└── test/java/ → Unit tests
```
##  ⚠️ Custom Exception
`InvalidTimeFormatException extends RuntimeException`

## ✅ Continuous Integration
This project uses **GitHub Actions** for Continuous Integration (CI).  
Every push or pull request triggers:

- Build (`./gradlew build`)
- Unit tests (`./gradlew test`)
- Code quality checks (Checkstyle, PMD, Spotless)

You can view CI runs under the **Actions** tab on GitHub.

## 🧑‍💻 Author
Built by Nihar Behera.