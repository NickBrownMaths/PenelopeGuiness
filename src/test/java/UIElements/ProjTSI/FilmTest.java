package UIElements.ProjTSI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FilmTest {
    @Test
    public void testConstructor() {
        Film testFilm = new Film("AGoodFilm", 101);
        Assertions.assertEquals("AGoodFilm",testFilm.getTitle());
        Assertions.assertEquals(101,testFilm.getFilmid());
    }

    @Test
    public void testSetterGetters() {
        Film testFilm = new Film("AGoodFilm", 101);
        testFilm.setFilmid(99);
        testFilm.setTitle("ABadFilm");
        Assertions.assertEquals("ABadFilm",testFilm.getTitle());
        Assertions.assertEquals(99,testFilm.getFilmid());
    }

}
