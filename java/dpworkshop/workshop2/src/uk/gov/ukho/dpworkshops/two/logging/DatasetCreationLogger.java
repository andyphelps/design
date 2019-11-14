package uk.gov.ukho.dpworkshops.two.logging;

import uk.gov.ukho.dpworkshops.two.events.EventListener;
import uk.gov.ukho.dpworkshops.two.events.EventType;
import uk.gov.ukho.dpworkshops.two.models.Dataset;

public class DatasetCreationLogger implements EventListener {
    @Override
    public void update(final EventType eventType, final Dataset dataset) {
        System.out.println(dataset.getDescription() + " Creation event received by logging event listener");
    }
}
