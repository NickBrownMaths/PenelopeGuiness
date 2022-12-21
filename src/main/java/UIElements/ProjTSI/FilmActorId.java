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
        System.out.println("1");
        if (this == o) return true;
        System.out.println("2");
        if (o == null || getClass() != o.getClass()) return false;
        System.out.println("3");
        FilmActorId that = (FilmActorId) o;
        System.out.println("4");
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
