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
    
    public Iskandar() {


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


    public boolean hasCommand(String eventType) {

       return this._commandMap.hasCommand(eventType);
    }


    public void mapCommand(String eventType, Class commandClass) throws IskandarException {

        this._commandMap.mapCommand(eventType, commandClass);
    }


    public void unmapCommand(String eventType) throws IskandarException {

        this._commandMap.unmapCommand(eventType);
    }



}
