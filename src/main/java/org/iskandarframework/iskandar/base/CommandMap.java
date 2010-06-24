/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iskandarframework.iskandar.base;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.ICommandMap;
import org.iskandarframework.iskandar.core.IEvent;
import org.iskandarframework.iskandar.core.IEventDispatcher;
import org.iskandarframework.iskandar.core.IEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alastair
 */
public class CommandMap implements ICommandMap {

    protected IEventDispatcher _eventDispatcher;
    protected Map<String, ICommand> _commandMap = new HashMap();
    

    @Override
    public void setEventDispatcher(IEventDispatcher eventDispatcher) {
        this._eventDispatcher = eventDispatcher;
    }

    @Override
    public IEventDispatcher getEventDispatcher() {
        return _eventDispatcher;
    }



    
    public CommandMap() {
        
    }
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

              

        _eventDispatcher.addEventListener(eventType, new IEventListener() {
            @Override
            public void handleEvent(IEvent e) {
                routeEventToCommand(e, _commandMap.get(e.getEventType()));
            }
        });

    }

    @Override
    public void unmapCommand(String eventType) throws IskandarException {

        if (_commandMap.get(eventType) != null) {
            _commandMap.remove(eventType);
        }        
    }

    @Override
    public boolean hasCommand(String eventType) {

        if (  _commandMap.get(eventType) != null) {

            return true;
        }

        return false;
    }

    
    
    protected void routeEventToCommand(IEvent e, ICommand commandClass) {
        commandClass.execute(e);
    }
}
