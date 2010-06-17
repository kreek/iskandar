package org.iskandarframework.iskandar.base;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.core.IEventListener;
import java.util.HashMap;

public class CommandMap implements ICommandMap {

    ////////////////////////////////////////////////////////////////////////////
    //
    // PROTECTED VARIABLES
    //
    ////////////////////////////////////////////////////////////////////////////

    protected IEventDispatcher _eventDispatcher;
    protected HashMap<String, ICommand> _commandMap = new HashMap();

    ////////////////////////////////////////////////////////////////////////////
    //
    // GETTERS/SETTERS
    //
    ////////////////////////////////////////////////////////////////////////////

    @Override
    public void setEventDispatcher(IEventDispatcher eventDispatcher) {
        this._eventDispatcher = eventDispatcher;
    }

    @Override
    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////////////////////////

    public CommandMap() {
        
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // PUBLIC METHODS
    //
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void mapEvent(String eventType, ICommand commandClass)
            throws IskandarException {

        if (_commandMap.get(eventType) == null) {
            _commandMap.put(eventType, commandClass);
        } else {
            throw new IskandarException("Command already mapped to: " + eventType);
        }

        _eventDispatcher.addEventListener(eventType, new IEventListener() {

            @Override
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, _commandMap.get(e.getEventType()));
            }
        });
        
    }

    @Override
    public void unmapEvent(String eventType, ICommand commandClass)
            throws IskandarException {

        if (_commandMap.get(eventType) != null) {
            _commandMap.remove(eventType);
        } else {
            throw new IskandarException("Command not mapped to: " + eventType);
        }

    }

    @Override
    public boolean hasEventCommand(String eventType, ICommand commandClass) {

        if (_commandMap.get(eventType) != null) {
            return true;
        } else {
            return false;
        }
        
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // PROTECTED METHODS
    //
    ////////////////////////////////////////////////////////////////////////////
    
    protected void routeEventToCommand(IEvent e, ICommand commandClass) {
        commandClass.execute(e);
    }
}
