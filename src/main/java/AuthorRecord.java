package main.java;
import main.java.people.Author;

import java.util.LinkedList;
import java.util.List;

public class AuthorRecord {

    public static List<Author> authors = new LinkedList<Author>();

    public List<Author> getAuthors() {
        return authors;
    }

    public void add(Author author) {
        authors.add(author);
    }

    public static Author get(String name, String surname) {
        for(Author author : authors) {
            if(author.getName().equals(name) && author.getSurname().equals(surname)) {
                return author;
            }
        }
        return new Author();
    }

    AuthorRecord() {
        authors.add(new Author("Gilles", "Deleuze", "France"));
        authors.add(new Author("Caroll", "Lewis", "England"));
        authors.add(new Author("Erich", "Fromm", "Germany"));
        authors.add(new Author("Michael", "Foucault", "France"));
        authors.add(new Author("Plato", "Plato", "Greece"));
    }
}
