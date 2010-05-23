/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.core;

import com.opensoftdev.iskandar.base.IskandarException;

/**
 *
 * @author alastair
 */
public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException;
    void unmapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException;
    boolean hasEventCommand(String eventType, ICommand commandClass, IEvent eventClass);
}
