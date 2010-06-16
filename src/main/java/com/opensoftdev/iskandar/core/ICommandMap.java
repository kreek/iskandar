package com.opensoftdev.iskandar.core;

import com.opensoftdev.iskandar.base.IskandarException;

public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapEvent(String eventType, ICommand commandClass) throws IskandarException;
    void unmapEvent(String eventType, ICommand commandClass) throws IskandarException;
    boolean hasEventCommand(String eventType, ICommand commandClass);

}
