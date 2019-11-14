package uk.gov.ukho.dpworkshops.two.builders;

import uk.gov.ukho.dpworkshops.two.models.Dataset;
import uk.gov.ukho.dpworkshops.two.validators.DataValidators;

import java.util.function.Function;

public class DatasetBuilder {
    private String content = "";
    private String description = null;
    private String author = "Unknown Author";
    private Function<String, Boolean> validator = DataValidators::csvValidator;

    public static DatasetBuilder builder() {
        return new DatasetBuilder();
    }

    public DatasetBuilder description(final String description) {
        this.description = description;
        return this;
    }

    public DatasetBuilder author(final String author) {
        this.author = author;
        return this;
    }

    public DatasetBuilder validator(final Function<String, Boolean> validator) {
        this.validator = validator;
        return this;
    }

    public DatasetBuilder addRow(final String row) {
        this.content += row + "\n";
        return this;
    }

    public Dataset build() {
        checkReadyToBuild();
        return new Dataset(content.stripTrailing(), description, author, validator);
    }

    private void checkReadyToBuild() {
        if (content.equals("")) {
            throw new IllegalArgumentException("content must be set");
        }

        if (description == null) {
            throw new IllegalArgumentException("description must be set");
        }
    }
}
