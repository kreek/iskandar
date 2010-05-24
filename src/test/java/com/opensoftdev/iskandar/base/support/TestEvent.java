/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base.support;

import com.opensoftdev.iskandar.base.IskandarTestCase;
import com.opensoftdev.iskandar.core.IEvent;

/**
 *
 * @author alastair
 */
public class TestEvent implements IEvent {

    public static final String TEST_ONE = "testOne";
    public static final String TEST_TWO = "testTwo";
    
    private String _eventType;
    private ICommandTestCase _commandTestCase;

    @Override
    public String getEventType() {
        return this._eventType;
    }

    public ICommandTestCase getCommandTestCase() {
        return _commandTestCase;
    }

    public TestEvent(String eventType, ICommandTestCase commandTestCase) {
        this._eventType = eventType;
        this._commandTestCase = commandTestCase;
    }
}
