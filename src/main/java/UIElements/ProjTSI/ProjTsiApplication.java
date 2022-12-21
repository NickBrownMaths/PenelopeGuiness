package UIElements.ProjTSI;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.collections4.CollectionUtils;

import java.net.FileNameMap;
import java.util.*;

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
	@GetMapping("/getFilm/{filmID}")
	public @ResponseBody Optional<Film> getFilmByID(@PathVariable("filmID") int filmID) {
		Optional<Film> film = filmRepository.findById(filmID);
		return film;
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
		int fid = (int) (Math.random() * (x - 1)) + 1;
		return actorRepository.findActorFromFilm(fid);
	}
	@GetMapping("/allFfromRandomA")
	public @ResponseBody Iterable<Film> getFilmFromRandomActor() {
		long x = actorRepository.count();
		int aid = (int) (Math.random() * (x - 1)) + 1;
		return filmRepository.findFilmFromActor(aid);
	}

	// Calculates the bacon number between two arbitrary actors
	@GetMapping("/distance/{aid1}/{aid2}")
	public int computeBaconDistance(@PathVariable("aid1") int aid1, @PathVariable("aid2") int aid2) {
		int distance = 0;

		// We need a list of films from the first actor and an empty list of actors
		Iterable<Film> searchFilms = filmRepository.findFilmFromActor(aid1);
		Iterable<Actor> searchActors ;

		boolean finished = false;
		int currentDistance = 0;
		while (!finished) {
			++ currentDistance;
			// find all actors in the film list
			searchActors = findAllActorsFromMultiFilms(searchFilms) ;

			// determine if the target actor is in the actor list
			for (Actor a : searchActors) {
				if (a.getActorid() == aid2) {
					finished = true;
					distance = currentDistance;
				}
			}
			// If we didn't find the target actor, remake the film list
			if (!finished) {
				searchFilms = findAllFilmsFromMultiActors(searchActors) ;
			}

			// Condition to ensure while is exited
			if (currentDistance > 50) {
				finished = true;
				distance = -1 ;
			}
		}
		return distance ;
	}
	public Iterable<Film> findAllFilmsFromMultiActors(Iterable<Actor> listA) {
		Iterable<Film> retFilms = Collections.emptySet();
		for (Actor a : listA) {
			Iterable<Film> addFilms = getFilmFromActor(a.getActorid()) ;
			retFilms = CollectionUtils.union(retFilms, addFilms) ;
		}
		return retFilms;
	}
	public Iterable<Actor> findAllActorsFromMultiFilms(Iterable<Film> listF) {
		Iterable<Actor> retActors = Collections.emptySet();
		for (Film f : listF) {
			Iterable<Actor> addActors = getActorFromFilm(f.getFilmid()) ;
			retActors = CollectionUtils.union(retActors, addActors) ;
		}
		return retActors;
	}
	@GetMapping("/distanceAll")
	public @ResponseBody Iterable<String> megaBacon() {
		List<String> retStrings = new ArrayList<String>();
		long totalActors = actorRepository.count();
		for (int actor1 = 1 ; actor1 <= totalActors ; ++actor1) {
			for (int actor2 = 1 ; actor2 < actor1 ; ++actor2) {
				String currentEntry = "" + actor1 + " " + actor2 + " " + computeBaconDistance(actor1, actor2);
				retStrings.add(currentEntry);
			}
		}
		return retStrings;
	}
}
