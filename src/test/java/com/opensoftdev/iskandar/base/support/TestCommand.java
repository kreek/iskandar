/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;
import com.opensoftdev.iskandar.base.Command;
import com.opensoftdev.iskandar.core.ICommand;

/**
 *
 * @author alastair
 */
public class TestCommand extends Command implements ICommand {

    private final TestEvent _testEvent;

    @Inject
    public TestCommand(TestEvent e) {
        super();
        this._testEvent = e;
    }

    @Override
    public void execute() {
        this._testEvent.getTestObject().setCommandExecuted(true);
    }

}