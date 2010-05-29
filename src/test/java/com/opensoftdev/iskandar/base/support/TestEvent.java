/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;
import com.opensoftdev.iskandar.base.Event;
import com.opensoftdev.iskandar.core.IEvent;

public class TestEvent extends Event implements IEvent {

    public static final String TEST_ONE = "testOne";
    public static final String TEST_TWO = "testTwo";
    
    private String _eventType;
    private final TestObject _testObject;

    public TestObject getTestObject() {
        return _testObject;
    }

    @Inject
    public TestEvent(String eventType, TestObject testObject) {
        super(eventType);
        this._testObject = testObject;
    }
}
