package ca.bcit.comp2601.bank;

/**
 * The Name class represents a person's first and last name.
 *
 * @author Emma, Raaz
 * @version 2024
 */
public class Name
{
    private final String first; // First name
    private final String last;  // Last name
    private static final int CHARACTER_INDEX_ZERO = 0;
    private static final int MAX_NAME_LENGTH = 45;

    /**
     * Constructs a Name object with the specified first and last name.
     *
     * @param first The first name.
     * @param last  The last name.
     */
    public Name(final String first, final String last)
    {
        if (first == null || last == null || first.isBlank() || last.isBlank())
        {
            throw new IllegalArgumentException("First and last names must not be null or blank.");
        }
        if (first.length() > MAX_NAME_LENGTH || last.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException("First and last names must not exceed 45 characters.");
        }
        if (first.toLowerCase().contains("admin") || last.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Names must not contain the word 'admin' (case insensitive).");
        }

        this.first = first;
        this.last = last;
    }

    /**
     * Returns the initials of the person's name.
     *
     * @return The initials as a String.
     */
    public String getInitials()
    {
        return Character.toString(first.charAt(CHARACTER_INDEX_ZERO )).toUpperCase() + "." +
                Character.toString(last.charAt(CHARACTER_INDEX_ZERO )).toUpperCase() + ".";
    }

    /**
     * Returns the full name of the person.
     *
     * @return The full name as a String.
     */
    public String getFullName()
    {
        return first + " " + last;
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name as a String.
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Returns the last name of the person.
     *
     * @return The last name as a String.
     */
    public String getLast()
    {
        return last;
    }
}
