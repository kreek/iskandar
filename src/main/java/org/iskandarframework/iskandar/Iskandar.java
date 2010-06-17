package org.iskandarframework.iskandar;

import org.iskandarframework.iskandar.base.CommandMap;
import org.iskandarframework.iskandar.base.EventDispatcher;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.base.IskandarException;
import org.iskandarframework.iskandar.core.IIskandar;

public class Iskandar implements IIskandar {

    private static Iskandar instance = null;
    private final ICommandMap _commandMap;
    private final IEventDispatcher _eventDispatcher;

    public ICommandMap getCommandMap() {
        return _commandMap;
    }

    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    protected Iskandar() {
        this._commandMap = new CommandMap();
        this._eventDispatcher = new EventDispatcher();
        this._commandMap.setEventDispatcher(this._eventDispatcher);
    }

    public static Iskandar getInstance() {
        if (instance == null) {
            synchronized (Iskandar.class) {
                instance = new Iskandar();
            }
        }

        return instance;
    }

    @Override
    public void dispatchEvent(IEvent e) throws IskandarException {
        this._eventDispatcher.dispatchEvent(e);
    }

    @Override
    public void mapEvent(String eventType, Class commandClass)
            throws IskandarException {
        this._commandMap.mapEvent(eventType, commandClass);
    }

    @Override
    public void unmapEvent(String eventType, Class commandClass)
            throws IskandarException {
        this._commandMap.unmapEvent(eventType, commandClass);
    }

    @Override
    public boolean hasEventCommand(String eventType, Class commandClass) {
        return this._commandMap.hasEventCommand(eventType, commandClass);
    }

    @Override
    public void setUnitTesting(boolean unitTesting) throws IskandarException {
        this._eventDispatcher.setUnitTesting(unitTesting);
    }
}
