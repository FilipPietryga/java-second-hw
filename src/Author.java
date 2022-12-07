public final class Author extends Person {

    public Author() {
        this("", "", "");
    }

    public Author(String name, String surname, String country) {
        super(name, surname, country);
    }

    public static Author PersonToAuthor(Person person) {
        return new Author(person.name, person.surname, person.country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) || surname.equals(author.surname) || country.equals(author.country);
    }

    @Override
    public int hashCode() {
        int result = (int) (name.hashCode() ^ (name.hashCode() >>> 32));
        result = 31 * result + surname.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Name: " + name);
        sb.append(", Surname: " + surname);
        sb.append(", Country: " + country);
        return sb.toString();
    }
}
