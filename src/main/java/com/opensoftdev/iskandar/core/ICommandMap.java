package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.CommandMap;
import com.opensoftdev.iskandar.base.IskandarException;

@ImplementedBy(CommandMap.class)
public interface ICommandMap {

    public IEventDispatcher getEventDispatcher();
    void mapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException;
    void unmapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException;
    boolean hasEventCommand(String eventType, ICommand commandClass, Class eventClass);

}
