package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.EventDispatcher;
import com.opensoftdev.iskandar.base.IskandarException;

@ImplementedBy(EventDispatcher.class)
public interface IEventDispatcher {

    void setUnitTesting(boolean unitTesting);
    void addEventListener(String type, IEventListener e);
    void removeEventListener(String type);
    void dispatchEvent(IIskandarEvent e) throws IskandarException;
    
}
