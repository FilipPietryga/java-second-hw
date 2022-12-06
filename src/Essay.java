public final class Essay extends Writing {
    protected String topic;

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
        return new Essay(writing.title, new Attributes(), "Topic");
    }

    public Essay(String title, Attributes attributes, String topic) {
        super(title, attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Title: " + this.title);
        sb.append("Attributes: " + this.attributes);
        sb.append("Topic: " + this.topic);
        return sb.toString();
    }

    public void clear() {
        title = "";
        attributes = null;
        length = 0;
        topic = "";
    }

    public void reset(String title, Attributes attributes, int length, String topic) {
        this.title = title;
        this.attributes = attributes;
        this.length = length;
        this.topic = topic;
    }

    public void reset(Essay essay) {
        this.title = essay.title;
        this.attributes = essay.attributes;
        this.length = essay.length;
        this.topic = essay.topic;
    }
}
