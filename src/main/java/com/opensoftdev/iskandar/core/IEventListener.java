/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.core;

import java.util.EventListener;

/**
 *
 * @author alastair
 */
public interface IEventListener extends EventListener{

    void handleEvent(IEvent e);

}
