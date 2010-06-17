package org.iskandarframework.iskandar.core;

import java.util.EventListener;

public interface IEventListener extends EventListener{

    void handleEvent(IEvent e);

}
