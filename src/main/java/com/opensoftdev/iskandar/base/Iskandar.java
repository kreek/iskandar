package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IIskandarEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IIskandar;

@Singleton
public class Iskandar implements IIskandar {

    private final ICommandMap _commandMap;
    private final IEventDispatcher _eventDispatcher;

    @Override
    public ICommandMap getCommandMap() {
        return _commandMap;
    }

    @Override
    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    @Override
    public void setUnitTesting(boolean unitTesting) throws IskandarException {
        this._eventDispatcher.setUnitTesting(unitTesting);
    }

    @Inject
    public Iskandar() {
        Injector injector = Guice.createInjector();
        this._commandMap = injector.getInstance(ICommandMap.class);
        this._eventDispatcher = injector.getInstance(IEventDispatcher.class);
    }

    @Override
    public void dispatchEvent(IIskandarEvent e) throws IskandarException {
        this._eventDispatcher.dispatchEvent(e);
    }

    @Override
    public boolean hasEventCommand(String eventType, ICommand commandClass, Class eventClass) {
        return this._commandMap.hasEventCommand(eventType, commandClass, eventClass);
    }

    @Override
    public void mapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException {
        this._commandMap.mapEvent(eventType, commandClass, eventClass);
    }

    @Override
    public void unmapEvent(String eventType, ICommand commandClass, Class eventClass) throws IskandarException {
        this._commandMap.unmapEvent(eventType, commandClass, eventClass);
    }

}
