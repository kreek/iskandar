package org.iskandarframework.iskandar.core;

import org.iskandarframework.iskandar.base.IskandarException;



/**
 * This is the event dispatcher type.  The default concrete class for this is
 * EventDispatcher class.  
 */
public interface IEventDispatcher {

    void setUnitTesting(boolean unitTesting);
    void addEventListener(String type, IEventListener e);
    void removeEventListener(String type);
    void dispatchEvent(IEvent e) throws IskandarException;
    
}
