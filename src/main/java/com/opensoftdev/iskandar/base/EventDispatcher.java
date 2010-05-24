package com.opensoftdev.iskandar.base;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventListener;
import java.util.HashMap;
import java.util.Set;

@Singleton
public class EventDispatcher implements IEventDispatcher {

    private HashMap<String, IEventListener> _listeners = new HashMap();
    private boolean _unitTesting = false;

    @Override
    public void setUnitTesting(boolean _unitTesting) {
        this._unitTesting = _unitTesting;
    }

    @Inject
    public EventDispatcher() {
        
    }

    @Override
    public void addEventListener(String type, IEventListener el) {
        this._listeners.put(type, el);
    }

    @Override
    public void removeEventListener(String type) {
        this._listeners.remove(type);
    }

    @Override
    public void dispatchEvent(IEvent e) throws IskandarException {

        // throw exception for unit test framework to do assets with
        if (this._unitTesting) {
            throw new IskandarException(e.getEventType());
        }

        Set<String> keys = _listeners.keySet();

        for (String key : keys) {
            IEventListener listener = _listeners.get(key);
            if (e.getEventType().equals(key)) {
                listener.handleEvent(e);
            }
        }
    }
    
}
