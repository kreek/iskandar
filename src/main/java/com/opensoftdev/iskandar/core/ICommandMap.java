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
    public void mapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException;
    public void unmapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException;
    public boolean hasEventCommand(String eventType, ICommand commandClass, IEvent eventClass);
}
