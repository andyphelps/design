package uk.gov.ukho.dpworkshops.two.events;

import uk.gov.ukho.dpworkshops.two.models.Dataset;

import java.util.*;

public final class EventManager {

  private final Map<EventType, List<EventListener>> subscribers;

  public EventManager() {
    this.subscribers = new HashMap<>();
    Arrays.stream(EventType.values()).forEach(eventType -> subscribers.put(eventType, new ArrayList<>()));
  }

  public void subscribe(final EventListener eventListener, final EventType eventType, final EventType... eventTypes) {
    subscribers.get(eventType).add(eventListener);

    Arrays.stream(eventTypes).forEach(
        eventTypeInVarArgs -> subscribers.get(eventTypeInVarArgs).add(eventListener)
    );
  }

  public void unsubscribe(final EventType eventType, final EventListener eventListener) {
    subscribers.get(eventType).remove(eventListener);
  }

  public void emit(final EventType eventType, final Dataset dataset) {
    subscribers.get(eventType).forEach(listener -> listener.update(eventType, dataset));
  }
}
