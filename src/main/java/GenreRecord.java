package main.java;
import main.java.people.Author;
import main.java.traits.Genre;

import java.util.LinkedList;
import java.util.List;

public class GenreRecord {

    public static List<Genre> genres = new LinkedList<Genre>();

    public List<Genre> getAuthors() {
        return genres;
    }

    public void add(Genre genre) {
        genres.add(genre);
    }

    public static Genre get(String name) {
        for(Genre genre : genres) {
            if(genre.getName().equals(name)) {
                return genre;
            }
        }
        return new Genre();
    }

    GenreRecord() {
        genres.add(new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"));
        genres.add(new Genre("Fantasy", "A genre about non-existing characters and settings", "Started in the Enlightenment"));
        genres.add(new Genre("Philosphy", "A general genre for the thought experiments", "Ancient World"));
    }
}
