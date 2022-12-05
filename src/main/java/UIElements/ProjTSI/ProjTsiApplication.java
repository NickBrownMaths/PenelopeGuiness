package UIElements.ProjTSI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class ProjTsiApplication {
	@Autowired
	private ActorRepository actorRepository ;
	@Autowired
	private FilmRepository filmRepository ;
	@Autowired
	private FilmActorRepository filmActorRepository ;

	public ProjTsiApplication(ActorRepository ar) {
		actorRepository = ar;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjTsiApplication.class, args);
	}

	@GetMapping("/allactors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}
	@GetMapping("/getActor/{actorID}")
	public @ResponseBody Optional<Actor> getActorByID(@PathVariable("actorID") int actorID) {
		Optional<Actor> actor = actorRepository.findById(actorID);
		return actor;
	}
	@GetMapping("/findA")
	public @ResponseBody Iterable<Actor> getActorsA() {
		return actorRepository.findAllStartsA();
	}
	@PutMapping("/setActor/{actorID}")
	public Actor replaceActor(@RequestBody Actor newActor, @PathVariable("actorID") int actorID) {
		return actorRepository.findById(actorID)
				.map(actor -> {
					actor.setFirstname(newActor.getFirstname());
					actor.setLastname(newActor.getLastname());
					return actorRepository.save(actor);
				})
				.orElseGet(() -> {
					newActor.setActorid(actorID);
					return actorRepository.save(newActor);
				});
	}
	@PostMapping("/addActor")
	public Actor addActor(@RequestBody Actor newActor) {
		return actorRepository.save(newActor) ;
	}
	@DeleteMapping("/deleteActorByID/{actorID}")
	public void delete(@PathVariable("actorID") int actorID) {
		actorRepository.deleteById(actorID);
	}

	@GetMapping("/allfilms")
	public @ResponseBody Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@GetMapping("/allAF")
	public @ResponseBody Iterable<Actor> getAllAF() {
		return actorRepository.findAllActorsFilms();
	}


}
