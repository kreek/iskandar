/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iskandarframework.iskandar.support;

import org.iskandarframework.iskandar.core.IEvent;

/**
 *
 * @author alastair
 */
public class TestEvent implements IEvent {

    IIskandarTestEvents.events e;

    @Override
    public String getEventType() {
        return this.e.toString();
    }

    public TestEvent(IIskandarTestEvents.events e) {
        this.e = e;
    }
}
