package UIElements.ProjTSI;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmid;

    @Column(name = "title")
    String title;

    public Film(){}
    public Film(String t, int id) {
        title = t;
        filmid = id;
    }

    public int getFilmid() {
        return filmid;
    }
    public String getTitle() {
        return title;
    }
    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
