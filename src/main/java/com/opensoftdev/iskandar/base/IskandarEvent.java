package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.core.IIskandarEvent;

public abstract class IskandarEvent implements IIskandarEvent {

    private String _eventType;

    @Override
    public String getEventType() {
        return _eventType;
    }

    public IskandarEvent(String type){
        this._eventType = type;
    }
    
}
