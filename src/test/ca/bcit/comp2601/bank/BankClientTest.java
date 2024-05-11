package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankClientTest
{
    BankClient bankClient;

    @BeforeEach
    void setUp() {
        Name name = new Name("John", "Doe");
        Date dateOfBirth = new Date(1990, 1, 1);
        String clientId = "12345";
        Date dateJoinedTheBank = new Date(2020, 9, 3);
        bankClient = new BankClient(name, dateOfBirth, null, clientId, dateJoinedTheBank);
    }

    @AfterEach
    void tearDown() {
        bankClient = null;
    }

    @Test
    void getDetails_alive() {
        Name name = new Name("Tiger", "Woods");
        Date dateOfBirth = new Date(1975, 12, 30);
        String clientId = "12345";
        Date dateJoinedTheBank = new Date(2020, 9, 3);
        BankClient bankClient = new BankClient(name, dateOfBirth, null, clientId, dateJoinedTheBank);
        assertEquals("Tiger Woods client #12345 (alive) joined the bank on Thursday, September 3, 2020", bankClient.getDetails());
    }

    @Test
    void getDetails_deceased() {
        Name name = new Name("Albert", "Einstein");
        Date dateOfBirth = new Date(1879, 3, 14);
        Date dateOfDeath = new Date(1955, 4, 18);
        String clientId = "54321";
        Date dateJoinedTheBank = new Date(1935, 7, 15);
        BankClient bankClient = new BankClient(name, dateOfBirth, dateOfDeath, clientId, dateJoinedTheBank);
        assertEquals("Albert Einstein client #54321 (died Monday, April 18, 1955) joined the bank on Friday, March 14, 1879", bankClient.getDetails());
    }
}