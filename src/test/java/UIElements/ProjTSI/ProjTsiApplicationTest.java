package UIElements.ProjTSI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjTsiApplicationTest extends ProjTsiApplication {

    @Mock
    private ActorRepository testAR;

    @Mock
    private Iterable<Actor> testActorIter;

    @Test
    public void testDefaultConstructor() {
        ProjTsiApplication App = new ProjTsiApplication();
        Assertions.assertNotNull(App);
    }

    @Test
    public void testConstructor() {
        ProjTsiApplication App = new ProjTsiApplication(testAR);
        Assertions.assertNotNull(App);
    }

    @Test
    public void testGetAllActors(){
    }
}
