package ca.bcit.comp2522.lab5;

public class Novel
{
    private final String title;
    private final String author;
    private final Date publishedYear;

    public Novel(final String title, final String author, final Date publishedYear)
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

    protected String getTitle()
    {
        return title;
    }

    protected String getAuthor()
    {
        return author;
    }

    protected Date getPublishedYear()
    {
        return publishedYear;
    }
}
