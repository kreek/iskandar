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
public interface IEventDispatcher {

    void setUnitTesting(boolean unitTesting);
    void addEventListener(String type, IEventListener e);
    void removeEventListener(String type);
    void dispatchEvent(IEvent e) throws IskandarException;
    
}
