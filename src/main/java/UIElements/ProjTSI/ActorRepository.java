package UIElements.ProjTSI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(value = "SELECT * FROM actor WHERE first_name LIKE \"a%\"", nativeQuery = true)
    Iterable<Actor> findAllStartsA() ;

    @Query(value = "SELECT actor.actor_id, actor.first_name, actor.last_name FROM actor " +
            "INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id " +
            "INNER JOIN film ON film_actor.film_id = film.film_id "+
            "WHERE film.film_id = 1"
            , nativeQuery = true)
    Iterable<Actor> findAllActorsFilms();

}
