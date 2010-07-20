package org.iskandarframework.iskandar.base;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.core.IEventListener;
import java.util.HashMap;
import java.util.Map;
import org.iskandarframework.iskandar.core.ICommandFactory;


/**
 * This class is the heart of Iskandar.  It is what keeps track of what commands
 * are mapped to what classes
 */
public class CommandMap implements ICommandMap {

    /**
     * An instance of EventDispatcher.  It should be set in this class at some
     * point after instantiation
     */
    protected IEventDispatcher _eventDispatcher;
    
    /**
     * A hash table mapping events to commands
     */
    protected Map<String, ICommand> _commandMap = new HashMap();
    

    /**
     * The setter method that sets the EventDispatcher of this CommandMap.  The
     * EventDispatcher is the handler of all events being dispatchedi in the app
     * @param IEventDispatcher eventDispatcher
     */
    @Override
    public void setEventDispatcher(IEventDispatcher eventDispatcher) {
        this._eventDispatcher = eventDispatcher;
    }

    /**
     * The getter for EventDispatcher concreate class
     * @return IEventDispatcher
     */
    @Override
    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }



    
    public CommandMap() {
        
    }

    /**
     * This method maps an event string to a command class.  It instantiates the
     * class through reflection.  If using Guice or Spring use the overloaded
     * method that takes a factory instead
     * @param String eventType
     * @param Class commandClass
     * @throws IskandarException
     */
    @Override
    public void mapCommand(String eventType, Class commandClass) throws IskandarException {


        if (_commandMap.get(eventType) == null) {

            ICommand commandIntance;
            try {
                commandIntance = (ICommand) commandClass.newInstance();
                _commandMap.put(eventType, commandIntance);

            } catch (InstantiationException ex) {

                throw new IskandarException("Error instantiating command: " + commandClass.getName() + " Details: " + ex.getMessage());


            } catch (IllegalAccessException ex) {
                
                throw new IskandarException("Error instantiating command: " + commandClass.getName() + " Details: " + ex.getMessage());
            }
            

        }else{

            throw new IskandarException("Command already mapped to: " + eventType);
        }

              
        //handle dispatched events and route them with an anonymous class
        _eventDispatcher.addEventListener(eventType, new IEventListener() {
            @Override
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, _commandMap.get(e.getEventType()));
            }
        });

    }

    /**
     * This method maps an event string to a command class.  Use this and pass in
     * a factory to the command so that your DI framework can instantiate the
     * command for Iskandar
     * @param String eventType
     * @param ICommandFactory commandFactory
     * @throws IskandarException
     */
    @Override
    public void mapCommand(String eventType, ICommandFactory commandFactory) throws IskandarException {


        if (_commandMap.get(eventType) == null) {

                ICommand commandIntance;
                commandIntance = commandFactory.getCommand();
                _commandMap.put(eventType, commandIntance);

        } else {

            throw new IskandarException("Command already mapped to: " + eventType);
        }

        _eventDispatcher.addEventListener(eventType, new IEventListener() {

            @Override
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, _commandMap.get(e.getEventType()));
            }
        });

    }

    /**
     * Remove an event to command mapping
     * @param String eventType
     * @throws IskandarException
     */
    @Override
    public void unmapCommand(String eventType) throws IskandarException {

        if (_commandMap.get(eventType) != null) {
            _commandMap.remove(eventType);
        }        
    }

    /**
     * Check to see if an event type has been mapped to a command
     * @param String eventType
     * @return boolean
     */
    @Override
    public boolean hasCommand(String eventType) {

        if (  _commandMap.get(eventType) != null) {

            return true;
        }

        return false;
    }

    
    /**
     * This method executes the appropriate command for a dispatched event.
     * @param IEvent e
     * @param ICommand commandClass
     */
    protected void routeEventToCommand(IEvent e, ICommand commandClass) {
        commandClass.execute(e);
    }
}
