package uk.gov.ukho.dpworkshops.two.logging;

import uk.gov.ukho.dpworkshops.two.events.EventListener;
import uk.gov.ukho.dpworkshops.two.events.EventType;
import uk.gov.ukho.dpworkshops.two.models.Dataset;

public class DatasetLogger implements EventListener {
    @Override
    public void update(final EventType eventType, final Dataset dataset) {
        System.out.println(eventType.name() +
                " event received by dataset logger event listener for dataset: " + dataset.getDescription());
    }
}
