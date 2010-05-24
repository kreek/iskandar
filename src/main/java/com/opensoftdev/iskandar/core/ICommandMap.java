package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.CommandMap;
import com.opensoftdev.iskandar.base.IskandarException;

@ImplementedBy(CommandMap.class)
public interface ICommandMap {

    public IEventDispatcher getEventDispatcher();
    void mapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException;
    void unmapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException;
    boolean hasEventCommand(String eventType, Class commandClass, Class eventClass);

}
