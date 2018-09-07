package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.Event;

//work in progress dlafon 9/6/2018
class CacheManager {

    Strategy s = new SimpleEventStrategy<Event>();

    boolean checkLoadable() {
        //placeholder.
        return false;
    }

    Object getFromCache(){
        //place holder
        return null;
    }


}
