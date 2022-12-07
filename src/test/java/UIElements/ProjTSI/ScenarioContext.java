package UIElements.ProjTSI;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

public class ScenarioContext {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;

    Actor currentActor;
    Film currentFilm;

    int actorID ;
    int filmID ;

    @Given("an actor exists with id {int}")
    public void an_actor_exists_with_id(int id) {
        actorID = id;
        this.filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Actor with id does not exist " + actorID));
    }
}
