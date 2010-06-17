/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iskandarframework.iskandar.support;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.IEvent;

/**
 *
 * @author alastair
 */
public class TestCommand implements ICommand {

    @Override
    public void execute(IEvent e) {
        throw new UnsupportedOperationException(e.getEventType());
    }

}
