package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEvent;
import com.opensoftdev.iskandar.core.IEventDispatcher;

public class Iskandar{

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
    
    private Iskandar() {


    }

    public static Iskandar getInstance(){

        if(instance == null){

            instance = new Iskandar();

        }

        return instance;
    }

    public void init(){

        this._commandMap = new CommandMap();
        this._eventDispatcher = new EventDispatcher();

        this._commandMap.setEventDispatcher(this._eventDispatcher);

    }   
  
    public void dispatchEvent(IEvent e) throws IskandarException {


        this._eventDispatcher.dispatchEvent(e);
    }


    public boolean hasEventCommand(String eventType, ICommand commandClass, IEvent eventClass) {

       return this._commandMap.hasEventCommand(eventType, commandClass, eventClass);
    }


    public void mapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException {

        this._commandMap.mapEvent(eventType, commandClass, eventClass);
    }


    public void unmapEvent(String eventType, ICommand commandClass, IEvent eventClass) throws IskandarException {

        this._commandMap.unmapEvent(eventType, commandClass, eventClass);
    }



}
