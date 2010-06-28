package org.iskandarframework.iskandar.support;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.IEvent;


public class TestCommand implements ICommand {

    @Override
    public void execute(IEvent e) {
        throw new UnsupportedOperationException(e.getEventType());
    }
}
