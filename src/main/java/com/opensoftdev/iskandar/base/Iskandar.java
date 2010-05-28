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

    private ICommandMap _commandMap;
    private IEventDispatcher _eventDispatcher;
    private Injector _injector;

    ////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////////////////////////

    @Inject
    public Iskandar() {
        System.out.println("funk");
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //
    // PUBLIC METHODS
    //
    ////////////////////////////////////////////////////////////////////////////

    @Override
    public void setUnitTesting(boolean unitTesting) throws IskandarException {
        this._eventDispatcher.setUnitTesting(unitTesting);
    }

    public void startup(AbstractModule[] args) {
        this._injector = Guice.createInjector(args);
        this._injector.injectMembers(this);
    }

    @Override
    public void dispatchEvent(IEvent e) throws IskandarException {
        this._eventDispatcher.dispatchEvent(e);
    }

    @Override
    public boolean hasEventCommand(
            String eventType, Class commandClass, Class eventClass) {
        return this._commandMap.hasEventCommand(
                eventType, commandClass, eventClass);
    }

    @Override
    public void mapEvent(String eventType, Class commandClass, Class eventClass)
            throws IskandarException {
        this._commandMap.mapEvent(eventType, commandClass, eventClass);
    }

    @Override
    public void unmapEvent(
            String eventType, Class commandClass, Class eventClass)
            throws IskandarException {
        this._commandMap.unmapEvent(eventType, commandClass, eventClass);
    }

}
