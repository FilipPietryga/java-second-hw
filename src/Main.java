public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.toString());

        library.addWriting(new Essay("Antioedipus", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Gilles", "Deleuze", "France")), "Anti-Psychiatry"));
        library.addWriting(new Book("Alice in Wonderland", new Attributes(
                new Genre("Fantasy", "", ""),
                new Author("Caroll", "Lewis", "England")), "A story of a girl in wonderland"));
        library.addWriting(new Essay("The Art of Loving", new Attributes(
                new Genre("Philosphy", "", ""),
                new Author("Erich", "Fromm", "Germany")), "Philosophy of Love"));
        library.addWriting(new Essay("The History of Sexuality", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Sexuality in Europe"));
        library.addWriting(new Essay("Republic", new Attributes(
                new Genre("Philosophy", "", ""),
                new Author("Plato", "Plato", "Greece")), "Utopian Country"));
        library.addWriting(new Essay("Madness and Civilization", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Mental Illness"));
        library.addWriting(new Essay("The Archaeology of Knowledge", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Epistemology"));
        library.addWriting(new Essay("What Is an Author?", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Literary Criticism"));
        library.addWriting(new Essay("The Birth of Biopolitics", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Political Science"));
        library.addWriting(new Essay("The Hermeneutics of the Subject", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Michael", "Foucault", "France")), "Ontology"));

        User user = new User("Filip", "Pietryga", "Poland", new Attributes(
                new Genre("Poststructuralism", "", ""),
                new Author("Gilles", "Deleuze", "France")));

        library.findFor(user);
    }
}