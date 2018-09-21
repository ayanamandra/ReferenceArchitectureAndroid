package com.prokarma.reference.architecture.feature.search.event_list;


import android.view.View;

import com.prokarma.reference.architecture.model.Event;

/**
 * Actions that can be performed on events.
 */
public interface EventActions {
    void openEventDetail(View view, Event event);
}
