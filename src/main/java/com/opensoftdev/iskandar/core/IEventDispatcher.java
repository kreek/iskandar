package com.opensoftdev.iskandar.core;

import com.opensoftdev.iskandar.base.IskandarException;

public interface IEventDispatcher {

    void setUnitTesting(boolean unitTesting);
    void addEventListener(String type, IEventListener e);
    void removeEventListener(String type);
    void dispatchEvent(IEvent e) throws IskandarException;
    
}
