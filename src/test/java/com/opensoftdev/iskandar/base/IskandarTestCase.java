/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

import com.opensoftdev.iskandar.core.ICommand;
import com.opensoftdev.iskandar.core.IEvent;
import junit.framework.TestCase;

/**
 *
 * @author arash
 * @TODO:Finish test cases
 */
public class IskandarTestCase extends TestCase{

    public static class TestCommand implements ICommand{

        @Override
        public void execute(IEvent e) {
            throw new UnsupportedOperationException(e.getEventType());
        }
        
        
    } 
    
    public class TestEvent implements IEvent {

        private IIskandarTestEvents.events _e;
        
        private Object _payload;

        @Override
        public Object getEventPayload() {
            throw new UnsupportedOperationException("Not supported yet.");
        }



        @Override
        public String getEventType() {

            return this._e.toString();
        }
       
        
        public TestEvent(IIskandarTestEvents.events e){
         
            this._e = e;
        }
        

        
    }

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

    public void test_mapEventAndUnmapEvent(){

        Iskandar obj = Iskandar.getInstance();
        obj.init();

       
        try{

            obj.mapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), TestCommand.class);

        }catch(IskandarException e){
          
           assertTrue(false);
        }finally {

            try{

                obj.unmapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString());
            }catch(IskandarException e){

                assertTrue(false);
            }


        }

         assertTrue(true);   

    }



    public void test_dispatchEvent(){
        Iskandar obj = Iskandar.getInstance();
        obj.init();

        ICommand command = new TestCommand();
        IEvent event = new TestEvent(IIskandarTestEvents.events.IskandarUnitTestEvent);

        try{


            obj.mapCommand(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), TestCommand.class);
            try{

                obj.dispatchEvent(event);

            }catch(UnsupportedOperationException e){

                assertEquals(IIskandarTestEvents.events.IskandarUnitTestEvent.toString(), e.getMessage());
            }

        }catch(IskandarException e){

            assertTrue(false);
        }
    }






}
