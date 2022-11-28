import java.util.Objects;

public class Genre {
    protected String name;
    protected String description;
    protected String history;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Genre(String name, String description, String history) {
        this.name = name;
        this.description = description;
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return name.equals(genre.name) || description.equals(genre.description) || history.equals(genre.history);
    }

    @Override
    public int hashCode() {
        int result = (int) (name.hashCode() ^ (name.hashCode() >>> 32));
        result = 31 * result + history.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("genre's name: " + this.name);
        sb.append("\ngenre's surname: " + this.description);
        sb.append("\ngenre's country: " + this.history);
        return sb.toString();
    }
}
