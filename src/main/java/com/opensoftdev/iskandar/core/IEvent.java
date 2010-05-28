package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.Event;

@ImplementedBy(Event.class)
public interface IEvent {
   String getEventType();
}
