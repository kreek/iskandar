package org.iskandarframework.iskandar.core;

import org.iskandarframework.iskandar.base.IskandarException;

public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapEvent(String eventType, ICommand commandClass) throws IskandarException;
    void unmapEvent(String eventType, ICommand commandClass) throws IskandarException;
    boolean hasEventCommand(String eventType, ICommand commandClass);

}
