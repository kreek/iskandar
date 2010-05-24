package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.core.IEvent;

public abstract class Event implements IEvent {

    private String _eventType;

    @Override
    public String getEventType() {
        return _eventType;
    }

    public Event(String type) {
        this._eventType = type;
    }
}
