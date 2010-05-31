/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import com.google.inject.AbstractModule;

/**
 *
 * @author alastair
 */
public class CommandModule extends AbstractModule {

    private final Event _event;
    private final Class _eventClass;
    private final Class _commandClass;

    public CommandModule(Event event, Class eventClass, Class commandClass) {
        this._event = event;
        this._eventClass = eventClass;
        this._commandClass = commandClass;
    }

    @Override
    protected void configure() {
        bind(this._eventClass).toInstance(this._event);
        try {
            bind(this._commandClass).toInstance(this._commandClass.newInstance());
        } catch (InstantiationException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
    
}
