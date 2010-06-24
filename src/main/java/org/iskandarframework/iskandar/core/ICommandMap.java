/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iskandarframework.iskandar.core;

import org.iskandarframework.iskandar.base.IskandarException;

/**
 *
 * @author alastair
 */
public interface ICommandMap {

    void setEventDispatcher(IEventDispatcher eventDispatcher);
    public IEventDispatcher getEventDispatcher();
    void mapCommand(String eventType, Class commandClass) throws IskandarException;
    void unmapCommand(String eventType) throws IskandarException;
    boolean hasCommand(String eventType);

}
