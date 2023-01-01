package main.java.Items;

import main.java.traits.Features;
import main.java.Items.Writing;

public class Book extends Writing {
    private String plot;

    public String getPlot() {
        return plot;
    }

    public Book() {
        this("", null, "");
    }

    public Book(String title, Features attributes, String plot) {
        super(title, attributes);
        this.plot = plot;
    }

    public static Book WritingToBook(Writing writing) {
        return new Book(writing.title, new Features(), "Topic");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("\nTitle: " + title);
        sb.append("\ntraits.Attributes: " + attributes);
        sb.append("\nLength: " + length);
        sb.append("\nPlot: " + plot);
        return sb.toString();
    }

    public void clear() {
        title = "";
        attributes = null;
        length = 0;
        plot = "";
    }

    public void reset(String title, Features attributes, int length, String plot) {
        this.title = title;
        this.attributes = attributes;
        this.length = length;
        this.plot = plot;
    }

    public Book(Book book) {
        this.title = book.title;
        this.attributes = book.attributes;
        this.length = book.length;
        this.plot = book.plot;
    }

    @Override
    public void read() {
        System.out.println("Read the essay");
    }

    @Override
    public void close() {
        System.out.println("Close the book");
    }

    @Override
    public void compare() {
        System.out.println("Compare the book");
    }

    @Override
    public void copy() {
        System.out.println("Copy the book");
    }

    @Override
    public void open() {
        System.out.println("Open the book");
    }
}
