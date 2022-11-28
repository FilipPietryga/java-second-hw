public abstract class Person {

    protected String name;
    protected String surname;
    protected String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person() {
        this("", "", "");
    }

    public Person(String name, String surname, String country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("\nPerson name: " + this.name);
        sb.append("\nPerson surname: " + this.surname);
        sb.append("\nPerson country: " + this.country);
        return sb.toString();
    }
}
