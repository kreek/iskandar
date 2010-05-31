package com.opensoftdev.iskandar.base;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IIskandar;

@Singleton
public class Iskandar implements IIskandar {

    ////////////////////////////////////////////////////////////////////////////
    //
    // PRIVATE VARIABLES
    //
    ////////////////////////////////////////////////////////////////////////////

    private IEventDispatcher _eventDispatcher;
    private ICommandMap _commandMap;

    ////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////////////////////////

    public Iskandar() {
        Injector injector = Guice.createInjector(new IskandarModule());
        this._eventDispatcher = injector.getInstance(IEventDispatcher.class);
        this._commandMap = injector.getInstance(ICommandMap.class);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //
    // PUBLIC METHODS
    //
    ////////////////////////////////////////////////////////////////////////////

    public void startup() {
        
    }

    @Override
    public void dispatchEvent(Event e) throws IskandarException {
        this._eventDispatcher.dispatchEvent(e);
    }

    @Override
    public void mapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException {
        this._commandMap.mapEvent(eventType, commandClass, eventClass);
    }

    @Override
    public void unmapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException {
        this._commandMap.unmapEvent(eventType, commandClass, eventClass);
    }

    @Override
    public boolean hasEventCommand(String eventType, Class commandClass, Class eventClass) {
        return this._commandMap.hasEventCommand(eventType, commandClass, eventClass);
    }

    @Override
    public void setUnitTesting(boolean unitTesting) throws IskandarException {
        this._eventDispatcher.setUnitTesting(unitTesting);
    }
}
