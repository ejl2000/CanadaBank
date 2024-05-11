package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankClient client;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        client = new BankClient(new Name("John", "Doe"), new Date(1990, 1, 1), null, "12345", new Date(2020, 1, 1));
        account = new BankAccount(client, 100.0, "0000", "ABCDEF1");
    }

    @AfterEach
    void tearDown() {
        client = null;
        account = null;
    }

    @Test
    void withdraw_sufficientBalance() {
        assertTrue(account.withdraw(50.0));
        assertEquals(50.0, account.getBalanceUsd());
    }

    @Test
    void withdraw_insufficientBalance() {
        assertFalse(account.withdraw(150.0));
        assertEquals(100.0, account.getBalanceUsd());
    }

    @Test
    void withdraw_withPin() {
        assertTrue(account.withdraw(50.0, "0000"));
        assertEquals(50.0, account.getBalanceUsd());
    }

    @Test
    void withdraw_withIncorrectPin() {
        assertFalse(account.withdraw(50.0, "1111")); // Incorrect PIN
        assertEquals(100.0, account.getBalanceUsd());
    }

    @Test
    void withdraw_negativeAmount() {
        assertFalse(account.withdraw(-50.0)); // Negative amount
        assertEquals(100.0, account.getBalanceUsd());
    }
}
