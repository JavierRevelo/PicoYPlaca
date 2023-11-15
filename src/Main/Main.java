/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Class.Predictor;
import java.util.Scanner;

/**
 *
 * @author Zen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Get input from the user or any other source
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the license plate number (e.g., PBX-1234): ");
        String plateNumber = scanner.nextLine();
        System.out.print("Enter the date (dd-mm-yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter the time (HH:MM): ");
        String time = scanner.nextLine();

        // Create an instance of the PicoYPlacaPredictor class
        Predictor predictor = new Predictor(plateNumber, date, time);

        // Check if the car can be on the road
        if (predictor.canDrive()) {
            System.out.println("The car can be on the road.");
        } else {
            System.out.println("The car cannot be on the road.");
        }
    }
}
