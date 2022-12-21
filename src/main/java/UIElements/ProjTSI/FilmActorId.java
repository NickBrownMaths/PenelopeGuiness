package UIElements.ProjTSI;

import java.io.Serializable;
import java.util.Objects;

public class FilmActorId implements Serializable {
    private int actorid;
    private int filmid;

    public FilmActorId() {}
    public FilmActorId(int fid, int aid) {
        this.filmid = fid;
        this.actorid = aid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return actorid == that.getActorid() && filmid == that.getFilmid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorid, filmid);
    }

    public int getActorid() {
        return actorid;
    }

    public int getFilmid() {
        return filmid;
    }
}
