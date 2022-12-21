package UIElements.ProjTSI;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ActorTest {
    @Test
    public void testConstructor() {
        Actor testActor = new Actor("Joseph", "Bloggington");
        Assertions.assertEquals("Joseph",testActor.getFirstname());
        Assertions.assertEquals("Bloggington",testActor.getLastname());


        testActor.setActorid(101);
        Assertions.assertEquals(101,testActor.getActorid());

    }
}
