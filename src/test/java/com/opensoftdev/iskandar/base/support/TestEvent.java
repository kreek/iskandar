/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base.support;

import com.opensoftdev.iskandar.base.Event;

public class TestEvent extends Event {

    public static final String TEST_ONE = "testOne";
    public static final String TEST_TWO = "testTwo";
    
    private String _eventType;
    private final ITestObject _testObject;

    public ITestObject getTestObject() {
        return _testObject;
    }

    public TestEvent(String eventType, ITestObject testObject) {
        super(eventType);
        this._testObject = testObject;
    }
}
