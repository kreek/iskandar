package org.iskandarframework.iskandar.base;

/**
 *
 */
public abstract class IskandarEvent {


    private String _eventType;

    public String getEventType() {
        return _eventType;
    }

    public IskandarEvent(String type){
        
        this._eventType = type;
    }

}
