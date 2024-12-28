package collections;

    /**
     * Test the movie object and it's methods
     * 
     * @author Navanit Krisha Satish Kumar
     * @version 2024.09.13
     *
     */
public class MovieTest extends student.TestCase

{
    private Movie movie;
    private Movie nullMovie;
    private Movie diffMovie;
    private Movie diffVars;
    private String diffObj = "Different Object";

    /**
    * Set up the Movie tests
    */
    public void setUp() { 
    // Movie 1
        movie = new Movie("Spiderman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);
        
    // Different Movie
        diffMovie = new Movie("Cars");
        diffMovie.setGenre("Animation");
        diffMovie.setYear(2006);
        diffMovie.setRating(8);
        
    // Same Title different Variables Movie
        diffVars = new Movie("Spiderman");
        diffVars.setYear(1999);
        diffVars.setGenre("Comic Book Movie");
        diffVars.setRating(2);

    }
    // start your test cases below
    
    /**
     * test Movie getTitle method
     */
    public void testGetGenre() {
        assertEquals("Action", movie.getGenre());
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());
    }
    
    /**
     * test Movie getYear method
     */
    public void testGetYear() {
        assertEquals(2002, movie.getYear());
        movie.setYear(2005);
        assertEquals(2005, movie.getYear());
    }
    
    /**
     * test Movie getTitle method
     */
    public void testGetTitle() {
        assertEquals("Spiderman", movie.getTitle());
    }
    
    /**
     * test Movie getRating method
     */
    public void testGetRating() {
        assertEquals(4, movie.getRating());
        movie.setRating(5);
        assertEquals(5, movie.getRating());
    }
    
    /**
     * test Movie Equals method
     */
    public void testEquals() {
        assertTrue(movie.equals(movie));
        assertFalse(movie.equals(nullMovie));
        assertFalse(movie.equals(diffMovie));
        assertTrue(movie.equals(diffVars));
        assertFalse(movie.equals(diffObj));
    }

}