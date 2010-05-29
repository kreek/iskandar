package com.opensoftdev.iskandar.core;

import com.opensoftdev.iskandar.base.Event;
import java.util.EventListener;

public interface IEventListener extends EventListener{

    void handleEvent(Event e);

}
