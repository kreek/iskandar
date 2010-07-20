/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iskandarframework.iskandar.base;


import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *  This class handles the adding and removing of event listeners and the
 * dispatching of events.  It along with CommandMap are the heart and soul of
 * Iskandar
 * 
 */
public class EventDispatcher implements IEventDispatcher {

    /**
     * The hash table mapping events to listeners
     */
    private Map<String, IEventListener> _listeners = new HashMap();

    /**
     * This is used during unit testing.  If it's true Iskandar won't dispatch
     * and try to map.  Instead it throws an IskandarException with the type of
     * event so it can be assert with JUnit
     */
    private boolean _unitTesting = false;

    /**
     * The setter for unit testing
     * @param boolean _unitTesting
     */
    @Override
    public void setUnitTesting(boolean _unitTesting) {
        this._unitTesting = _unitTesting;
    }
   
    public EventDispatcher() {
        
    }

   /**
    * This method adds an event listener to a hash table.  For events to be
    * mapped to commands they have to have event listeners
    * @param String type
    * @param IEventListener el
    */
    @Override
    public void addEventListener( String type, IEventListener el) {

        this._listeners.put(type, el);
    }

    /**
     * This method removes an event listener
     * @param type
     */
    @Override
    public void removeEventListener(String type){

        this._listeners.remove(type);
    }

    /**
     * This method dispatches an event.  If it has been correctly mapped to a
     * command then Iskandar will invoke the execute method of that command
     * @param IEvent e
     * @throws IskandarException
     */
    @Override
    public void dispatchEvent(IEvent e) throws IskandarException{

        //throw exception fo unit test framework to do assets with
        if(this._unitTesting){

            throw new IskandarException(e.getEventType());
        }

        Set<String> keys = _listeners.keySet();

        for( String key : keys ){
            IEventListener listener = _listeners.get(key);
            if(e.getEventType().equals(key))
                   listener.handleEvent(e);
        }


    }
}
