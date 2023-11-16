# Pico y Placa Predictor

This project implements a Pico y Placa predictor, determining whether a vehicle with a specific license plate can be on the road based on the date and time.

## Technical Information

- **Language:** Java
- **JDK Version:** 20 (Ensure you have Java 20 installed on your machine)
- **IDE:** Apache NetBeans IDE 17
- **JUnit:** For test

## Features

- **canDrive():** Determines if the vehicle can be on the road according to Pico y Placa rules.
- **isWithinNotAllowedTime():** Checks if the specified time is within the restricted hours.
- **isPlateAllowed():** Retrieves the last digit of the vehicle's license plate.
- **identifyDayOfTheWeek():** Identifies the day of the week based on the provided date.

## Environment Setup in Apache NetBeans IDE 17

1. Clone the repository: `git clone https://github.com/JavierRevelo/PicoYPlaca.git`
2. Open Apache NetBeans IDE 17.
3. Select "File" -> "Open Project..." and navigate to the project directory (`pico-y-placa-predictor`).
4. The project should be recognized and opened in NetBeans.
5. Run Main.java class in order to

## Running the Project

1. In NetBeans, locate the `Main` class in the project explorer.
2. Right-click on the `Main` class and select "Run File" or simply press `Shift + F6`.
3. This will execute the program and open a graphical interface.

## Using the Graphical Interface

1. In the opened graphical interface, you will find input fields for date, time, and license plate number.
2. Ensure the license plate number is in the correct format, the last digits are numeric.
3. After entering the required information, click the "Search" button.
4. A message will appear on the left specifying whether the vehicle can be on the road or not.

## Usage Examples oF Predictor class

```java
Predictor predictor = new Predictor("ABC123", "01/01/2023", "08:30");
boolean canDrive = predictor.canDrive();
System.out.println("Can it be on the road? " + canDrive);
