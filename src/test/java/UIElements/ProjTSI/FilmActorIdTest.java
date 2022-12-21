package UIElements.ProjTSI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorIdTest {

    @Test
    public void testEmptyConstructor() {
        FilmActorId testFilmActorId = new FilmActorId();
        Assertions.assertNotNull(testFilmActorId);
    }

    @Test
    public void testConstructor() {
        FilmActorId testFilmActorId = new FilmActorId(44, 55);
        Assertions.assertEquals(44, testFilmActorId.getFilmid());
        Assertions.assertEquals(55, testFilmActorId.getActorid());
    }

    @Test
    public void testEquals() {
        FilmActorId testFilmActorId1 = new FilmActorId(44, 55);
        FilmActorId testFilmActorId2 = new FilmActorId(44, 55);
        FilmActorId testFilmActorId3 = new FilmActorId(33, 55);
        FilmActorId testFilmActorId4 = new FilmActorId(33, 66);
        FilmActorId testFilmActorId5 = new FilmActorId(33, 55);
        Assertions.assertTrue(testFilmActorId1.equals(testFilmActorId1));
        Assertions.assertTrue(testFilmActorId1.equals(testFilmActorId2));
        Assertions.assertFalse(testFilmActorId1.equals(testFilmActorId3));
        Assertions.assertFalse(testFilmActorId1.equals(testFilmActorId4));
        Assertions.assertFalse(testFilmActorId1.equals(testFilmActorId5));
    }

    @Test
    public void testHashCode() {
        FilmActorId testFilmActorId1 = new FilmActorId(44, 55);
        Assertions.assertTrue(testFilmActorId1 == testFilmActorId1);
        Assertions.assertTrue(testFilmActorId1.hashCode() == testFilmActorId1.hashCode());
    }

}
