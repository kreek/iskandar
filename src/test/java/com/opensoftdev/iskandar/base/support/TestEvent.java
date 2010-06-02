/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;
import com.opensoftdev.iskandar.base.Event;
import com.opensoftdev.iskandar.core.IEvent;

public class TestEvent extends Event implements IEvent {


   
    private String _eventType;
    private final TestObject _testObject;

    public TestObject getTestObject() {
        return _testObject;
    }

    @Inject
    public TestEvent(ITestEvents.events eventType, TestObject testObject) {
        super(eventType.toString());
        this._testObject = testObject;
    }
}
