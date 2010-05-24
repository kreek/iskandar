package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.opensoftdev.iskandar.core.IIskandar;
import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase {

    private IIskandar iskandar;

    @Override
    protected void setUp() {
        Injector injector = Guice.createInjector();
        iskandar = injector.getInstance(IIskandar.class);
    }
    
    public IskandarTestCase(String name) {
        super(name);
    }

    public void test_getInstanceNotNull() {
        assertNotNull(iskandar);
    }

    public void test_commandMapNotNull() {
        assertNotNull(iskandar.getCommandMap());
    }

    public void test_eventDipatcherNotNull() {
        assertNotNull(iskandar.getEventDispatcher());
    }

    public void test_eventDipatcherInCommandMapNotNull() {
        assertNotNull(iskandar.getCommandMap().getEventDispatcher());
    }

}
