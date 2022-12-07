package UIElements.ProjTSI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleActorStepDef {
    private ScenarioContext context;

    public ShowSingleActorStepDef(ScenarioContext ctxt) {
        this.context = ctxt ;
    }

    @When("I request that actors details")
    public void i_request_that_actors_detail() {
        context.currentActor = context.actorRepository.findById(context.actorID)
                .orElseThrow(() -> new ResourceAccessException("Actor with id does not exist " + context.actorID));
        Assertions.assertNotEquals(null, context.currentActor, "Actor was not retrieved");
    }

    @Then("The webpage should show the actors {string} and {string}")
    public void the_webpage_should_show_the_actors_firstname_and_lastname(String firstname, String lastname) {
        String correctDetails = firstname + " " + lastname;
        String testDetails = context.currentActor.getFirstname() + " " + context.currentActor.getLastname() ;
        Assertions.assertEquals(correctDetails, testDetails, "Incorrect Details");
    }
}
