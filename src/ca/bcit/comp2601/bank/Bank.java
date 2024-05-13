package ca.bcit.comp2601.bank;

import java.util.ArrayList;

/**
 * The Bank class represents a bank that manages a list of bank accounts.
 *
 * @author Emma, Raaz
 * @version 2024
 */
public class Bank
{
    private final ArrayList<BankAccount> accounts; // List of bank accounts
    private final Person ceo; // CEO of the bank
    private static final int POSITION_ZERO = 0;

    /**
     * Constructs a Bank object with an empty list of bank accounts and sets the CEO.
     *
     * @param ceo The CEO of the bank.
     */
    public Bank(final Person ceo)
    {
        this.accounts = new ArrayList<>();
        this.ceo = ceo;
    }

    /**
     * Adds a new bank account to the bank.
     *
     * @param newAccount The new bank account to add.
     * @throws IllegalArgumentException if an account with the same account number already exists.
     */
    public void addAccount(final BankAccount newAccount)
    {
        for (final BankAccount account : accounts)
        {
            if (account.getAccountNumber().equals(newAccount.getAccountNumber()))
            {
                throw new IllegalArgumentException("Account with the same account number already exists.");
            }
        }
        accounts.add(newAccount);
    }

    /**
     * Removes the bank account with the specified account number.
     *
     * @param accountNumber The account number of the bank account to remove.
     * @return true if the account was removed successfully, false otherwise.
     */
    public boolean removeAccount(final String accountNumber)
    {
        for (final BankAccount account : accounts)
        {
            if (account.getAccountNumber().equals(accountNumber))
            {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array containing all the bank accounts.
     *
     * @return An array of bank accounts.
     */
    public BankAccount[] getAllAccounts()
    {
        return accounts.toArray(new BankAccount[POSITION_ZERO]);
    }

    /**
     * Returns the bank account with the highest balance.
     *
     * @return The bank account with the highest balance.
     */
    public BankAccount getMaxAccount()
    {
        if (accounts.isEmpty())
        {
            return null;
        }

        BankAccount maxAccount;
        maxAccount = accounts.get(POSITION_ZERO);

        for (final BankAccount account : accounts)
        {
            if (account.getBalanceUsd() > maxAccount.getBalanceUsd())
            {
                maxAccount = account;
            }
        }
        return maxAccount;
    }

    /**
     * Returns the bank account associated with the specified client ID.
     *
     * @param clientId The client ID of the bank client.
     * @return The bank account associated with the client ID, or null if not found.
     */
    public BankAccount getAccountFor(final String clientId)
    {
        for (final BankAccount account : accounts)
        {
            if (account.getClient().getClientId().equals(clientId))
            {
                return account;
            }
        }
        return null;
    }

    /**
     * Returns the CEO of the bank.
     *
     * @return The CEO of the bank.
     */
    public Person getCeo()
    {
        return ceo;
    }
}
