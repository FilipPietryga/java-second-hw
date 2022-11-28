import java.util.Objects;

public class Author extends Person {

    public Author(String name, String surname, String country) {
        super(name, surname, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) || surname.equals(author.surname) || country.equals(author.country);
    }

    @Override
    public int hashCode() {
        int result = (int) (name.hashCode() ^ (name.hashCode() >>> 32));
        result = 31 * result + surname.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Name: " + name);
        sb.append("Surname: " + surname);
        sb.append("Country: " + country);
        return sb.toString();
    }
}
