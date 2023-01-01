package main.java.exceptions;

import main.java.Items.Essay;
import main.java.traits.Features;
import main.java.exceptions.EmptyWritingInsertionException;

public class EmptyEssayInsertionException extends EmptyWritingInsertionException {
    public EmptyEssayInsertionException(String error, String querriedEssay, String topic, Features features) {
        super(error + ", error for:" + querriedEssay + " - " + topic, features);
    }
}
