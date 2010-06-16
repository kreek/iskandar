/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.Iskandar;
import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.IEvent;
import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase {

    public class TestCommand implements ICommand {

        @Override
        public void execute(IEvent e) {
            throw new UnsupportedOperationException(e.getEventType());
        }
    }

    public class TestEvent implements IEvent {

        IIskandarTestEvents.events _e;

        @Override
        public String getEventType() {
            return this._e.toString();
        }

        public TestEvent(IIskandarTestEvents.events e) {
            this._e = e;
        }
    }

    public IskandarTestCase(String name) {
        super(name);
    }

    public void test_getInstanceNoNull() {

        Iskandar obj = Iskandar.getInstance();
        assertNotNull(obj);
    }

    public void test_startup_CommandMapNotNull() {

        Iskandar obj = Iskandar.getInstance();
        obj.startup();

        assertNotNull(obj.getCommandMap());
    }

    public void test_startup_EventDipatcherNotNull() {

        Iskandar obj = Iskandar.getInstance();
        obj.startup();

        assertNotNull(obj.getEventDispatcher());
    }

    public void test_startup_EventDipatcherInCommandMapNotNull() {

        Iskandar obj = Iskandar.getInstance();
        obj.startup();

        assertNotNull(obj.getCommandMap().getEventDispatcher());
    }

    public void test_mapEventAndUnmapEvent() {

        Iskandar obj = Iskandar.getInstance();
        obj.startup();

        ICommand command = new TestCommand();
        IEvent event = new TestEvent(IIskandarTestEvents.events.IskandarUnitTestEvent);

        try {
            obj.mapEvent(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), command);
        } catch (IskandarException e) {
            assertTrue(false);
        } finally {
            try {
                obj.unmapEvent(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), command);
            } catch (IskandarException e) {
                assertTrue(false);
            }
        }

        assertTrue(true);
    }

    public void test_dispatchEvent() {
        Iskandar obj = Iskandar.getInstance();
        obj.startup();

        ICommand command = new TestCommand();
        IEvent event = new TestEvent(IIskandarTestEvents.events.IskandarUnitTestEvent);

        try {
            obj.mapEvent(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), command);
            try {
                obj.dispatchEvent(event);
            } catch (UnsupportedOperationException e) {
                assertEquals(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), e.getMessage());
            }
        } catch (IskandarException e) {
            assertTrue(false);
        }
    }
}
