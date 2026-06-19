# Quantity Measurement Application (UC1) - Feet Equality

This project implements the first use case of the **Quantity Measurement Application**, focusing on checking the **equality of measurements in feet**. It uses **Test-Driven Development (TDD)** principles to ensure high-quality, reliable code.

## Features
- **Feet Measurement Class**: A robust inner class `Feet` to represent measurements in feet
- **Precise Equality Check**: Overridden `equals()` method for accurate comparison of foot measurements
- **Comprehensive Testing**: JUnit 5 tests covering various scenarios including equality, inequality, null checks, and class type validation

## Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6 or higher

## Setup
1. **Clone the repository** (if applicable)
2. **Open the project** in your IDE
3. **Run the tests** to verify functionality

## Project Structure
```
src/main/java/com/apps/quantitymeasurement/
├── QuantityMeasurementApp.java
└── QuantityMeasurementAppTest.java
```

## Getting Started

### Running Tests
To run the JUnit 5 tests and verify the implementation:
```bash
mvn test
```

### Running the Application
To run the main demonstration:
```bash
mvn exec:java -Dexec.mainClass="com.apps.quantitymeasurement.QuantityMeasurementApp"
```

## Sample Output
```
Input: 1.0 ft and 1.0 ft
Output: Equal (true)

Input: 1.0 ft and 2.0 ft
Output: Equal (false)
```

## Code Explanation

### QuantityMeasurementApp.java
Contains the `Feet` inner class with the following:
- `equals(Object obj)` method implementing:
  - Reference check (same object)
  - Null check
  - Type check (must be `Feet` instance)
  - Value comparison using `Double.compare()` for floating-point precision

### QuantityMeasurementAppTest.java
JUnit 5 tests verifying:
- `testFeetEquality_SameValue()`: Two `Feet` objects with the same value are equal
- `testFeetEquality_DifferentValue()`: Different values result in inequality
- `testFeetEquality_NullComparison()`: Comparing with `null` returns `false`
- `testFeetEquality_DifferentClass()`: Different class types are not equal
- `testFeetEquality_SameReference()`: Same object reference returns `true`

## License
This project is created as part of the Quantity Measurement Application assignment, following the principles of Test-Driven Development.
