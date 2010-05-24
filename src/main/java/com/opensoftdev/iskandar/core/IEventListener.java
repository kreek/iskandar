package com.opensoftdev.iskandar.core;

import java.util.EventListener;

public interface IEventListener extends EventListener{

    void handleEvent(IIskandarEvent e);

}
