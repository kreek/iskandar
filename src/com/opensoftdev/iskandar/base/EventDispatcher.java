/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;


import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


/**
 *
 * @author alastair
 */
public class EventDispatcher implements IEventDispatcher {

    private HashMap<String, IEventListener> _listeners = new HashMap();
    private static EventDispatcher instance;

    private boolean _unitTestEnabled = false;

    public void setUnitTestEnabled(boolean unitTestEnabled) {
        this._unitTestEnabled = unitTestEnabled;
    }



    private EventDispatcher() {
        
    }

    public static EventDispatcher getInstance() {
        if(instance==null){
            
            instance = new EventDispatcher();
        }

        return instance;
    }
    
    public void addEventListener( String type, IEventListener el) {

        this._listeners.put(type, el);
    }

    public void removeEventListener(String type){

        this._listeners.remove(type);
    }

    public void dispatchEvent(IEvent e) throws IskandarException{

        if(this._unitTestEnabled){
            throw new IskandarException(e.getEventType());
        }

        Collection<IEventListener> c = _listeners.values();
        Set<String> keys = _listeners.keySet();

        for( String key : keys ){
            IEventListener listener = _listeners.get(key);
            if(e.getEventType().equals(key))
                   listener.handleEvent(e);
        }


    }
}
