package ca.bcit.comp2601.bank;

/**
 * The BankAccount class represents a bank account.
 *
 * @author Emma Lee
 * @version 2024
 */
public class BankAccount
{
    private final BankClient client;      // Client associated with the account
    private double balanceUsd;      // Balance in USD
    private final String pin;             // PIN for accessing the account
    private final String accountNumber;   // Account number (7 letters)
    private static final int AMOUNT_ZERO = 0;

    /**
     * Constructs a BankAccount object with the specified client, balance, PIN, and account number.
     *
     * @param client The bank client associated with the account.
     * @param balanceUsd The initial balance in USD.
     * @param pin The PIN for accessing the account.
     * @param accountNumber The account number (7 letters).
     */
    public BankAccount(final BankClient client,
                       final double balanceUsd,
                       final String pin,
                       final String accountNumber)
    {
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amountUsd The amount to deposit in USD.
     */
    public void deposit(final double amountUsd)
    {
        balanceUsd += amountUsd;
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amountUsd The amount to withdraw in USD.
     * @return true if the withdrawal is successful, false otherwise.
     */
    public boolean withdraw(final double amountUsd)
    {
        if (amountUsd <= AMOUNT_ZERO  || balanceUsd < amountUsd)
        {
            return false; // Reject negative amounts or amounts exceeding the balance
        }
        balanceUsd -= amountUsd;

        return true;
    }

    /**
     * Withdraws the specified amount from the account if the provided PIN matches.
     *
     * @param amountUsd The amount to withdraw in USD.
     * @param pinToMatch The PIN to match.
     * @return true if the withdrawal is successful, false otherwise.
     */
    public boolean withdraw(final double amountUsd, final String pinToMatch)
    {
        if (amountUsd <= AMOUNT_ZERO  || !pin.equals(pinToMatch) || balanceUsd < amountUsd)
        {
            return false;
        }
        balanceUsd -= amountUsd;
        return true;
    }

    /**
     * Returns the client associated with the account.
     *
     * @return The bank client object.
     */
    public BankClient getClient()
    {
        return client;
    }

    /**
     * Returns the balance in USD.
     *
     * @return The balance in USD.
     */
    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     * Returns the PIN for accessing the account.
     *
     * @return The PIN.
     */
    public String getPin()
    {
        return pin;
    }

    /**
     * Returns the account number.
     *
     * @return The account number.
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }
}

