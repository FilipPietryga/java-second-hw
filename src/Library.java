import java.util.LinkedList;
import java.util.List;

public class Library {
    private List<Writing> writings = new LinkedList<Writing>();

    public void addWriting(Writing writing) {
        if(writing == null) return;
        this.writings.add(writing);
    }

    public Library() {
        this.writings = new LinkedList<Writing>();
    }

    public Library(LinkedList<Writing> writings) {
        this.writings = writings;
    }


    public int hashCode() {
        int result = (int) (writings.hashCode() ^ (writings.hashCode() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("I am a library!").toString();
    }

    public void findFor(User user) throws NoBookFoundException {
        for (Writing writing: writings) {
            if(writing.equals(user)) {
                System.out.println(writing);
            }
        }
        throw new NoBookFoundException("No book matched for user: " +  user);
    }
}
