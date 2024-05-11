package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{

    Person person;

    @BeforeEach
    void setUp() {
        Name name = new Name("John", "Doe");
        Date dateOfBirth = new Date(1975, 12, 30);
        person = new Person(name, dateOfBirth, null);
    }

    @AfterEach
    void tearDown() {
        person = null;
    }

    @Test
    void testGetDetails_LivingPerson() {
        Name name = new Name("John", "Doe");
        Date dateOfBirth = new Date(1990, 5, 15);
        Person person = new Person(name, dateOfBirth, null);

        assertEquals("John Doe (alive) was born on Wednesday, 5 15, 1990!", person.getDetails());
    }

    @Test
    void testGetDetails_DeadPerson() {
        Name name = new Name("John", "Doe");
        Date dateOfBirth = new Date(1990, 5, 15);
        Date dateOfDeath = new Date(2024, 4, 29); // April 29, 2024
        Person person = new Person(name, dateOfBirth, dateOfDeath);

        assertEquals("John Doe (died Saturday, 4 29, 2024) was born on Wednesday, 5 15, 1990!", person.getDetails());
    }
}