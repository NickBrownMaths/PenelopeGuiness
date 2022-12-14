package UIElements.ProjTSI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ActorTest {
    @Test
    public void testConstructor() {
        Actor testActor = new Actor("Joseph", "Bloggington");
        Assertions.assertEquals("Joseph",testActor.getFirstname());
        Assertions.assertEquals("Bloggington",testActor.getLastname());
    }

    @Test
    public void testDefaultConstructor() {
        Actor testActor = new Actor();
        Assertions.assertNotNull(testActor);
    }

    @Test
    public void testSettersGetters() {
        Actor testActor = new Actor("Joseph", "Bloggington");
        Assertions.assertEquals("Joseph",testActor.getFirstname());
        Assertions.assertEquals("Bloggington",testActor.getLastname());

        testActor.setActorid(101);
        Assertions.assertEquals(101,testActor.getActorid());

        testActor.setFirstname("Josephine");
        testActor.setLastname("Bloggsworth");
        Assertions.assertEquals("Josephine",testActor.getFirstname());
        Assertions.assertEquals("Bloggsworth",testActor.getLastname());
    }


}
