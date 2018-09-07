package com.prokarma.reference.architecture.networking;



public class SimpleEventStrategy<Event> extends AbstractEventStrategy<Event> {
    @Override
    public boolean checkLoadable() {
        return false;
    }

    @Override
    public Event getFromCache(String uuid) {
        return null;
    }
}

