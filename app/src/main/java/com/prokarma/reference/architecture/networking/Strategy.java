package com.prokarma.reference.architecture.networking;

interface Strategy<T> {
    boolean checkLoadable();
    T getFromCache(String uuid);
}
