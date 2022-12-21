package UIElements.ProjTSI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FilmActorTest {
    @Test
    public void testConstructor(){
        FilmActor testFilmActor = new FilmActor();
        Assertions.assertNotNull(testFilmActor);
    }

    @Test
    public void testGettersSetters() {
        FilmActor testFilmActor = new FilmActor();
        Actor testActor = new Actor("George", "Bloyggs");
        testActor.setActorid(15);
        Film testFilm = new Film("AGoodFilm",29);

        testFilmActor.setActor(testActor);
        testFilmActor.setFilm(testFilm);

        Assertions.assertEquals(15, testFilmActor.getActor().getActorid());
        Assertions.assertEquals(29, testFilmActor.getFilm().getFilmid());
    }

}
