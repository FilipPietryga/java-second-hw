import java.util.LinkedList;
import java.util.List;

public class Library {
    private final List<Writing> writings;

    public void addWriting(Writing writing) throws EmptyWritingInsertionException{
        if(writing == null) return;
        if(writing.title.equals("")) {
            if(writing.getClass().getSimpleName().equals("Book")) {
                throw new EmptyBookInsertionException("You tried to insert an empty Book");
            } else if(writing.getClass().getSimpleName().equals("Essay")) {
                throw new EmptyEssayInsertionException("You tried to insert an empty Essay");
            }
        }
        this.writings.add(writing);
    }

    public Library() {
        this.writings = new LinkedList<>();
    }

    public Library(LinkedList<Writing> writings) {
        this.writings = writings;
    }

    public int hashCode() {
        return (int) (writings.hashCode() ^ (writings.hashCode() >>> 32));
    }

    @Override
    public String toString() {
        return new StringBuilder("I am a library!").toString();
    }

    public void findFor(User user) throws NoBookFoundException, EmptyPreferencesException {
        try {
            for (Writing writing : writings) {
                if (writing.equals(user)) {
                    System.out.println(writing);
                }
            }
        } catch (EmptyPreferencesException ex) {
            throw ex;
        }
        throw new NoBookFoundException("No book matched for user: " +  user);
    }
}
