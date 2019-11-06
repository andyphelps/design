package uk.gov.ukho.dpworkshops.one;

import uk.gov.ukho.dpworkshops.one.builders.DatasetBuilder;
import uk.gov.ukho.dpworkshops.one.facades.CreateDatasetFacade;
import uk.gov.ukho.dpworkshops.one.models.Dataset;

public class Main {
    public static void main(final String[] args) {

        final Dataset dataset = DatasetBuilder
                .builder()
                .addRow("1,2,3")
                .addRow("4,5,6")
                .addRow("7,8,9")
                .description("3x3 Matrix of first nine numbers")
                .build();

        CreateDatasetFacade.createDataset(dataset);
    }
}
