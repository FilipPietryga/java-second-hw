package main.java.Items;

import main.java.Interfaces.Closeable;
import main.java.Interfaces.Comparable;
import main.java.Interfaces.Copyable;
import main.java.Interfaces.Openable;
import main.java.Interfaces.Readable;
import main.java.exceptions.EmptyPreferencesException;
import main.java.people.User;
import main.java.traits.Features;

public abstract class Writing implements Readable, Closeable, Copyable, Comparable, Openable {

    protected String title;
    protected Features attributes;
    protected int length;

    public Features getFeatures() {
        return attributes;
    }

    public void setAttributes(Features attributes) {
        this.attributes = attributes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Writing() {
        this("", null);
    }

    public Writing(String title, Features attributes) {
        this.title = title;
        this.attributes = attributes;
    }

    public <T> boolean attributesMatch(T o) throws EmptyPreferencesException {
        if (o == null) return false;
        User user = (User) o;
        if(user.getPreferences().getAuthor().equals(null) || user.getPreferences().getGenre().equals(null)) {
            throw new EmptyPreferencesException("No user preferences have been specified", user.getPreferences());
        }
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
        sb.append("\ntraits.Attributes: " + attributes);
        sb.append("\nLength: " + length);
        return sb.toString();
    }

    public void clear() {
        title = "";
        attributes = null;
        length = 0;
    }

    public void reset(String title, Features attributes, int length) {
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
