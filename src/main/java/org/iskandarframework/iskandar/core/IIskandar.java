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
public interface IIskandar {

    void dispatchEvent(IEvent e) throws IskandarException;
    void mapCommand(String eventType, Class commandClass) throws IskandarException;
    void unmapCommand(String eventType, Class commandClass) throws IskandarException;
    boolean hasCommand(String eventType, Class commandClass);
    void setUnitTesting(boolean unitTesting) throws IskandarException;
    
}