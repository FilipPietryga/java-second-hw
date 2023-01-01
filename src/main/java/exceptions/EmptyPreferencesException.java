package main.java.exceptions;

import main.java.traits.Features;

public class EmptyPreferencesException extends Exception {

    public EmptyPreferencesException(String error, Features features) {
        super(error + " " + features);
    }
}
