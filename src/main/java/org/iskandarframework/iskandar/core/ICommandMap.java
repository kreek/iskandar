package org.iskandarframework.iskandar.core;

import org.iskandarframework.iskandar.base.IskandarException;

public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapCommand(String eventType, Class commandClass) throws IskandarException;
    void unmapCommand(String eventType, Class commandClass) throws IskandarException;
    boolean hasCommand(String eventType, Class commandClass);

}
