package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;
    private BankAccount account1;
    private BankAccount account2;
    private Person ceo;

    @BeforeEach
    void setUp() {
        ceo = new Person(new Name("John", "Doe"), new Date(1990, 1, 1), null);
        bank = new Bank(ceo);
        account1 = new BankAccount(new BankClient(new Name("Alice", "Smith"), new Date(1985, 5, 10), null, "12345", new Date(2020, 1, 1)), 1000, "1234", "ACC1234");
        account2 = new BankAccount(new BankClient(new Name("Bob", "Johnson"), new Date(1990, 8, 15), null, "67890", new Date(2021, 3, 15)), 2000, "5678", "ACC5678");
    }

    @Test
    void addAccount() {
        bank.addAccount(account1);
        assertEquals(1, bank.getAllAccounts().length);
        assertEquals(account1, bank.getAllAccounts()[0]);

        // Adding account with the same account number should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> bank.addAccount(account1));
    }

    @Test
    void removeAccount() {
        bank.addAccount(account1);
        assertTrue(bank.removeAccount("ACC1234"));
        assertEquals(0, bank.getAllAccounts().length);
    }

    @Test
    void getAllAccounts() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        assertEquals(2, bank.getAllAccounts().length);
        assertTrue(bank.getAllAccounts()[0] == account1 || bank.getAllAccounts()[0] == account2);
        assertTrue(bank.getAllAccounts()[1] == account1 || bank.getAllAccounts()[1] == account2);
    }

    @Test
    void getMaxAccount() {
        assertNull(bank.getMaxAccount());

        bank.addAccount(account1);
        bank.addAccount(account2);

        assertEquals(account2, bank.getMaxAccount());
    }

    @Test
    void getAccountFor() {
        bank.addAccount(account1);
        bank.addAccount(account2);

        assertEquals(account1, bank.getAccountFor("12345"));
        assertEquals(account2, bank.getAccountFor("67890"));
        assertNull(bank.getAccountFor("99999")); // Non-existent client ID
    }

    @Test
    void getCeo() {
        assertEquals(ceo, bank.getCeo());
    }
}
