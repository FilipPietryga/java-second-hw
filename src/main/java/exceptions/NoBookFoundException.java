package main.java.exceptions;

import main.java.traits.Features;

public class NoBookFoundException extends Exception {
    public NoBookFoundException(String error, Features features) {
        super(error + " " + features);
    }
}
