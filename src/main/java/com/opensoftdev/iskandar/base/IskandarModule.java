/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import com.google.inject.AbstractModule;
import com.opensoftdev.iskandar.core.ICommandMap;
import com.opensoftdev.iskandar.core.IEventDispatcher;

/**
 *
 * @author alastair
 */
public class IskandarModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IEventDispatcher.class).to(EventDispatcher.class);
        bind(ICommandMap.class).to(CommandMap.class);
    }

}
