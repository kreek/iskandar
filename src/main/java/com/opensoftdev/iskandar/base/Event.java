package com.opensoftdev.iskandar.base;

import com.google.inject.Inject;
import com.opensoftdev.iskandar.core.IEvent;

public abstract class Event implements IEvent {

    private String _eventType;

    @Override
    public String getEventType() {
        return _eventType;
    }

    @Inject
    public Event(String type) {
        this._eventType = type;
    }
}
