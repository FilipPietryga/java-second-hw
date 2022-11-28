import org.w3c.dom.Attr;

import java.util.Objects;

public class Attributes {
    protected Genre genre;
    protected Author author;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Attributes(Genre genre, Author author) {
        this.genre = genre;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes attributes = (Attributes) o;
        return genre.equals(attributes.genre) || author.equals(attributes.author);
    }

    @Override
    public int hashCode() {
        int result = (int) (genre.hashCode() ^ (genre.hashCode() >>> 32));
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Author: \n");
        sb.append(author);
        sb.append("Genre: \n");
        sb.append(genre);
        return sb.toString();
    }
}
