import java.util.prefs.Preferences;

public final class User extends Person {

    protected final Attributes preferences;

    public Attributes getPreferences() {
        return preferences;
    }

    // would make compiler errors
//    public void setPreferences(Attributes preferences) {
//        this.preferences = preferences;
//    }

    public User() {
        this("", "", "", null);
    }

    public static User PersonToUser(Person person) {
        return new User(person.name, person.surname, person.country, new Attributes());
    }

    public User(String name, String surname, String country, Attributes preferences) {
        super(name, surname, country);
        this.preferences = preferences;
    }

    @Override
    public int hashCode() {
        int result = (int) (preferences.hashCode() ^ (preferences.hashCode() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("\nUser Preferences: " + preferences);
        sb.append("\n\nUser Data: \n\nName: " + name);
        sb.append("\nCountry: " + country);
        return sb.toString();
    }
}
