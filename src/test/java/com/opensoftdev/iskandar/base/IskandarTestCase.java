package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.opensoftdev.iskandar.base.support.ITestObject;
import com.opensoftdev.iskandar.base.support.TestCommand;
import com.opensoftdev.iskandar.base.support.TestEvent;
import com.opensoftdev.iskandar.base.support.TestObject;
import com.opensoftdev.iskandar.core.IIskandar;
import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase {

    private IIskandar _iskandar;
    private ITestObject _testObject;
    
    public IskandarTestCase() {

    }

    @Override
    protected void setUp() {
        Injector injector = Guice.createInjector();
        _iskandar = injector.getInstance(IIskandar.class);
    }
    
    public IskandarTestCase(String name) {
        super(name);
    }

    public void test_getInstanceNotNull() {
        assertNotNull(_iskandar);
    }

//    public void test_commandMapNotNull() {
//        assertNotNull(_iskandar.getCommandMap());
//    }
//
//    public void test_eventDipatcherNotNull() {
//        assertNotNull(_iskandar.getEventDispatcher());
//    }
//
//    public void test_eventDipatcherInCommandMapNotNull() {
//        assertNotNull(_iskandar.getCommandMap().getEventDispatcher());
//    }

    public void test_commandExecutes() throws IskandarException {

        _iskandar.mapEvent(TestEvent.TEST_ONE, TestCommand.class, TestEvent.class);
        TestObject testObject = new TestObject();
        _iskandar.dispatchEvent(new TestEvent(TestEvent.TEST_ONE, testObject));
        assertEquals(true, testObject.isCommandExecuted());
        System.out.println("done");
    }

}
