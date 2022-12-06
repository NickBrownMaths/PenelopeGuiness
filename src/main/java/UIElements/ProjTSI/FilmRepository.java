package UIElements.ProjTSI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = "SELECT film.film_id, film.title FROM film " +
            "INNER JOIN film_actor ON film_actor.film_id = film.film_id "+
            "INNER JOIN actor      ON actor.actor_id     = film_actor.actor_id " +
            "WHERE actor.actor_id = :aid_param "
            , nativeQuery = true)
    Iterable<Film> findFilmFromActor(@Param("aid_param") int fid_param);


}
