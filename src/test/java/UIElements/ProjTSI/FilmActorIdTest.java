package UIElements.ProjTSI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorIdTest {

    @Test
    public void testConstructor() {
        FilmActorId testFilmActorId = new FilmActorId(44, 55);
        Assertions.assertNotNull(testFilmActorId);
    }

    @Test
    public void testGetters() {
        FilmActorId testFilmActorId = new FilmActorId(44, 55);
        Assertions.assertEquals(44, testFilmActorId.getFilmid());
        Assertions.assertEquals(55, testFilmActorId.getActorid());
    }
}
