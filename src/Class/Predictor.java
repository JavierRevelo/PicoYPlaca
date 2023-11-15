/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zen
 */
public class Predictor {

    private String plateNumber;
    private String date;
    private String time;
    private static final Map<Integer, Integer[]> dayConditions = new HashMap<>();

    static {
        dayConditions.put(Calendar.MONDAY, new Integer[]{1, 2});
        dayConditions.put(Calendar.TUESDAY, new Integer[]{3, 4});
        dayConditions.put(Calendar.WEDNESDAY, new Integer[]{5, 6});
        dayConditions.put(Calendar.THURSDAY, new Integer[]{7, 8});
        dayConditions.put(Calendar.FRIDAY, new Integer[]{9, 0});
    }

    public Predictor(String plateNumber, String date, String time) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.time = time;
    }

    public boolean canDrive() {
        Calendar dayOfTheWeek = identifyDayOfTheWeek();
        int lastPlateNumber = isPlateAllowed();
        Integer[] conditions = dayConditions.get(dayOfTheWeek);
        if (dayOfTheWeek.DAY_OF_WEEK == Calendar.SUNDAY || dayOfTheWeek.DAY_OF_WEEK == Calendar.SATURDAY) {
            return true;
        } else {
            for (Integer condition : conditions) {
                if (condition == lastPlateNumber && isWithinNotAllowedTime()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWithinNotAllowedTime() {
        try {
            //Creating the time format
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date currentTime = format.parse(this.time);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentTime);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            // This part check if the time is within allowed hours (7:00 am - 9:30 am / 4:00 pm - 7:30 pm)
            return (hour >= 7 && hour <= 9 && minute <= 30) || (hour >= 16 && hour <= 19 && minute <= 30);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error on isWithinAllowedTime function");
            return false;
        }
    }

    private int isPlateAllowed() {
        int lastDigit;
        try {
            // Gets the last digit of the plate number
            lastDigit = Integer.parseInt(plateNumber.substring(plateNumber.length() - 1));
            System.out.println("Last digit is:" + lastDigit);
            return lastDigit;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Parsing plate number");
            return -1;
        }

        // Check if the plate is allowed based on hypothetical rules (e.g., odd or even)
        // Replace this with the actual Pico y Placa rules for your area
        // Example: Even-numbered plates are allowed
    }

    private Calendar identifyDayOfTheWeek() {
        Calendar day;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(this.date);

            day = Calendar.getInstance();
            day.setTime(date);
            return day;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error al analizar la fecha");
            return day = null;
        }
    }
}
