package main.java.people;

import main.java.traits.Features;

public final class User extends Person {

    private final Features preferences;

    public Features getPreferences() {
        return preferences;
    }

    public User() {
        this("", "", "", null);
    }

    public static User PersonToUser(Person person) {
        return new User(person.name, person.surname, person.country, new Features());
    }

    public User(String name, String surname, String country, Features preferences) {
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
        sb.append("\npeople.User Preferences: " + preferences);
        sb.append("\n\npeople.User Data: \n\nName: " + name);
        sb.append("\nCountry: " + country);
        return sb.toString();
    }
}
