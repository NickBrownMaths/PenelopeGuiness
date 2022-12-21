package UIElements.ProjTSI;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilmActorTest {
    @Test
    public void testConstructor(){
        FilmActor testFilmActor = new FilmActor();
        Assertions.assertNotNull(testFilmActor);
    }

}
