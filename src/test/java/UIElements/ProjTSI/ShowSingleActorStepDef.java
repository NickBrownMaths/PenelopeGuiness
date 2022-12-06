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
    @Autowired
    ActorRepository actorRepository;

    int actorid;
    Actor currentActor;

    @Given("an actor exists with id {int}")
    public void an_actor_exists_with_id(int id) {
        actorid = id;
        this.actorRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Actor with id does not exist " + actorid));
    }

    @When("I request that actors details")
    public void i_request_that_actors_detail() {
        currentActor = this.actorRepository.findById(actorid)
                .orElseThrow(() -> new ResourceAccessException("Actor with id does not exist " + actorid));
        Assertions.assertNotEquals(null, currentActor, "Actor was not retrieved");
    }

    @Then("The webpage should show the actors {string} and {string}")
    public void the_webpage_should_show_the_actors_firstname_and_lastname(String firstname, String lastname) {
        String correctDetails = firstname + " " + lastname;
        String testDetails = currentActor.getFirstname() + " " + currentActor.getLastname() ;
        Assertions.assertEquals(correctDetails, testDetails, "Incorrect Details");
    }
}
