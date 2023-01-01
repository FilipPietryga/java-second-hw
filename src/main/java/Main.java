package main.java;

import main.java.Items.Book;
import main.java.Items.Essay;
import main.java.exceptions.EmptyPreferencesException;
import main.java.exceptions.EmptyWritingInsertionException;
import main.java.exceptions.NoBookFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.java.people.User;
import main.java.people.Author;
import main.java.traits.Features;
import main.java.traits.Genre;
import main.java.Library;
import main.java.AuthorRecord;
import main.java.GenreRecord;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        logger.info("Hello world!");

        Library library = new Library();
        System.out.println(library);
        AuthorRecord authorRecord = new AuthorRecord();
        GenreRecord genreRecord = new GenreRecord();

        try {
            library.addItem(new Essay("XYZ", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Gilles", "Deleuze")), "Anti-Psychiatry"));
            library.addItem(new Book("Alice in Wonderland", new Features(
                    genreRecord.get("Fantasy"),
                    authorRecord.get("Caroll", "Lewis")), "A story of a girl in wonderland"));
            library.addItem(new Essay("The Art of Loving", new Features(
                    genreRecord.get("Philosophy"),
                    authorRecord.get("Erich", "Fromm")), "Philosophy of Love"));
            library.addItem(new Essay("The History of Sexuality", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Sexuality in Europe"));
            library.addItem(new Essay("Republic", new Features(
                    genreRecord.get("Philosophy"),
                    authorRecord.get("Plato", "Plato")), "Utopian Country"));
            library.addItem(new Essay("Madness and Civilization", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Mental Illness"));
            library.addItem(new Essay("The Archaeology of Knowledge", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Epistemology"));
            library.addItem(new Essay("What Is an people.Author?", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Literary Criticism"));
            library.addItem(new Essay("The Birth of Biopolitics", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Political Science"));
            library.addItem(new Essay("The Hermeneutics of the Subject", new Features(
                    genreRecord.get("Poststructuralism"),
                    authorRecord.get("Michael", "Foucault")), "Ontology"));
        } catch(EmptyWritingInsertionException ex) {
            System.out.println(ex.getMessage());
        }

        User user = new User("Filip", "Pietryga", "Poland", new Features(
                new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                new Author("Gilles", "Deleuze", "France")));

        try {
            library.findFor(user);
        } catch (NoBookFoundException | EmptyPreferencesException ex) {
            System.out.println(ex.getMessage());
        }

        library.saveLibrary2File("123");
    }
}