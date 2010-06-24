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
public interface IEventDispatcher {

    void setUnitTesting(boolean unitTesting);
    void addEventListener(String type, IEventListener e);
    void removeEventListener(String type);
    void dispatchEvent(IEvent e) throws IskandarException;
    
}
