package ca.bcit.comp2601.bank;

/**
 * The BankClient class represents a client of a bank, extending the Person class.
 *
 * @author Emma, Raaz
 * @version 2024
 */
public class BankClient extends Person
{
    private String clientId;        // Client ID (5 digits)
    private Date dateJoinedTheBank; // Date the client joined the bank

    /**
     * Constructs a BankClient object with the specified name, date of birth, date of death (if applicable),
     * client ID, and date joined the bank.
     *
     * @param name The name of the bank client.
     * @param dateOfBirth The date of birth of the bank client.
     * @param dateOfDeath The date of death of the bank client (null if alive).
     * @param clientId The client ID of the bank client (5 digits).
     * @param dateJoinedTheBank The date the bank client joined the bank.
     */
    public BankClient(final Name name,
                      final Date dateOfBirth,
                      final Date dateOfDeath,
                      final String clientId,
                      final Date dateJoinedTheBank)
    {
        super(name, dateOfBirth, dateOfDeath);

        this.clientId = clientId;
        this.dateJoinedTheBank = dateJoinedTheBank;
    }

    /**
     * Returns the details of the bank client including name, date of birth, date of death (if applicable),
     * client ID, and date joined the bank.
     *
     * @return The details of the bank client as a string.
     */
    @Override
    public String getDetails()
    {
        final StringBuilder details;
        details = new StringBuilder(super.getDetails());

        details.append(" client #").append(clientId).append(" ");
        if (isAlive())
        {
            details.append("(alive)");
        }
        else
        {
            details.append("(died ").append(dateOfDeath.getDayOfWeek(dateOfDeath.getYear(), dateOfDeath.getMonth(), dateOfDeath.getDay())).append(", ")
                    .append(dateOfDeath.getMonth()).append(" ")
                    .append(dateOfDeath.getDay()).append(", ")
                    .append(dateOfDeath.getYear()).append(")");
        }
        details.append(" joined the bank on ").append(dateJoinedTheBank.getDayOfWeek(dateJoinedTheBank.getYear(), dateJoinedTheBank.getMonth(), dateJoinedTheBank.getDay())).append(", ")
                .append(dateJoinedTheBank.getMonth()).append(" ")
                .append(dateJoinedTheBank.getDay()).append(", ")
                .append(dateJoinedTheBank.getYear());
        return details.toString();
    }

    /**
     * Returns the client ID of the bank client.
     *
     * @return The client ID.
     */
    public String getClientId()
    {
        return clientId;
    }

    /**
     * Returns the date the bank client joined the bank.
     *
     * @return The date joined the bank.
     */
    public Date getDateJoinedTheBank()
    {
        return dateJoinedTheBank;
    }

    /**
     * Sets the client ID of the bank client.
     *
     * @param clientId The new client ID.
     */
    public void setClientId(final String clientId)
    {
        this.clientId = clientId;
    }

    /**
     * Sets the date the bank client joined the bank.
     *
     * @param dateJoinedTheBank The new date joined the bank.
     */
    public void setDateJoinedTheBank(final Date dateJoinedTheBank)
    {
        this.dateJoinedTheBank = dateJoinedTheBank;
    }
}
