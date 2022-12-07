package UIElements.ProjTSI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleFilmStepDef {
    private ScenarioContext context;

    public ShowSingleFilmStepDef(ScenarioContext ctxt) {
        this.context = ctxt ;
    }

    @Given("a film exists with id {int}")
    public void a_film_exists_with_id(int id) {
        context.filmID = id;
        context.filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Film with id does not exist " + context.filmID));
    }

    @When("I request that films details")
    public void i_request_that_films_detail() {
        context.currentFilm = context.filmRepository.findById(context.filmID)
                .orElseThrow(() -> new ResourceAccessException("Film with id does not exist " + context.filmID));
        Assertions.assertNotEquals(null, context.currentFilm, "Film was not retrieved");
    }

    @Then("The webpage should show the films {string}")
    public void the_webpage_should_show_the_films_title(String title) {
        String correctDetails = title;
        String testDetails = context.currentFilm.getTitle();
        Assertions.assertEquals(correctDetails, testDetails, "Incorrect Details");
    }
}
