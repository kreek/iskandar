package org.iskandarframework.iskandar.core;

import org.iskandarframework.iskandar.base.IskandarException;

/**
 *  This interface is for the concrete CommandMap class.  This class is the
 *  heart of Iskandar
 */
public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapCommand(String eventType, Class commandClass) throws IskandarException;
    void mapCommand(String eventType, ICommandFactory commandFactory) throws IskandarException;
    void unmapCommand(String eventType) throws IskandarException;
    boolean hasCommand(String eventType);

}
