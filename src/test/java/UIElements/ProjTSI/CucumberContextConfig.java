package UIElements.ProjTSI;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = ProjTsiApplication.class)
public class CucumberContextConfig {
}
