package main.java;

import main.java.Items.Book;
import main.java.Items.Essay;
import main.java.Items.Writing;
import main.java.exceptions.EmptyWritingInsertionException;
import main.java.exceptions.EmptyBookInsertionException;
import main.java.exceptions.EmptyEssayInsertionException;
import main.java.exceptions.NoBookFoundException;
import main.java.exceptions.EmptyPreferencesException;
import java.nio.charset.StandardCharsets;

import main.java.people.User;

import java.util.LinkedList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import main.java.AuthorRecord;
import main.java.GenreRecord;

public class Library {
    private final List<Writing> writings;

    private boolean checkLine(java.lang.String str) {
        java.lang.String[] splitted = StringUtils.split("str");
        if(splitted.length >= 5) {
            return true;
        }
        return false;
    }

    private void loadWritingFromFile(String name) {
        File file = new File("save.txt");

        try {
            List<java.lang.String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            for (java.lang.String line : lines) {
                if(checkLine(line)){
                    java.lang.String[] splitted = StringUtils.split(java.lang.String.valueOf(line));
                    try {
                        switch (splitted[0]) {
                            case "Essay":
                                this.addItem(new Essay(splitted[1], new main.java.traits.Features(
                                        GenreRecord.get(splitted[2]),
                                        AuthorRecord.get(splitted[3], splitted[4])), splitted[5]));
                                break;
                            case "Book":
                                this.addItem(new Book(splitted[1], new main.java.traits.Features(
                                        GenreRecord.get(splitted[2]),
                                        AuthorRecord.get(splitted[3], splitted[4])), splitted[5]));
                                break;
                        }
                    }
                    catch (EmptyWritingInsertionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLibrary2File(String filename) {
        File f = new File("save.txt");
        StringBuilder fullString = new StringBuilder("");
        for(Writing item : writings) {
            System.out.println(item.getClass().getSimpleName());
            if(item.getClass().getSimpleName().equals("Book")) {
                Book book = (Book) item;

                StringBuilder sb = new StringBuilder("");
                sb.append(book.getTitle() + " ");
                sb.append(book.getFeatures().getGenre().getName() + " ");
                sb.append(book.getFeatures().getAuthor().getName() + " ");
                sb.append(book.getFeatures().getAuthor().getSurname() + " ");
                sb.append(book.getPlot());

                fullString.append("Book " + sb + "\n");

            } else if(item.getClass().getSimpleName().equals("Essay")) {
                Essay essay = (Essay) item;

                StringBuilder sb = new StringBuilder("");
                sb.append(essay.getTitle() + " ");
                sb.append(essay.getFeatures().getGenre().getName() + " ");
                sb.append(essay.getFeatures().getAuthor().getName() + " ");
                sb.append(essay.getFeatures().getAuthor().getSurname() + " ");
                sb.append(essay.getTopic());

                fullString.append("Essay " + sb + "\n");
            }
        }
        try {
            FileUtils.write(f, fullString, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveStats2File() {
        File f = new File("stats.txt");
        StringBuilder fullString = new StringBuilder("");
        fullString.append("Loadded: " + main.java.Stats.getLoads());
        fullString.append(" Written: " + main.java.Stats.getWrites());
        try {
            FileUtils.write(f, fullString, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public <T extends Writing> void addItem(T item) throws EmptyWritingInsertionException {
        if(item == null) return;
        if(item.getTitle().equals("")) {
            if(item.getClass().getSimpleName().equals("main.java.Items.Book")) {
                Book book = (Book) item;
                throw new EmptyBookInsertionException("You tried to insert an empty Items.Book", book.getTitle(), book.getPlot(), book.getFeatures());
            } else if(item.getClass().getSimpleName().equals("main.java.Items.Essay")) {
                Essay essay = (Essay) item;
                throw new EmptyEssayInsertionException("You tried to insert an empty Items.Essay", essay.getTitle(), essay.getTopic(), essay.getFeatures());
            }
        }
        this.writings.add(item);
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
    public java.lang.String toString() {
        return "I am a library!";
    }

    public void findFor(User user) throws NoBookFoundException, EmptyPreferencesException {
        try {
            for (Writing writing : writings) {
                if (writing.attributesMatch(user)) {
                    System.out.println(writing);
                }
            }
        } catch (EmptyPreferencesException ex) {
            throw ex;
        }
        throw new NoBookFoundException("No book matched for user: " + user, user.getPreferences());
    }
}
