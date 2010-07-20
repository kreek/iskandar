package org.iskandarframework.iskandar.core;

/**
 *  This is the type of the events that Iskandar can understand.  All application
 *  Events must implement this type
 */
public interface IEvent {

    /**
     * This is the type of the event.  It is a string but should be created
     * as an enum in the app and passed as a string to prevent duplicate event
     * names
     * @return String
     */
    String getEventType();

    /**
     * This is teh payload for the event.  It is whatever the dispatching view
     * or model wants to send to the controller (command)
     * @return Object
     */
    Object getEventPayload();
}
