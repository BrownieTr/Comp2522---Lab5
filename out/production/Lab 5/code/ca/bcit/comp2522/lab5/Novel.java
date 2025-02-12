package ca.bcit.comp2522.lab5;

public class Novel implements Comparable<Novel>
{
    private final int MAX_YEAR = 2025;
    private final int MIN_YEAR = 1700;

    private final String title;
    private final String author;
    private final int publishedYear;

    public Novel(final String title, final String author, final int publishedYear)
    {
        validateString(title);
        validateString(author);
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    private void validateString(final String string)
    {
        if(string == null || string.isEmpty())
        {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
    }

    private void validateYear(final int year)
    {
        if(year <= MIN_YEAR || year > MAX_YEAR)
        {
            throw new IllegalArgumentException("Year must be between " + MIN_YEAR + " and " + MAX_YEAR);
        }
    }

    protected String getTitle()
    {
        return title;
    }

    protected String getAuthor()
    {
        return author;
    }

    protected int getPublishedYear()
    {
        return publishedYear;
    }

    @Override
    public int compareTo(Novel o)
    {
        return title.compareTo(o.title);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + title + "\n");
        sb.append("Author: " + author + "\n");
        sb.append("Year Published: " + publishedYear + "\n");
        return sb.toString();
    }
}
