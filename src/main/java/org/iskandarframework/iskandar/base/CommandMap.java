package org.iskandarframework.iskandar.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.core.IEventListener;
import java.util.HashMap;
import org.iskandarframework.iskandar.core.ICommand;

public class CommandMap implements ICommandMap {

    protected IEventDispatcher eventDispatcher;
    protected HashMap<String, Class> commandMap = new HashMap();

    @Override
    public void setEventDispatcher(IEventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public IEventDispatcher getEventDispatcher() {
        return eventDispatcher;
    }

    public CommandMap() {
    }

    @Override
    public void mapEvent(String eventType, Class commandClass) throws IskandarException {
        if (commandMap.get(eventType) == null) {
            commandMap.put(eventType, commandClass);
        } else {
            throw new IskandarException("Command already mapped to: " + eventType);
        }

        eventDispatcher.addEventListener(eventType, new IEventListener() {

            @Override
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, commandMap.get(e.getEventType()));
            }
        });
    }

    @Override
    public void unmapEvent(String eventType, Class commandClass) throws IskandarException {
        if (commandMap.get(eventType) != null) {
            commandMap.remove(eventType);
        } else {
            throw new IskandarException("Command not mapped to: " + eventType);
        }
    }

    @Override
    public boolean hasEventCommand(String eventType, Class commandClass) {
        if (commandMap.get(eventType) != null) {
            return true;
        } else {
            return false;
        }
    }

    protected void routeEventToCommand(IEvent e, Class commandClass) {
        try {
            ICommand command = (ICommand) commandClass.newInstance();
            command.execute(e);
        } catch (InstantiationException ex) {
            Logger.getLogger(CommandMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommandMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
