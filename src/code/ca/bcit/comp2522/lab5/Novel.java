package ca.bcit.comp2522.lab5;

/**
 * Represents a Novel with a title, author, and published year.
 * Implements Comparable interface to allow comparison based on title.
 *
 * @author Brownie , Daryan
 * @version 1.0
 */
public class Novel implements Comparable<Novel> {

    private final int MAX_YEAR = 2025; // Maximum allowed publication year
    private final int MIN_YEAR = 1700; // Minimum allowed publication year

    private final String title; // Title of the novel
    private final String author; // Author of the novel
    private final int publishedYear; // Year the novel was published

    /**
     * Constructs a Novel object with the given title, author, and published year.
     * @param title the title of the novel
     * @param author the author of the novel
     * @param publishedYear the year the novel was published
     */
    public Novel(final String title, final String author, final int publishedYear) {
        validateString(title); // Validate title
        validateString(author); // Validate author
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    /**
     * Validates that a string is not null or empty.
     * @param string the string to validate
     * @throws IllegalArgumentException if the string is null or empty
     */
    private void validateString(final String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
    }

    /**
     * Validates that the year is within the valid range.
     * @param year the year to validate
     * @throws IllegalArgumentException if the year is out of the valid range
     */
    private void validateYear(final int year) {
        if (year <= MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Year must be between " + MIN_YEAR + " and " + MAX_YEAR);
        }
    }

    /**
     * Gets the title of the novel.
     * @return the title of the novel
     */
    protected String getTitle() {
        return title;
    }

    /**
     * Gets the author of the novel.
     * @return the author of the novel
     */
    protected String getAuthor() {
        return author;
    }

    /**
     * Gets the year the novel was published.
     * @return the published year
     */
    protected int getPublishedYear() {
        return publishedYear;
    }

    /**
     * Returns the author's name in a formatted string.
     * @return formatted author name
     */
    protected String getAuthorName() {
        return String.format("Author: %s", author);
    }

    /**
     * Returns the published year in a formatted string.
     * @return formatted published year
     */
    protected String getYearPublished() {
        return String.format("Year Published: %s", publishedYear);
    }

    /**
     * Compares this Novel object to another based on title.
     * @param o the other Novel object to compare to
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Novel o) {
        return title.compareTo(o.title);
    }

    /**
     * Returns a string representation of the Novel object.
     * @return string representation of the novel
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Author: ").append(author).append("\n");
        sb.append("Year Published: ").append(publishedYear).append("\n");
        return sb.toString();
    }
}
