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
        Assertions.assertEquals(testFilmActorId1,testFilmActorId1);
        Assertions.assertEquals(testFilmActorId1,testFilmActorId2);
        Assertions.assertNotEquals(testFilmActorId1,testFilmActorId3);
        Assertions.assertNotEquals(testFilmActorId1,testFilmActorId4);
        Assertions.assertNotEquals(testFilmActorId1,testFilmActorId5);
    }

    @Test
    public void testHashCode() {
        FilmActorId testFilmActorId1 = new FilmActorId(44, 55);
        Assertions.assertSame(testFilmActorId1, testFilmActorId1);
        Assertions.assertEquals(testFilmActorId1.hashCode(), testFilmActorId1.hashCode());
    }

    @Test
    public void testEqualsIfNull() {
        FilmActorId testFilmActorId1 = new FilmActorId(44, 55);
        Assertions.assertNotEquals(testFilmActorId1, null);
        Assertions.assertNotEquals(null, testFilmActorId1);
    }

}
