/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.opensoftdev.iskandar.base.support.ICommandTestCase;
import com.opensoftdev.iskandar.base.support.TestCommand;
import com.opensoftdev.iskandar.base.support.TestEvent;
import com.opensoftdev.iskandar.core.ICommandMap;
import junit.framework.TestCase;

/**
 *
 * @author alastair
 */
public class CommandMapTestCase extends TestCase implements ICommandTestCase {

    private ICommandMap _commandMap;
    private boolean _commandExecuted;

    @Override
    public void setCommandExecuted(boolean commandExecuted) {
        _commandExecuted = commandExecuted;
    }

    @Override
    protected void setUp() {
        Injector injector = Guice.createInjector();
        _commandMap = injector.getInstance(ICommandMap.class);
        _commandExecuted = false;
    }

    public void test_commandExecutes() throws IskandarException {
        _commandMap.mapEvent(TestEvent.TEST_ONE, TestCommand.class, TestEvent.class);
        _commandMap.getEventDispatcher().dispatchEvent(new TestEvent(TestEvent.TEST_ONE, this));
        assertEquals(true, _commandExecuted);
    }

}