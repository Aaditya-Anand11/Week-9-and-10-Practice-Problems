# Week 9 and 10 Practice Problems

Java solutions for the Week 9 and 10 string practice documents.

## Structure

```text
src/
  examples/   Sample program from the documents
  level1/     Basic string operations and runtime exception handling
  level2/     Word processing, character classification, and simple reports
  level3/     Advanced string programs, calendar, BMI, and deck of cards
```

Each file is a standalone Java program with a `main` method. Class names match
file names, so each program can be compiled and run independently.

## Compile

From the repository root:

```powershell
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out src\examples\*.java src\level1\*.java src\level2\*.java src\level3\*.java
```

## Run

Use the compiled output folder as the classpath:

```powershell
java -cp out CompareStrings
java -cp out SplitWordsCompare
java -cp out MonthlyCalendar
```

## Problems Covered

### Example

| File | Problem |
| --- | --- |
| `src/examples/StringAnalyzer.java` | Find every index of a character in a string using `charAt()` |

### Level 1

| File | Problem |
| --- | --- |
| `CompareStrings.java` | Compare two strings manually and with `equals()` |
| `ManualSubstring.java` | Build a substring manually and compare with `substring()` |
| `StringToCharacters.java` | Convert a string to characters manually and compare with `toCharArray()` |
| `NullPointerDemo.java` | Demonstrate and handle `NullPointerException` |
| `StringIndexOutOfBoundsDemo.java` | Demonstrate and handle `StringIndexOutOfBoundsException` |
| `IllegalArgumentDemo.java` | Demonstrate and handle `IllegalArgumentException` |
| `NumberFormatDemo.java` | Demonstrate and handle `NumberFormatException` |
| `ArrayIndexOutOfBoundsDemo.java` | Demonstrate and handle `ArrayIndexOutOfBoundsException` |
| `UppercaseConverter.java` | Convert text to uppercase manually and compare with `toUpperCase()` |
| `LowercaseConverter.java` | Convert text to lowercase manually and compare with `toLowerCase()` |

### Level 2

| File | Problem |
| --- | --- |
| `ManualStringLength.java` | Find string length without using `length()` |
| `SplitWordsCompare.java` | Split text into words manually and compare with `split()` |
| `WordLengthsTable.java` | Display words with their lengths |
| `ShortestLongestWords.java` | Find shortest and longest words |
| `VowelConsonantCount.java` | Count vowels and consonants |
| `CharacterTypeTable.java` | Classify each character as vowel, consonant, or not a letter |
| `ManualTrim.java` | Trim leading and trailing spaces manually |
| `StudentVotingEligibility.java` | Generate student ages and check voting eligibility |
| `RockPaperScissorsStats.java` | Play multiple rock-paper-scissors games and show stats |
| `StudentGradeReport.java` | Generate marks, compute total, average, percentage, and grade |

### Level 3

| File | Problem |
| --- | --- |
| `BmiReport.java` | Compute BMI and BMI status for a team |
| `UniqueCharacters.java` | Find unique characters using `charAt()` |
| `FirstNonRepeatingCharacter.java` | Find the first non-repeating character |
| `CharacterFrequencyAscii.java` | Find character frequency using an ASCII frequency array |
| `CharacterFrequencyUnique.java` | Find character frequency using unique characters |
| `CharacterFrequencyNested.java` | Find character frequency using nested loops |
| `PalindromeChecker.java` | Check palindrome using iterative, recursive, and array methods |
| `AnagramChecker.java` | Check whether two texts are anagrams |
| `MonthlyCalendar.java` | Display a calendar for a given month and year |
| `DeckOfCards.java` | Create, shuffle, distribute, and print a deck of cards |

## Notes

- Programs keep logic in named methods instead of placing all work in `main`.
- Inputs are read with `Scanner`.
- Exception examples demonstrate unsafe methods and then run handled versions so
  the programs remain usable from the command line.
