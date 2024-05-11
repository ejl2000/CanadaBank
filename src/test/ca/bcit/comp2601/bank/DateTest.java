package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @Test
    void testGetDayOfWeek_October_31_1977() {
        Date date = new Date(1977, 10, 31); // October 31 1977
        assertEquals("Monday", date.getDayOfWeek(1977, 10, 31));
    }

    @Test
    void testGetDayOfWeek_March_15_2021() {
        Date date = new Date(2021, 3, 15); // March 15 2021
        assertEquals("Monday", date.getDayOfWeek(2021, 3, 15));
    }

    @Test
    void testGetDayOfWeek_March_1_2000() {
        Date date = new Date(2000, 3, 1); // March 1 2000
        assertEquals("Wednesday", date.getDayOfWeek(2000, 3, 1));
    }

    @Test
    void testGetDayOfWeek_January_1_1800() {
        Date date = new Date(1800, 1, 1); // January 1 1800
        assertEquals("Wednesday", date.getDayOfWeek(1800, 1, 1));
    }

    @Test
    void testGetDayOfWeek_February_29_2000() {
        Date date = new Date(2000, 2, 29); // February 29 2000 (leap year)
        assertEquals("Tuesday", date.getDayOfWeek(2000, 2, 29));
    }

    @Test
    void testGetDayOfWeek_February_28_1900() {
        Date date = new Date(1900, 2, 28); // February 28 1900 (not a leap year)
        assertEquals("Wednesday", date.getDayOfWeek(1900, 2, 28));
    }
}
