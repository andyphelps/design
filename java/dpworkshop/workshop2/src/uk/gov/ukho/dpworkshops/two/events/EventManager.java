package uk.gov.ukho.dpworkshops.two.events;

import uk.gov.ukho.dpworkshops.two.models.Dataset;

import java.util.*;

public final class EventManager {

    private final Map<EventType, List<EventListener>> subscribers;
    private static final EventManager instance = new EventManager();

    public static EventManager getInstance() {
        return instance;
    }

    private EventManager() {
        this.subscribers = new HashMap<>();
        Arrays.stream(EventType.values()).forEach(eventType -> subscribers.put(eventType, new ArrayList<>()));
    }

    public void subscribe(final EventType eventType, final EventListener eventListener) {
        subscribers.get(eventType).add(eventListener);
    }

    public void unsubscribe(final EventType eventType, final EventListener eventListener) {
        subscribers.get(eventType).remove(eventListener);
    }

    public void emit(final EventType eventType, final Dataset dataset) {
        subscribers.get(eventType).forEach(listener -> listener.update(eventType, dataset));
    }
}
