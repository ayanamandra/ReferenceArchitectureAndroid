package com.prokarma.reference.architecture.networking;

public interface OnCallListener<T> {

    void onCallCompleted(T model);

    void onCallFailed(Throwable throwable);
}
