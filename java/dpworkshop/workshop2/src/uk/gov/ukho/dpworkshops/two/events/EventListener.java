package uk.gov.ukho.dpworkshops.two.events;

import uk.gov.ukho.dpworkshops.two.models.Dataset;

public interface EventListener {
  void update(final EventType eventType, final Dataset dataset);
}
