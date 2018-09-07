package com.prokarma.reference.architecture.networking;



public class SimpleEventStrategy<T> implements Strategy<T> {
    @Override
    public boolean checkLoadable() {
        return false;
    }

    @Override
    public T getFromCache(String uuid) {
        return null;
    }
}

