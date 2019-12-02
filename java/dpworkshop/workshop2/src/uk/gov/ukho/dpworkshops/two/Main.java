package uk.gov.ukho.dpworkshops.two;

import uk.gov.ukho.dpworkshops.two.builders.DatasetBuilder;
import uk.gov.ukho.dpworkshops.two.events.EventManager;
import uk.gov.ukho.dpworkshops.two.events.EventType;
import uk.gov.ukho.dpworkshops.two.facades.CreateDatasetFacade;
import uk.gov.ukho.dpworkshops.two.logging.DatasetLogger;
import uk.gov.ukho.dpworkshops.two.models.Dataset;

public class Main {
    public static void main(final String[] args) {

        EventManager.getInstance().subscribe(new DatasetLogger(), EventType.DATASET_UPLOADED, EventType.DATASET_ACTIVATED);

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
