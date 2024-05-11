package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest
{
    Name name;

    @BeforeEach
    void setUp()
    {
        name = new Name("tigER", "wooDS");
    }

    @AfterEach
    void tearDown()
    {
        name = null;
    }

    @Test
    void getInitials()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("T.W.", name.getInitials());

        name = new Name("eLoN", "MuSk");
        assertEquals("E.M.", name.getInitials());
    }

    @Test
    void getFullName()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("tigER wooDS", name.getFullName());

        name = new Name("eLoN", "MuSk");
        assertEquals("eLoN MuSk", name.getFullName());
    }

    @Test
    void getFirst()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("tigER", name.getFirst());

        name = new Name("eLoN", "MuSk");
        assertEquals("eLoN", name.getFirst());
    }

    @Test
    void getLast()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("wooDS", name.getLast());

        name = new Name("eLoN", "MuSk");
        assertEquals("MuSk", name.getLast());
    }

    @Test
    void constructorThrows_withBadArgument() {
        // Test null first name
        Exception nullFirstNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(null, "wooDS");
        });
        assertEquals("First and last names must not be null or blank.", nullFirstNameException.getMessage());

        // Test blank first name
        Exception blankFirstNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("", "wooDS");
        });
        assertEquals("First and last names must not be null or blank.", blankFirstNameException.getMessage());

        // Test first name containing "admin"
        Exception adminFirstNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("AdMiN", "wooDS");
        });
        assertEquals("Names must not contain the word 'admin' (case insensitive).", adminFirstNameException.getMessage());

        // Test first name more than 45 characters long
        Exception longFirstNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("ThisIsAReallyLongFirstNameThatExceedsFortyFiveCharacters", "wooDS");
        });
        assertEquals("First and last names must not exceed 45 characters.", longFirstNameException.getMessage());

        // Test null last name
        Exception nullLastNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("tigER", null);
        });
        assertEquals("First and last names must not be null or blank.", nullLastNameException.getMessage());

        // Test blank last name
        Exception blankLastNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("tigER", "");
        });
        assertEquals("First and last names must not be null or blank.", blankLastNameException.getMessage());

        // Test last name containing "admin"
        Exception adminLastNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("tigER", "AdMiN");
        });
        assertEquals("Names must not contain the word 'admin' (case insensitive).", adminLastNameException.getMessage());

        // Test last name more than 45 characters long
        Exception longLastNameException = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("tigER", "ThisIsAReallyLongLastNameThatExceedsFortyFiveCharacters");
        });
        assertEquals("First and last names must not exceed 45 characters.", longLastNameException.getMessage());
    }
}