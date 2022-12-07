package UIElements.ProjTSI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowAllFilmFromActorStepDef {
    Iterable<Film> currentFilmList;
    private ScenarioContext context;

    public ShowAllFilmFromActorStepDef(ScenarioContext ctxt) {
        this.context = ctxt ;
    }

    @When("I request all {int} films from that actor")
    public void I_request_all_films_from_that_actor(int expdFilms) {
        currentFilmList = context.filmRepository.findFilmFromActor(context.actorID);
        int numFilms = 0;
        for (Film f : currentFilmList) {
            ++numFilms;
        }
        Assertions.assertEquals(expdFilms, numFilms, "Got wrong number of films");
    }

    @Then("The webpage should show there are {int} films with titles: {string}")
    public void the_webpage_should_show_the_films_title_string(int num, String titleString) {
        String correctDetails = titleString;
        String testDetails = "" ;
        for (Film f : currentFilmList) {
            testDetails = testDetails + f.getTitle();
        }
        Assertions.assertEquals(correctDetails, testDetails, "Incorrect Details");
    }
}
