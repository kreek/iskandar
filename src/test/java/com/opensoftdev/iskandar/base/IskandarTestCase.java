/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase{

    public IskandarTestCase(String name) {
        super(name);
        

    }

    public void test_getInstanceNoNull(){

       Iskandar obj = Iskandar.getInstance();
       assertNotNull(obj);
    }

    public void test_init_CommandMapNotNull(){
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getCommandMap());

    }

    public void test_init_EventDipatcherNotNull(){
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getEventDispatcher());

    }

    public void test_init_EventDipatcherInCommandMapNotNull(){
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        assertNotNull(obj.getCommandMap().getEventDispatcher());

    }


}
