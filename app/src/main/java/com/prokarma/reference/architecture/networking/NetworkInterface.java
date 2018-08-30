package com.prokarma.reference.architecture.networking;

public interface NetworkInterface<T> {

    void onCallCompleted(T model);

    void onCallFailed(Throwable throwable);
}
