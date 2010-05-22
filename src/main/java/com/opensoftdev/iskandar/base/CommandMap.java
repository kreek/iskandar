/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IEventListener;
import java.util.HashMap;


/**
 *
 * @author alastair
 */
public class CommandMap implements ICommandMap {

    protected IEventDispatcher _eventDispatcher = EventDispatcher.getInstance();;
    protected HashMap<String, ICommand> _commandMap = new HashMap();
    protected HashMap<String, IEvent> _eventTypeMap = new HashMap();

    

    public CommandMap() {
        
    }

    public void mapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException {


        if (_commandMap.get(eventType) == null) {
            _commandMap.put(eventType, commandClass);

        }else{

            throw new IskandarException("Command already mapped to: " + eventType);
        }

       

        if (_eventTypeMap.get(eventType) == null) {
            _eventTypeMap.put(eventType, eventClass);
        }else{
            throw new IskandarException("Event already mapped to: " + eventType);
        }

        _eventDispatcher.addEventListener(eventType, new IEventListener() {
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, _commandMap.get(e.getEventType()));
            }
        });

    }

    public void unmapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException {

        if (_commandMap.get(eventType) != null) {
            _commandMap.remove(eventType);

        }else{
            throw new IskandarException("Command not mapped to: " + eventType);
        }



        if (_eventTypeMap.get(eventType) != null) {
            _eventTypeMap.remove(eventType);
        }else{
            throw new IskandarException("Event already mapped to: " + eventType);
        }


    }

    public boolean hasEventCommand(String eventType, ICommand commandClass, IEvent eventClass) {

        if (_commandMap.get(eventType) != null) {
            return true;

        }else{
            return false;
        }
    }

    protected void routeEventToCommand(IEvent e, ICommand commandClass) {
        commandClass.execute(e);
    }
}
