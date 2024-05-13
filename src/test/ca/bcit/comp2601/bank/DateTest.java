package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testValidDateConstructor() {
        // Test valid date
        assertDoesNotThrow(() -> new Date(2024, 5, 12));
    }

    @Test
    void testInvalidYearConstructor() {
        // Test year less than 1
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 5, 12));
        // Test year greater than current year
        assertThrows(IllegalArgumentException.class, () -> new Date(3000, 5, 12));
    }

    @Test
    void testInvalidMonthConstructor() {
        // Test month less than 1
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 0, 12));
        // Test month greater than 12
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 13, 12));
    }

    @Test
    void testInvalidDayConstructor() {
        // Test invalid day for February in non-leap year
        assertThrows(IllegalArgumentException.class, () -> new Date(2023, 2, 29));
        // Test invalid day for February in leap year
        assertDoesNotThrow(() -> new Date(2024, 2, 29));
        // Test invalid day for April (31 days)
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 4, 31));
    }

    @Test
    void testGetYyyyMmDd() {
        // Test getYyyyMmDd method
        Date date = new Date(2024, 5, 12);
        assertEquals("2024-05-12", date.getYyyyMmDd());
    }

    @Test
    void testGetDayOfWeek() {
        // Test getDayOfWeek method
        // Example: March 15, 2021 is Sunday
        Date date1 = new Date(2021, 3, 15);
        assertEquals("Sunday", date1.getDayOfWeek(2021, 3, 15));

        // Example: October 31, 1977 is Friday
        Date date2 = new Date(1977, 10, 31);
        assertEquals("Friday", date2.getDayOfWeek(1977, 10, 31));
    }


    @Test
    void testGetYear() {
        // Test getYear method
        Date date = new Date(2024, 5, 12);
        assertEquals(2024, date.getYear());
    }

    @Test
    void testGetMonth() {
        // Test getMonth method
        Date date = new Date(2024, 5, 12);
        assertEquals(5, date.getMonth());
    }

    @Test
    void testGetDay() {
        // Test getDay method
        Date date = new Date(2024, 5, 12);
        assertEquals(12, date.getDay());
    }
}
