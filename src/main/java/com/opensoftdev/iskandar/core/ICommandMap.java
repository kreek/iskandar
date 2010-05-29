package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.CommandMap;
import com.opensoftdev.iskandar.base.IskandarException;

public interface ICommandMap {
    void mapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException;
    void unmapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException;
    boolean hasEventCommand(String eventType, Class commandClass, Class eventClass);
}
