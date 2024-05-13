package ca.bcit.comp2601.bank;

import java.util.Calendar;

/**
 * The Person class represents a person with a name, date of birth, and date of death (if applicable).
 *
 * @author Emma, Raaz
 * @version 2024
 */
public class Person
{
    private Name name;          // Name of the person
    private Date dateOfBirth;   // Date of birth
    public Date dateOfDeath;   // Date of death (null if the person is alive)
    private static final int ONE_MONTH = 1;

    /**
     * Constructs a Person object with the specified name, date of birth, and date of death.
     *
     * @param name The name of the person.
     * @param dateOfBirth The date of birth of the person.
     * @param dateOfDeath The date of death of the person (null if the person is alive).
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Returns the details of the person including name, date of birth, and date of death (if applicable).
     *
     * @return The details of the person as a String.
     */
    public String getDetails()
    {
        final StringBuilder details;
        details = new StringBuilder();

        details.append(name.getFullName()).append(" ");

        // Check if the person is alive
        if (isAlive()) {
            details.append("(alive)");
        } else {
            // Use Calendar to get the correct day of the week for the date of death
            Calendar deathCalendar = Calendar.getInstance();
            deathCalendar.set(dateOfDeath.getYear(), dateOfDeath.getMonth() - ONE_MONTH, dateOfDeath.getDay());
            int deathDayOfWeek = deathCalendar.get(Calendar.DAY_OF_WEEK);
            String deathDayOfWeekStr = getDayOfWeek(deathDayOfWeek);

            // Append the date of death details
            details.append("(died ").append(deathDayOfWeekStr).append(", ")
                    .append(dateOfDeath.getMonth()).append(" ")
                    .append(dateOfDeath.getDay()).append(", ")
                    .append(dateOfDeath.getYear()).append(")");
        }

        // Use Calendar to get the correct day of the week for the date of birth
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.set(dateOfBirth.getYear(), dateOfBirth.getMonth() - ONE_MONTH, dateOfBirth.getDay());
        int birthDayOfWeek = birthCalendar.get(Calendar.DAY_OF_WEEK);
        String birthDayOfWeekStr = getDayOfWeek(birthDayOfWeek);

        // Append the date of birth details
        details.append(" was born on ").append(birthDayOfWeekStr).append(", ")
                .append(dateOfBirth.getMonth()).append(" ")
                .append(dateOfBirth.getDay()).append(", ")
                .append(dateOfBirth.getYear()).append("!");

        return details.toString();
    }

    /**
     * Returns the day of the week as a string.
     *
     * @param dayOfWeek The day of the week as an integer (Calendar.DAY_OF_WEEK).
     * @return The day of the week as a string.
     */
    private String getDayOfWeek(final int dayOfWeek)
    {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return daysOfWeek[dayOfWeek]; // No need to adjust to start from Sunday (0-indexed)
    }

    /**
     * Checks if the person is alive.
     *
     * @return true if the person is alive, false otherwise.
     */
    public boolean isAlive()
    {
        return dateOfDeath == null;
    }

    /**
     * Returns the name of the person.
     *
     * @return The name object.
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return The date of birth object.
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Returns the date of death of the person.
     *
     * @return The date of death object.
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name.
     */
    public void setName(final Name name)
    {
        this.name = name;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dateOfBirth The new date of birth.
     */
    public void setDateOfBirth(final Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the date of death of the person.
     *
     * @param dateOfDeath The new date of death.
     */
    public void setDateOfDeath(final Date dateOfDeath)
    {
        this.dateOfDeath = dateOfDeath;
    }
}
