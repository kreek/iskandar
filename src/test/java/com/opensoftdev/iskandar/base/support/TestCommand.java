/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base.support;

import com.opensoftdev.iskandar.base.IskandarTestCase;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.IEvent;

/**
 *
 * @author alastair
 */
public class TestCommand implements ICommand {

    @Override
    public void execute(IEvent e) {
        TestEvent event = (TestEvent) e;
        ICommandTestCase commandTestCase = (ICommandTestCase) event.getCommandTestCase();
        commandTestCase.setCommandExecuted(true);
    }

}
