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
        int dayOfTheWeek = identifyDayOfTheWeek().getTime().getDay() + 1;
        int lastPlateNumber = isPlateAllowed();
        Integer[] conditions = dayConditions.get(dayOfTheWeek);
        if (dayOfTheWeek == Calendar.SUNDAY || dayOfTheWeek == Calendar.SATURDAY) {
            return true;
        } else {
            for (Integer condition : conditions) {

                if (condition == lastPlateNumber && isWithinNotAllowedTime()) {
                    return false;
                }
            }

        }
        return true;

    }

    public boolean isWithinNotAllowedTime() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date currentTime = format.parse(this.time);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentTime);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            return (hour >= 7 && (hour < 9 || (hour == 9 && minute <= 30)))
                    || (hour >= 16 && (hour < 19 || (hour == 19 && minute <= 30)));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int isPlateAllowed() {
        int lastDigit;
        try {
            lastDigit = Integer.parseInt(plateNumber.substring(plateNumber.length() - 1));
            return lastDigit;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Parsing plate number");
            return -1;
        }
    }

    public Calendar identifyDayOfTheWeek() {
        Calendar day;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(this.date);

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
