package MoviesEntity;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES", schema = "DRAGOS")
@NamedQuery(name = "film.Querry", query = "SELECT e FROM MoviesEntity e WHERE e.nume = ?1")
public class MoviesEntity {
    private String nume;
    private String durata;
    private String id;

    @Basic
    @Column(name = "NUME")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "DURATA")
    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesEntity that = (MoviesEntity) o;

        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (durata != null ? !durata.equals(that.durata) : that.durata != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + (durata != null ? durata.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "nume='" + nume + '\'' +
                ", durata='" + durata + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
