package org.iskandarframework.iskandar.core;



/**
 * This is the type of the event listener.  It listens for dispatched events and
 * the concrete instance of this routes the event to the correct command
 */
public interface IEventListener {

    /**
     * Takes in a type IEvent
     * @param IEvent e
     */
    void handleEvent(IEvent e);

}
