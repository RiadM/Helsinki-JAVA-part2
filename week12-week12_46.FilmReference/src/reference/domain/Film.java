package reference.domain;

public class Film {

    private String name;

    public Film(String name) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        return this.name.equals(film.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
