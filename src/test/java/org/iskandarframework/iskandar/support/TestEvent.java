package org.iskandarframework.iskandar.support;

import org.iskandarframework.iskandar.core.IEvent;


public class TestEvent implements IEvent {

    private IIskandarTestEvents.events _e;
    private Object _payload;

    public Object getEventPayload() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getEventType() {

        return this._e.toString();
    }

    public TestEvent(IIskandarTestEvents.events e) {

        this._e = e;
    }
}
