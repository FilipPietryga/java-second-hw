package main.java.traits;

import main.java.people.Author;
import main.java.traits.Genre;

public class Features {
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

    public Features() {
        this(new Genre(), new Author());
    }

    public Features(Genre genre, Author author) {
        this.genre = genre;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Features attributes = (Features) o;
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
        sb.append("\npeople.Author: ");
        sb.append(author);
        sb.append("\ntraits.Genre: ");
        sb.append(genre);
        return sb.toString();
    }
}
