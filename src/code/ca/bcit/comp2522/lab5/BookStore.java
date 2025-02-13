package ca.bcit.comp2522.lab5;

import java.util.*;

/**
 * BookStore class representing a collection of novels.
 * Provides methods to manipulate and retrieve novel data.
 *
 * @author Brownie, Daryan
 * @version 1.0
 */
public class BookStore
{
    // Constants for decades and other fixed values
    private static final List<Integer> DECADES = List.of(
            1700, 1710, 1720, 1730, 1740, 1750, 1760, 1770, 1780, 1790,
            1800, 1810, 1820, 1830, 1840, 1850, 1860, 1870, 1880, 1890,
            1900, 1910, 1920, 1930, 1940, 1950, 1960, 1970, 1980, 1990,
            2000, 2010, 2020 );
    private final int MIN_NUM_IN_A_DECADE = 0;
    private final int MAX_NUM_IN_A_DECADE = 9;
    private final int MAP_CAPACITY = 85;
    private final int PERCENT_CALC = 100;

    private final String bookStoreName; // Name of the bookstore
    private final List<Novel> novels = new ArrayList<>(); // List of novels
    private final Map<String, Novel> map = new HashMap<>(MAP_CAPACITY); // Map of novels

    /**
     * Constructor to initialize BookStore with a name, novels list, and map.
     * @param bookStoreName the name of the bookstore
     */
    public BookStore(final String bookStoreName)
    {
        validateString(bookStoreName);
        this.bookStoreName = bookStoreName;
        addNovelToList();
        addNovelToMap(novels);
    }

    // Method to validate non-null, non-empty strings
    private void validateString(final String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
    }

    // Method to validate a decade is within the predefined list
    private void validateDecade(final int decade)
    {
        for (int eachDecade : DECADES)
        {
            if (decade == eachDecade)
            {
                return;
            }
        }
        throw new IllegalArgumentException("Invalid decade!");
    }

