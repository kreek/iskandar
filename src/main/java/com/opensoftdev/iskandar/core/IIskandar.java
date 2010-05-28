package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.Iskandar;
import com.opensoftdev.iskandar.base.IskandarException;

@ImplementedBy(Iskandar.class)
public interface IIskandar {

    void setUnitTesting(boolean unitTesting) throws IskandarException;
    void dispatchEvent(IEvent e) throws IskandarException;
    boolean hasEventCommand(String eventType, Class commandClass, Class eventClass);
    void mapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException;
    void unmapEvent(String eventType, Class commandClass, Class  eventClass) throws IskandarException;

}
