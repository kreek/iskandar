/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryProvider;
import com.opensoftdev.iskandar.core.ICommandFactory;
import com.opensoftdev.iskandar.core.IEvent;

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
        bind(this._event.getClass()).to(this._eventClass);
        bind(ICommandFactory.class).toProvider(
                FactoryProvider.newFactory(ICommandFactory.class, _commandClass));
    }
    
}
