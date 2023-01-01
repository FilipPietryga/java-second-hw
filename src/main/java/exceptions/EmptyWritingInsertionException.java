package main.java.exceptions;

import main.java.traits.Features;

public class EmptyWritingInsertionException extends Exception {
    public EmptyWritingInsertionException(String error, Features features) {
        super(error + " " + features);
    }
}
