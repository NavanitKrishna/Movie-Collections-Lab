package collections;

import java.util.NoSuchElementException;

    /**
     * Test the NetvidsDatabase Class and it's methods
     * 
     * @author Navanit Krisha Satish Kumar
     * @version 2024.09.13
     */
public class NetvidsDatabaseTest extends student.TestCase {

    private NetvidsDatabase netvids;  
    private Movie movie;
    private Movie movie1;
    private Movie nullMovie;
    
    /**
      * Set up the NetvidsDatabase tests
      */
    public void setUp()

    {

        netvids = new NetvidsDatabase();
        // First Movie
        movie = new Movie("Spiderman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);
        // Second Movie
        movie1 = new Movie("Cars");
        movie1.setGenre("Animation");
        movie1.setYear(2006);
        movie1.setRating(8);
    }

    /**
     * Tests NetvidDatabase addMovie method
     */
    public void testAddMovie() {
        assertTrue(netvids.addMovie(movie));
        assertFalse(netvids.addMovie(movie));
    }

    /**
     * Tests NetvidDatabase isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(netvids.isEmpty());
        netvids.addMovie(movie);
        assertFalse(netvids.isEmpty());
    }

    /**
     * Tests NetvidDatabase testContains method
     */
    public void testContains() {
        assertFalse(netvids.contains(movie));
        netvids.addMovie(movie);
        assertTrue(netvids.contains(movie));
        assertFalse(netvids.contains(movie1));
    }

    /**
     * Tests NetvidDatabase testSize method
     */
    public void testSize() {
        // testing size after adding
        assertEquals(0, netvids.size(), 0.01);
        netvids.addMovie(movie);
        assertEquals(1, netvids.size(), 0.01);
        netvids.addMovie(movie1);
        assertEquals(2, netvids.size(), 0.01);

        // testing size after duplicate
        netvids.addMovie(movie);
        assertEquals(2, netvids.size(), 0.01);

        // testing size after removing
        netvids.remove(movie1);
        assertEquals(1, netvids.size(), 0.01);
    }

    /**
     * Tests NetvidDatabase endCapacity method
     */
    public void testExpandCapacity() {
        assertEquals(0, netvids.size(), 0.01);
        assertEquals(10, netvids.capacity(), 0.01);
        for (int i = 0; i <= 10; i++) {
            netvids.addMovie(new Movie("LoopMovies" + i));
        }
        assertEquals(11, netvids.size(), 0.01);
        assertEquals(20, netvids.capacity(), 0.01);
    }

    /**
     * Tests NetvidDatabase testRemove method
     */
    public void testRemove() {
        netvids.addMovie(this.movie);
        netvids.addMovie(this.movie1);
        assertEquals(2, netvids.size());
        assertTrue(netvids.remove(this.movie).equals(this.movie));
        assertEquals(1, netvids.size());
        assertFalse(netvids.contains(this.movie));

        // For Illegal argument exceptions
        Exception qNull = null;
        try {
            netvids.remove(nullMovie);
        }
        catch (IllegalArgumentException x) {
            qNull = x;
        }
        // For no element exceptions
        qNull = null;
        try {
            netvids.remove(this.movie);
        }
        catch (NoSuchElementException x) {
            qNull = x;
        }
        assertNotNull(qNull);
    }
}


