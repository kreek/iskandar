package com.opensoftdev.iskandar.base;

import com.google.inject.Guice;
import com.google.inject.Injector;
import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase {

    private final Injector injector = Guice.createInjector();
    
    public IskandarTestCase(String name) {
        super(name);
    }

    public void test_getInstanceNoNull() {
        Iskandar obj = injector.getInstance(Iskandar.class);
        assertNotNull(obj);
    }

    public void test_init_CommandMapNotNull() {
        Iskandar obj = injector.getInstance(Iskandar.class);
        assertNotNull(obj.getCommandMap());
    }

    public void test_init_EventDipatcherNotNull() {
        Iskandar obj = injector.getInstance(Iskandar.class);
        assertNotNull(obj.getEventDispatcher());
    }

    public void test_init_EventDipatcherInCommandMapNotNull() {
        Iskandar obj = injector.getInstance(Iskandar.class);
        assertNotNull(obj.getCommandMap().getEventDispatcher());
    }

}
