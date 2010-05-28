/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.opensoftdev.iskandar.base.Command;
import com.opensoftdev.iskandar.core.ICommand;

/**
 *
 * @author alastair
 */
public class TestCommand extends Command implements ICommand {

    private TestEvent _testEvent;

    @Inject
    public TestCommand(Injector injector) {
        super(injector);
    }

    @Override
    public void execute() {
        _testEvent = this._injector.getInstance(TestEvent.class);
        _testEvent.getTestObject().setCommandExecuted(true);
        System.out.println("funk");
    }

}