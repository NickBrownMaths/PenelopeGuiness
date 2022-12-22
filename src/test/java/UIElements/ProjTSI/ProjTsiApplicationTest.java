package UIElements.ProjTSI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjTsiApplicationTest extends ProjTsiApplication {

  @Test
  public void testMain() {
      ProjTsiApplication App = new ProjTsiApplication();
      Assertions.assertNotNull(App);
  }



}
