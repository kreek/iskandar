/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.opensoftdev.iskandar.base.Command;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.IEvent;

/**
 *
 * @author alastair
 */
public class TestCommand extends Command implements ICommand {

    @Assisted
    private final TestEvent _testEvent;

    @Inject
    public TestCommand(@Assisted IEvent e) {
        super();
        this._testEvent = (TestEvent)e;
    }

    @Override
    public void execute() {
        this._testEvent.getTestObject().setCommandExecuted(true);
    }

}