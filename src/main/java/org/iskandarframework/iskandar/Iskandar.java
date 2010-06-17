package org.iskandarframework.iskandar;

import org.iskandarframework.iskandar.base.CommandMap;
import org.iskandarframework.iskandar.base.EventDispatcher;
import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.base.IskandarException;


public class Iskandar {

    ////////////////////////////////////////////////////////////////////////////
    //
    // PRIVATE VARIABLES
    //
    ////////////////////////////////////////////////////////////////////////////

    private static Iskandar instance = null;
    private ICommandMap _commandMap;
    private IEventDispatcher _eventDispatcher;

    ////////////////////////////////////////////////////////////////////////////
    //
    // GETTERS/SETTERS
    //
    ////////////////////////////////////////////////////////////////////////////

    public ICommandMap getCommandMap() {
        return _commandMap;
    }

    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////////////////////////

    private Iskandar() {
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // PUBLIC METHODS
    //
    ////////////////////////////////////////////////////////////////////////////

    public static Iskandar getInstance() {

        if (instance == null) {
            instance = new Iskandar();
        }

        return instance;
    }

    public void startup(){
        this._commandMap = new CommandMap();
        this._eventDispatcher = new EventDispatcher();
        this._commandMap.setEventDispatcher(this._eventDispatcher);
    }

    public void dispatchEvent(IEvent e) throws IskandarException {
        this._eventDispatcher.dispatchEvent(e);
    }

    public void mapEvent(String eventType, ICommand commandClass)
            throws IskandarException {
        this._commandMap.mapEvent(eventType, commandClass);
    }

    public void unmapEvent(String eventType, ICommand commandClass)
            throws IskandarException {
        this._commandMap.unmapEvent(eventType, commandClass);
    }

    public boolean hasEventCommand(String eventType, ICommand commandClass) {
        return this._commandMap.hasEventCommand(eventType, commandClass);
    }

    public void setUnitTesting(boolean unitTesting) throws IskandarException {
        this._eventDispatcher.setUnitTesting(unitTesting);
    }
}
