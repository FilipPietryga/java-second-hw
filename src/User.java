public class User extends Person {

    protected Attributes preferences;

    public Attributes getPreferences() {
        return preferences;
    }

    public void setPreferences(Attributes preferences) {
        this.preferences = preferences;
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
        sb.append("\nPreferences: " + preferences);
        sb.append("\nName: " + name);
        sb.append("\nLength: " + country);
        return sb.toString();
    }
}
