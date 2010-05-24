package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;
import com.opensoftdev.iskandar.core.IEventListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class CommandMap implements ICommandMap {

    private final IEventDispatcher _eventDispatcher;
    protected HashMap<String, Class> _commandMap = new HashMap();
    protected HashMap<String, Class> _eventTypeMap = new HashMap();

    @Override
    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }

    @Inject
    public CommandMap(IEventDispatcher eventDispatcher) {
        this._eventDispatcher = eventDispatcher;
    }

    @Override
    public void mapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException {

        if (_commandMap.get(eventType) == null) {
            _commandMap.put(eventType, commandClass);
        } else {
            throw new IskandarException("Command already mapped to: " + eventType);
        }

        if (_eventTypeMap.get(eventType) == null) {
            _eventTypeMap.put(eventType, eventClass);
        } else {
            throw new IskandarException("Event already mapped to: " + eventType);
        }

        _eventDispatcher.addEventListener(eventType, new IEventListener() {

            @Override
            public void handleEvent(IEvent e) {
                try {
                    routeEventToCommand(e, _commandMap.get(e.getEventType()), _eventTypeMap.get(e.getEventType()));
                } catch (InstantiationException ex) {
                    Logger.getLogger(CommandMap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void unmapEvent(String eventType, Class commandClass, Class eventClass) throws IskandarException {

        if (_commandMap.get(eventType) != null) {
            _commandMap.remove(eventType);
        } else {
            throw new IskandarException("Command not mapped to: " + eventType);
        }

        if (_eventTypeMap.get(eventType) != null) {
            _eventTypeMap.remove(eventType);
        } else {
            throw new IskandarException("Event not mapped to: " + eventType);
        }
    }

    @Override
    public boolean hasEventCommand(String eventType, Class commandClass, Class eventClass) {
        
        if (_commandMap.get(eventType) != null) {
            return true;
        } else {
            return false;
        }
    }

    protected void routeEventToCommand(IEvent e, Class commandClass, Class eventClass) throws InstantiationException {

        if (e.getClass() != eventClass) return;
        ICommand command;
        try {
            command = (ICommand) commandClass.newInstance();
            command.execute(e);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommandMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
