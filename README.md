# Pico y Placa Predictor

This project implements a Pico y Placa predictor, determining whether a vehicle with a specific license plate can be on the road based on the date and time.

## Technical Information

- **Language:** Java
- **JDK Version:** 20 (Ensure you have Java 20 installed on your machine)
- **IDE:** Apache NetBeans IDE 17

## Features

- **canDrive():** Determines if the vehicle can be on the road according to Pico y Placa rules.
- **isWithinNotAllowedTime():** Checks if the specified time is within the restricted hours.
- **isPlateAllowed():** Retrieves the last digit of the vehicle's license plate.
- **identifyDayOfTheWeek():** Identifies the day of the week based on the provided date.

## Environment Setup

1. Clone the repository: `git clone https://github.com/your_username/pico-y-placa-predictor.git`
2. Open Apache NetBeans IDE 17.
3. Select "File" -> "Open Project..." and navigate to the project directory (`pico-y-placa-predictor`).
4. The project should be recognized and opened in NetBeans.

## Usage Examples oF Predictor class

```java
Predictor predictor = new Predictor("ABC123", "01/01/2023", "08:30");
boolean canDrive = predictor.canDrive();
System.out.println("Can it be on the road? " + canDrive);
