import java.util.Objects;

public abstract class Writing implements Readable, Closeable, Copyable, Comparable, Openable {

    protected String title;
    protected Attributes attributes;
    protected int length;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Writing(String title, Attributes attributes) {
        this.title = title;
        this.attributes = attributes;
    }

    public boolean equals(User o) {
        if (o == null) return false;
        User user = (User) o;
        return attributes.equals(user.getPreferences());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writing writing = (Writing) o;
        return length == writing.length && title.equals(writing.title) && attributes.equals(writing.attributes);
    }

    @Override
    public int hashCode() {
        int result = (int) (title.hashCode() ^ (title.hashCode() >>> 32));
        result = 31 * result + attributes.hashCode();
        //i know its deprecated, but it threw errors if i didnt use new Integer here
        result = 31 * result + new Integer(length).hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("\nTitle: " + title);
        sb.append("\nAttributes: " + attributes);
        sb.append("\nLength: " + length);
        return sb.toString();
    }

    public void clear() {
        title = "";
        attributes = null;
        length = 0;
    }

    public void reset(String title, Attributes attributes, int length) {
        this.title = title;
        this.attributes = attributes;
        this.length = length;
    }

    public void reset(Writing writing) {
        this.title = writing.title;
        this.attributes = writing.attributes;
        this.length = writing.length;
    }

    public void read() {
        System.out.println("Read the book");
    }

    public void close() {
        System.out.println("Close the book");
    }

    public void compare() {
        System.out.println("Compare the book");
    }

    public void copy() {
        System.out.println("Copy the book");
    }

    public void open() {
        System.out.println("Open the book");
    }
}
