package ca.bcit.comp2601.bank;

/**
 * The Date class represents a date with year, month, and day components.
 *
 * @author Emma, Raaz
 * @version 2024
 */
public class Date
{
    private final int year;   // Year
    private final int month;  // Month
    private final int day;    // Day
    private static final String[] DAYS_OF_WEEK = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static final int INT_ZERO = 0;
    private static final int MIN_YEAR = 1;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MONTH_WITH_31_DAYS = 31;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    private static final int START_OF_TWENTYFIRST_CENTURY= 2000;
    private static final int START_OF_TWENTYTIETH_CENTURY= 1900;
    private static final int START_OF_NINETEENTH_CENTURY= 1800;
    private static final int LEAP_YEAR = 1;
    private static final int NOT_LEAP_YEAR = 0;
    private static final int MONTH_MULTIPLIER = 13;
    private static final int MONTH_ADDITION = 1;
    private static final int MONTH_DIVIDER = 5;
    private static final int DAYS_IN_WEEK = 7;
    private static final int CENTURY_ADJUSTMENT_ZERO = 0;
    private static final int CENTURY_ADJUSTMENT_TWO = 2;
    private static final int CENTURY_ADJUSTMENT_SIX = 6;
    private static final int LEAP_MONTH = 3;
    private static final int TWELVE_YEARS = 12;
    private static final int DAYS_IN_JANUARY = 31;
    private static final int DAYS_IN_APRIL = 30;
    private static final int DAYS_IN_FEB_LEAP_YEAR = 29;
    private static final int DAYS_IN_FEB_NON_LEAP_YEAR = 28;
    private static final int DIVISIBLE_BY_FOUR = 4;
    private static final int DIVISIBLE_BY_HUNDRED = 100;
    private static final int DIVISIBLE_BY_FOUR_HUNDRED = 400;

    /**
     * Constructs a Date object with the specified year, month, and day.
     *
     * @param year  The year of the date.
     * @param month The month of the date (1 for January, 2 for February, etc.).
     * @param day   The day of the month.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        if (year < MIN_YEAR || year > getCurrentYear())
        {
            throw new IllegalArgumentException("Invalid year.");
        }
        if (month < MIN_MONTH || month > MAX_MONTH)
        {
            throw new IllegalArgumentException("Invalid month.");
        }
        if (day < MIN_DAY  || day > getDaysInMonth(year, month))
        {
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
     * @param year  The year of the date.
     * @param month The month of the date.
     * @param day   The day of the date.
     * @return The day of the week as a string (e.g., "Monday", "Tuesday", etc.).
     */
    public String getDayOfWeek(final int year,
                               final int month,
                               final int day)
    {
        int dayOfWeek = calculateDayOfWeek(year, month, day);
        return DAYS_OF_WEEK[dayOfWeek];
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
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                return DAYS_IN_JANUARY;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER:
                return DAYS_IN_APRIL;
            case FEBRUARY:
                return (year % DIVISIBLE_BY_FOUR == INT_ZERO && year % DIVISIBLE_BY_HUNDRED != INT_ZERO) ||
                        year % DIVISIBLE_BY_FOUR_HUNDRED  == INT_ZERO ? DAYS_IN_FEB_LEAP_YEAR : DAYS_IN_FEB_NON_LEAP_YEAR;
            default:
                throw new IllegalArgumentException("Invalid month.");
        }
    }

    /**
     * Returns the current year.
     *
     * @return The current year.
     */
    private int getCurrentYear()
    {
        return java.time.LocalDate.now().getYear();
    }

    /**
     * Calculates the day of the week for the date.
     *
     * @param year  The year.
     * @param month The month.
     * @param day   The day.
     * @return The day of the week (0 for Saturday, 1 for Sunday, etc.).
     */
    private int calculateDayOfWeek(int year, int month, final int day)
    {
        // Adjustments for different centuries
        int centuryAdjustment;
        centuryAdjustment =  CENTURY_ADJUSTMENT_ZERO;

        if (year >= START_OF_TWENTYFIRST_CENTURY)
        {
            centuryAdjustment = CENTURY_ADJUSTMENT_SIX;
        }
        else if (year >= START_OF_TWENTYTIETH_CENTURY && year < START_OF_TWENTYFIRST_CENTURY)
        {
            centuryAdjustment = CENTURY_ADJUSTMENT_ZERO;
        }
        else if (year >= START_OF_NINETEENTH_CENTURY && year < START_OF_TWENTYTIETH_CENTURY)
        {
            centuryAdjustment =  CENTURY_ADJUSTMENT_TWO;
        }

        // Adjustments for leap years and January/February
        if (month < LEAP_MONTH)
        {
            year -= LEAP_YEAR;
            month += TWELVE_YEARS;
        }
        int leapYearAdjustment = ((year % DIVISIBLE_BY_FOUR == INT_ZERO && year % DIVISIBLE_BY_HUNDRED != INT_ZERO)
                || year % DIVISIBLE_BY_FOUR_HUNDRED == INT_ZERO) ? LEAP_YEAR : NOT_LEAP_YEAR;
        int monthCode = (MONTH_MULTIPLIER * (month + MONTH_ADDITION)) / MONTH_DIVIDER;
        int result = (day + monthCode + year + leapYearAdjustment + centuryAdjustment) % DAYS_IN_WEEK;
        return result;
    }
}
