package com.opensoftdev.iskandar;

import com.opensoftdev.iskandar.base.CommandMap;
import com.opensoftdev.iskandar.base.EventDispatcher;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.base.IskandarException;


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