    // Adds novel data to the novels list
    private void addNovelToList()
    {
        novels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        novels.add(new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        novels.add(new Novel("American Pastoral", "Philip Roth", 1997));
        novels.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        novels.add(new Novel("Animal Farm", "George Orwell", 1946));
        novels.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        novels.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        novels.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        novels.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        novels.add(new Novel("Atonement", "Ian McEwan", 2002));
        novels.add(new Novel("Beloved", "Toni Morrison", 1987));
        novels.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        novels.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        novels.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        novels.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        novels.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        novels.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        novels.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        novels.add(new Novel("Catch-22", "Joseph Heller", 1961));
        novels.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        novels.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        novels.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        novels.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        novels.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        novels.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        novels.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        novels.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        novels.add(new Novel("A Death in the Family", "James Agee", 1958));
        novels.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        novels.add(new Novel("Deliverance", "James Dickey", 1970));
        novels.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        novels.add(new Novel("Falconer", "John Cheever", 1977));
        novels.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        novels.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        novels.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        novels.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        novels.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        novels.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        novels.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        novels.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        novels.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        novels.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        novels.add(new Novel("Herzog", "Saul Bellow", 1964));
        novels.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        novels.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        novels.add(new Novel("I, Claudius", "Robert Graves", 1934));
        novels.add(new Novel("Infinite Jest David", "Foster Wallace", 1996));
        novels.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        novels.add(new Novel("Light in August", "William Faulkner", 1932));
        novels.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        novels.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        novels.add(new Novel("Lord of the Flies", "William Golding", 1954));
        novels.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        novels.add(new Novel("Loving", "Henry Green", 1945));
        novels.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        novels.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        novels.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        novels.add(new Novel("Money", "Martin Amis", 1984));
        novels.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        novels.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        novels.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        novels.add(new Novel("Native Son", "Richard Wright", 1940));
        novels.add(new Novel("Neuromancer", "William Gibson", 1984));
        novels.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        novels.add(new Novel("1984", "George Orwell", 1948));
        novels.add(new Novel("On the Road", "Jack Kerouac", 1957));
        novels.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        novels.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        novels.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        novels.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        novels.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        novels.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        novels.add(new Novel("Possession", "A.S. Byatt", 1990));
        novels.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        novels.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        novels.add(new Novel("Rabbit, Run", "John Updike", 1960));
        novels.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        novels.add(new Novel("The Recognitions", "William Gaddis", 1955));
        novels.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        novels.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        novels.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        novels.add(new Novel("Slaughterhouse-Five Kurt", "Vonnegut", 1969));
        novels.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        novels.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        novels.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        novels.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        novels.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        novels.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        novels.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        novels.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        novels.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        novels.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        novels.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        novels.add(new Novel("Ubik", "Philip K. Dick", 1969));
        novels.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        novels.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        novels.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        novels.add(new Novel("White Noise", "Don DeLillo", 1985));
        novels.add(new Novel("White Teeth", "Zadie Smith", 2000));
        novels.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));
    }

    // Adds novels from a list to the map
    private void addNovelToMap(final List<Novel> novels)
    {
        for (Novel novel : novels)
        {
            map.put(novel.getTitle(), novel);
        }
    }

    /**
     * Gets the bookstore name.
     * @return the bookstore name
     */
    protected String getBookStoreName()
    {
        return bookStoreName;
    }

    /**
     * Gets the list of novels.
     * @return the list of novels
     */
    protected List<Novel> getNovels()
    {
        return novels;
    }

    /**
     * Gets the map of novels.
     * @return the map of novels
     */
    protected Map<String, Novel> getMap()
    {
        return map;
    }

    /**
     * Prints all book titles in uppercase.
     */
    public void printAllTitles()
    {
        System.out.println("Titles:");
        for (Novel novel : novels)
        {
            System.out.println(novel.getTitle().strip().toUpperCase());
        }
    }

    /**
     * Prints book titles containing a specific string.
     * @param title The string to search for in book titles.
     */
    public void printBookTitle(final String title)
    {
        if (title == null || title.isEmpty())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        System.out.println("Book Title: " + title);
        System.out.println("Result: ");
        for (Novel novel : novels)
        {
            if (novel.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Prints book titles in alphabetical order.
     */
    public void printTitlesInAlphaOrder()
    {
        System.out.println("Titles in Alphabetical order:");
        novels.sort(null);
        for (Novel novel : novels)
        {
            System.out.println(novel.getTitle());
        }
    }

    /**
     * Prints book titles grouped by decade.
     * @param decade The decade for which book titles should be printed.
     */
    public void printGroupByDecade(final int decade)
    {
        validateDecade(decade);
        System.out.println("Book Titles Group by decade " + decade + "s: ");
        for (Novel novel : novels)
        {
            int yearDifference = novel.getPublishedYear() - decade;
            if (yearDifference >= MIN_NUM_IN_A_DECADE && yearDifference <= MAX_NUM_IN_A_DECADE)
            {
                System.out.println(novel.getTitle() +  " - " + novel.getPublishedYear());
            }
        }
    }

    /**
     * Finds and prints the longest book title.
     */
    public void getLongest()
    {
        Novel longest = novels.getFirst();
        for (int i = 1; i < novels.size(); i++)
        {
            if (novels.get(i).getTitle().strip().length() > longest.getTitle().strip().length())
            {
                longest = novels.get(i);
            }
        }
        System.out.println("Longest Title: " + longest.getTitle());
    }

    /**
     * Returns a list of novels with titles of specified length.
     * @param titleLength The length of the book titles to retrieve.
     * @return A list of novels with titles of the specified length.
     */
    public List<Novel> getBooksThisLength(final int titleLength) {

        List<Novel> books = new ArrayList<>();
        for (Novel novel : novels) {
            if (novel.getTitle().length() == titleLength) {
                books.add(novel);
            }
        }
        return books;

    }

    /**
     * Returns the oldest book in the collection.
     * @return The oldest book in the collection.
     */
    public Novel getOldestBook() {
        Novel oldest = novels.get(0);
        for (Novel novel : novels) {
            if (novel.getPublishedYear() < novel.getPublishedYear()) {
                oldest = novel;
            }
        }
        return oldest;
    }

    /**
     * Calculates the percentage of books written between specified years.
     * @param first The starting year.
     * @param last The ending year.
     * @return The percentage of books written between the specified years.
     */
    public double whichPercentWrittenBetween(final int first, final int last) {
        int count = 0;
        for (Novel novel : novels) {
            if (novel.getPublishedYear() < first || novel.getPublishedYear() > last) {
                count++;
            }
        }
        return (double) count / novels.size() * PERCENT_CALC;
    }

    /**
     * Counts books containing a specific word in their title.
     * @param word The word to search for in book titles.
     * @return True if there are books containing the specified word, false otherwise.
     */
    public boolean howManyBooksContain(final String word) {
        int count = 0;
        for (Novel novel : novels) {
            if (novel.getTitle().toLowerCase().contains(word.toLowerCase())) {
                count++;
            }
        }
        return count >= 0;
    }

    /**
     * Checks if there is a book written in a specific year.
     * @param year The year to check for a written book.
     * @return True if there is a book written in the specified year, false otherwise.
     */
    public boolean isThereABookWrittenBetween(final int year) {

        for (Novel novel : novels) {
            if (novel.getPublishedYear() == year) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method to demonstrate BookStore functionalities.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        // Part 1
        final BookStore bookstore;
        final Novel oldest;
        final List<Novel> fifteenCharTitles;

        bookstore = new BookStore("Classic Novels Collection");
        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();
        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");
        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();
        System.out.println("\nBooks from the 2000s:");
        bookstore.printGroupByDecade(2000);
        System.out.println("\nLongest Book Title:");
        bookstore.getLongest();
        System.out.println("\nIs there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenBetween(1950));
        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));
        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");
        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " +
                oldest.getYearPublished());
        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(15);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));

        // Part 2
        final Iterator<String> title;
        final Map<String, Novel> map;
        final Set<String> KeySet;
        final List<String> KeyList;

        map = bookstore.getMap();
        KeySet = map.keySet();
        title = KeySet.iterator();

        System.out.println("\nTitles in Map:");
        while (title.hasNext())
        {
            final String key = title.next();
            System.out.println(key);
            if (key.strip().toLowerCase().contains("the"))
            {
                title.remove();
                map.remove(key);
            }

        }

        KeyList = new ArrayList<>(KeySet);
        Collections.sort(KeyList);
        System.out.println("\nNovels in Map:");
        for(String s : KeyList)
        {
            System.out.println(map.get(s).toString());
        }
    }
}
