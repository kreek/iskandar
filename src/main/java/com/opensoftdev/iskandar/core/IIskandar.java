package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.Iskandar;
import com.opensoftdev.iskandar.base.IskandarException;

@ImplementedBy(Iskandar.class)
public interface IIskandar {

    ICommandMap getCommandMap();
    IEventDispatcher getEventDispatcher();
    void setUnitTesting(boolean unitTesting) throws IskandarException;
    void dispatchEvent(IIskandarEvent e) throws IskandarException;
    boolean hasEventCommand(String eventType, ICommand commandClass, Class eventClass);
    void mapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException;
    void unmapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException;

}
