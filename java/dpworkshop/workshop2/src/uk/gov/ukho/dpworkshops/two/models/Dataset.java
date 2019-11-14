package uk.gov.ukho.dpworkshops.two.models;

import java.util.function.Function;

public class Dataset {
    private final String content;
    private final String description;
    private final String author;
    private final Function<String, Boolean> validator;

    public Dataset(String content, String description, String author, Function<String, Boolean> validator) {
        this.content = content;
        this.description = description;
        this.author = author;
        this.validator = validator;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Function<String, Boolean> getValidator() {
        return validator;
    }
}
