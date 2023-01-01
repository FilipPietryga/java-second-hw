package main.java.Items;

import main.java.Items.Writing;
import main.java.traits.Features;

public final class Essay extends Writing {
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Essay() {
        this("", null, "");
    }

    public static Essay WritingToEssay(Writing writing) {
        return new Essay(writing.title, new Features(), "Topic");
    }

    public Essay(String title, Features attributes, String topic) {
        super(title, attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Title: " + this.title);
        sb.append("traits.Attributes: " + this.attributes);
        sb.append("Topic: " + this.topic);
        return sb.toString();
    }

    public void clear() {
        title = "";
        attributes = null;
        length = 0;
        topic = "";
    }

    public void reset(String title, Features attributes, int length, String topic) {
        this.title = title;
        this.attributes = attributes;
        this.length = length;
        this.topic = topic;
    }

    public Essay(Essay essay) {
        this.title = essay.title;
        this.attributes = essay.attributes;
        this.length = essay.length;
        this.topic = essay.topic;
    }

    @Override
    public void read() {
        System.out.println("Read the essay");
    }

    @Override
    public void close() {
        System.out.println("Close the essay");
    }

    @Override
    public void compare() {
        System.out.println("Compare the essay");
    }

    @Override
    public void copy() {
        System.out.println("Copy the essay");
    }

    @Override
    public void open() {
        System.out.println("Open the essay");
    }
}
