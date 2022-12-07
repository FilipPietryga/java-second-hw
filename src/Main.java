import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        logger.info("Hello world!");

        Library library = new Library();
        System.out.println(library);

        try {
            library.addWriting(new Essay("Antioedipus", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Gilles", "Deleuze", "France")), "Anti-Psychiatry"));
            library.addWriting(new Book("Alice in Wonderland", new Attributes(
                    new Genre("Fantasy", "A genre about non-existing characters and settings", "Started in the Enlightenment"),
                    new Author("Caroll", "Lewis", "England")), "A story of a girl in wonderland"));
            library.addWriting(new Essay("The Art of Loving", new Attributes(
                    new Genre("Philosphy", "A general genre for the thought experiments", "Ancient World"),
                    new Author("Erich", "Fromm", "Germany")), "Philosophy of Love"));
            library.addWriting(new Essay("The History of Sexuality", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Sexuality in Europe"));
            library.addWriting(new Essay("Republic", new Attributes(
                    new Genre("Philosphy", "A general genre for the thought experiments", "Ancient World"),
                    new Author("Plato", "Plato", "Greece")), "Utopian Country"));
            library.addWriting(new Essay("Madness and Civilization", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Mental Illness"));
            library.addWriting(new Essay("The Archaeology of Knowledge", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Epistemology"));
            library.addWriting(new Essay("What Is an Author?", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Literary Criticism"));
            library.addWriting(new Essay("The Birth of Biopolitics", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Political Science"));
            library.addWriting(new Essay("The Hermeneutics of the Subject", new Attributes(
                    new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                    new Author("Michael", "Foucault", "France")), "Ontology"));
        } catch(EmptyWritingInsertionException ex) {
            System.out.println(ex.getMessage());
        }

        User user = new User("Filip", "Pietryga", "Poland", new Attributes(
                new Genre("Poststructuralism", "A genre of postmodern literature", "started in 1960s"),
                new Author("Gilles", "Deleuze", "France")));

        try {
            library.findFor(user);
        } catch (NoBookFoundException|EmptyPreferencesException ex) {
            System.out.println(ex.getMessage());
        }
    }
}