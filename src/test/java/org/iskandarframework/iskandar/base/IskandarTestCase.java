package org.iskandarframework.iskandar.base;

import org.iskandarframework.iskandar.core.ICommand;
import org.iskandarframework.iskandar.core.IEvent;
import junit.framework.TestCase;
import org.iskandarframework.iskandar.support.IIskandarTestEvents.events;
import org.iskandarframework.iskandar.support.TestCommand;
import org.iskandarframework.iskandar.support.TestEvent;

public class IskandarTestCase extends TestCase {

    public IskandarTestCase(String name) {
        super(name);
    }

    public void test_getInstanceNoNull() {

        Iskandar obj = Iskandar.getInstance();
        assertNotNull(obj);
    }

    public void test_init_CommandMapNotNull() {

        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getCommandMap());

    }

    public void test_init_EventDipatcherNotNull() {
        
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getEventDispatcher());

    }

    public void test_init_EventDipatcherInCommandMapNotNull() {
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getCommandMap().getEventDispatcher());

    }

    public void test_mapEventAndUnmapEvent() {

        Iskandar obj = Iskandar.getInstance();
        obj.init();


        try {

            obj.mapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), TestCommand.class);

        } catch (IskandarException e) {

            assertTrue(false);
        } finally {

            try {

                obj.unmapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString());
            } catch (IskandarException e) {

                assertTrue(false);
            }


        }

        assertTrue(true);

    }

    public void test_dispatchEvent() {
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        ICommand command = new TestCommand();
        IEvent event = new TestEvent(events.IskandarUnitTestEvent);

        try {


            obj.mapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), TestCommand.class);
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
