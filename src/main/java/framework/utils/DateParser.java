package framework.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DateParser
{
    public static String dateParser()
    {
        int currentDay = Integer.parseInt(String.valueOf(getCurrentDate().get("day")));

        String suffix;
        String month = "";

        int tens;
        int hundreds;

        tens = currentDay % 10;
        hundreds = currentDay % 100;

        switch (getCurrentDate().get("month")) {
            case 0 -> month = "January";
            case 1 -> month = "February";
            case 2 -> month = "March";
            case 3 -> month = "April";
            case 4 -> month = "May";
            case 5 -> month = "June";
            case 6 -> month = "July";
            case 7 -> month = "August";
            case 8 -> month = "September";
            case 9 -> month = "October";
            case 10 -> month = "November";
            case 11 -> month = "December";
        }

        if (tens == 1 && hundreds != 11) {
            suffix = "st";
            return month + " " + getCurrentDate().get("day") + suffix + ", " + getCurrentDate().get("year");
        }
        if (tens == 2 && hundreds != 12) {
            suffix = "nd";
            return month + " " + getCurrentDate().get("day") + suffix + ", " + getCurrentDate().get("year");
        }
        if (tens == 3 && hundreds != 13) {
            suffix = "rd";
            return month + " " + getCurrentDate().get("day") + suffix + ", " + getCurrentDate().get("year");
        }

        suffix = "th";

        return month + " " + getCurrentDate().get("day") + suffix + ", " + getCurrentDate().get("year");
    }

    private static Map<String, Integer> getCurrentDate()
    {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        Map<String, Integer> dateObj = new HashMap<>();

        dateObj.put("day", day);
        dateObj.put("month", month);
        dateObj.put("year", year);

        return dateObj;
    }
}