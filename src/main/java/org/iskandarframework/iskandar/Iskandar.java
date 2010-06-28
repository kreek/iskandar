package org.iskandarframework.iskandar;

import org.iskandarframework.iskandar.base.CommandMap;
import org.iskandarframework.iskandar.base.EventDispatcher;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.base.IskandarException;
import org.iskandarframework.iskandar.core.ICommandFactory;

public class Iskandar {

    private static Iskandar instance = null;
    private ICommandMap _commandMap;
    private IEventDispatcher _eventDispatcher;

    public ICommandMap getCommandMap() {
        return _commandMap;
    }

    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    public void setUnitTesting(boolean unitTesting) throws IskandarException {

        this._eventDispatcher.setUnitTesting(unitTesting);
    }

    public Iskandar() {

        init();
    }

    public static Iskandar getInstance() {

        if (instance == null) {

            instance = new Iskandar();

        }

        return instance;
    }

    public void init() {

        this._commandMap = new CommandMap();
        this._eventDispatcher = new EventDispatcher();

        this._commandMap.setEventDispatcher(this._eventDispatcher);

    }

    public void dispatchEvent(IEvent e) throws IskandarException {


        this._eventDispatcher.dispatchEvent(e);
    }

    public boolean hasCommand(String eventType) {

        return this._commandMap.hasCommand(eventType);
    }

    public void mapCommand(String eventType, Class commandClass) throws IskandarException {

        this._commandMap.mapCommand(eventType, commandClass);
    }

    public void mapCommand(String eventType, ICommandFactory commandFactory) throws IskandarException {

        this._commandMap.mapCommand(eventType, commandFactory);
    }

    public void unmapCommand(String eventType) throws IskandarException {

        this._commandMap.unmapCommand(eventType);
    }
}
