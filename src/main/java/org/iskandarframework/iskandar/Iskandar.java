package org.iskandarframework.iskandar;

import org.iskandarframework.iskandar.base.CommandMap;
import org.iskandarframework.iskandar.base.EventDispatcher;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.base.IskandarException;
import org.iskandarframework.iskandar.core.ICommandFactory;

public class Iskandar {

    /**
     * There is only one Iskandar! This is it.
     */
    private static Iskandar instance = null;

    /**
     * The command map for the application. The command map stores which events
     * are mapped to which commands.
     */
    private ICommandMap _commandMap;

    /**
     * The event dispatcher for the application. The event dispatcher is used to
     * listen for (or ignore) events and to fire off or 'dispatch' an event.
     */
    private IEventDispatcher _eventDispatcher;

    /**
     * Gets the command map.
     *
     * @return the application's command map
     */
    public ICommandMap getCommandMap() {

        return _commandMap;
    }

    /**
     * Gets the event dispatcher.
     *
     * @return the application's event dispatcher
     */
    public IEventDispatcher getEventDispatcher() {

        return _eventDispatcher;
    }

    /**
     * Sets a flag for unit testing.
     *
     * @param unitTesting   are we unit testing?
     * @throws IskandarException    bad news bears
     */
    public void setUnitTesting(boolean unitTesting) throws IskandarException {

        this._eventDispatcher.setUnitTesting(unitTesting);
    }

    public Iskandar() {

        init();
    }

    /**
     * Gets one and only one instance of Iskandar.
     *
     * @return  an Iskandar instance
     */
    public static Iskandar getInstance() {

        if (instance == null) {

            instance = new Iskandar();
        }

        return instance;
    }

    /**
     * Initiates the application. Creates a new CommandMap and a new
     * EventDispatcher for the application. Sets the CommandMap to use the same
     * EventDispatcher as the application.
     */
    public void init() {

        this._commandMap = new CommandMap();
        this._eventDispatcher = new EventDispatcher();
        this._commandMap.setEventDispatcher(this._eventDispatcher);
    }

    /**
     * This is a wrapper for the EventDispatcher's dispatchEvent method.
     * <p>
     * This method dispatches an event. If it has been correctly mapped to a
     * command then Iskandar will invoke the execute method of that command.
     *
     * @param e
     * @throws IskandarException
     */
    public void dispatchEvent(IEvent e) throws IskandarException {

        this._eventDispatcher.dispatchEvent(e);
    }

    /**
     * This is a wrapper for the CommandMap's hasCommand method.
     * <p>
     * Checks to see if an event type has been mapped to a command.
     *
     * @param eventType The event to check
     * @return  a boolean value if the event is mapped or not.
     */
    public boolean hasCommand(String eventType) {

        return this._commandMap.hasCommand(eventType);
    }

    /**
     * This is a wrapper for the CommandMap's mapCommand method (non DI version).
     * <p>
     * This method maps an event string to a command class. It instantiates the
     * class through reflection. If using Guice or Spring use the overloaded
     * method that takes a factory instead.
     *
     * @param eventType
     * @param commandClass
     * @throws IskandarException
     */
    public void mapCommand(String eventType, Class commandClass) throws IskandarException {

        this._commandMap.mapCommand(eventType, commandClass);
    }

    /**
     * This is a wrapper for the CommandMap's mapCommand method (DI version).
     * <p>
     * This method maps an event string to a command class. Use this and pass in
     * a factory to the command so that your DI framework can instantiate the
     * command for Iskandar.
     *
     * @param eventType
     * @param commandClass
     * @throws IskandarException
     */
    public void mapCommand(String eventType, ICommandFactory commandFactory) throws IskandarException {

        this._commandMap.mapCommand(eventType, commandFactory);
    }

    /**
     * This is a wrapper for the CommandMap's unmapCommand method.
     * <p>
     * Removes an event from command mapping.
     * 
     * @param eventType
     * @throws IskandarException
     */
    public void unmapCommand(String eventType) throws IskandarException {

        this._commandMap.unmapCommand(eventType);
    }
}
