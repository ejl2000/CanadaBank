package ca.bcit.comp2601.bank;

import java.util.*;

/**
 * The Date class represents a date with year, month, and day components.
 *
 * @author Emma Lee
 * @version 2024
 */
public class Date {
    private int year;   // Year
    private int month;  // Month
    private int day;    // Day
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    /**
     * Constructs a Date object with the specified year, month, and day.
     *
     * @param year  The year of the date.
     * @param month The month of the date (1 for January, 2 for February, etc.).
     * @param day   The day of the month.
     * @throws IllegalArgumentException if the year, month, or day is invalid.
     */
    public Date(final int year, final int month, final int day)
    {
        if (year < 1 || year > java.time.LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid year.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }
        if (day < 1 || day > getDaysInMonth(year, month)) {
            throw new IllegalArgumentException("Invalid day.");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the date in "YYYY-MM-DD" format.
     *
     * @return The date string.
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Returns the day of the week for the date.
     *
     * @return The day of the week as a string (e.g., "Monday", "Tuesday", etc.).
     */
    public String getDayOfWeek(final int year, final int month, final int day)
    {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day); // Month is zero-based in Calendar

        int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        return daysOfWeek[dayOfWeek - 1]; // Adjust to start from Sunday
    }

    /**
     * Returns the year of the date.
     *
     * @return The year.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the month of the date.
     *
     * @return The month.
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the day of the date.
     *
     * @return The day.
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the number of days in the specified month and year.
     *
     * @param year  The year.
     * @param month The month (1 for January, 2 for February, etc.).
     * @return The number of days in the month.
     */
    private int getDaysInMonth(final int year, final int month)
    {
        switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month.");
        }
    }
}
