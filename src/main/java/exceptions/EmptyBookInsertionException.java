package main.java.exceptions;

import main.java.Items.Book;
import main.java.traits.Features;
import main.java.exceptions.EmptyWritingInsertionException;

public class EmptyBookInsertionException extends EmptyWritingInsertionException {
    public EmptyBookInsertionException(String error, String querriedBook, String plot, Features features) {
        super(error + ", error for:" + querriedBook + " - " + plot, features);
    }
}
