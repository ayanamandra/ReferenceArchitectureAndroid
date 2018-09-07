package com.prokarma.reference.architecture.networking;

abstract class AbstractEventStrategy<Event> implements Strategy<Event> {

    @Override
    public abstract Event getFromCache(String uuid);
}
