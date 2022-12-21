package UIElements.ProjTSI;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilmTest {
    @Test
    public void testConstructor() {
        Film testFilm = new Film("AGoodFilm", 101);
        Assertions.assertEquals("AGoodFilm",testFilm.getTitle());
        Assertions.assertEquals(101,testFilm.getFilmid());
    }
}
