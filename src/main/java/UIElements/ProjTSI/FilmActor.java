package UIElements.ProjTSI;

import jakarta.persistence.*;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)
public class FilmActor {

    @Id
    @JoinColumn (name = "actor_id", referencedColumnName = "actor_id")
    @ManyToOne(fetch = FetchType.EAGER)
    Actor actorid;

    @Id
    @JoinColumn (name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(fetch = FetchType.EAGER)
    Film filmid;

    public FilmActor() {}

    public Actor getActor() {
        return actorid;
    }
    public Film getFilm() {
        return filmid;
    }
    public void setActor(Actor actorid) {
        this.actorid = actorid;
    }
    public void setFilm(Film filmid) {
        this.filmid = filmid;
    }
}
