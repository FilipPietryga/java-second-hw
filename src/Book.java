import org.xml.sax.helpers.AttributesImpl;

import javax.management.Attribute;

public class Book extends Writing {
    protected String plot;
    public Book(String title, Attributes attributes, String plot) {
        super(title, attributes);
        this.plot = plot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("\nTitle: " + title);
        sb.append("\nAttributes: " + attributes);
        sb.append("\nLength: " + length);
        sb.append("\nPlot: " + plot);
        return sb.toString();
    }
}
