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

	// Get all actors in a film, and all films from an actor
	@GetMapping("/allAfromF/{filmID}")
	public @ResponseBody Iterable<Actor> getActorFromFilm(@PathVariable("filmID") int fid) {
		return actorRepository.findActorFromFilm(fid);
	}
	@GetMapping("/allFfromA/{actorID}")
	public @ResponseBody Iterable<Film> getFilmFromActor(@PathVariable("actorID") int aid) {
		return filmRepository.findFilmFromActor(aid);
	}
	@GetMapping("/allAfromRandomF")
	public @ResponseBody Iterable<Actor> getActorFromRandomFilm() {
		long x = filmRepository.count();
		int fid = (int) (Math.random() * x);
		return actorRepository.findActorFromFilm(fid);
	}
	@GetMapping("/allFfromRandomA")
	public @ResponseBody Iterable<Film> getFilmFromRandomActor() {
		long x = actorRepository.count();
		int aid = (int) (Math.random() * x);
		return filmRepository.findFilmFromActor(aid);
	}
}
