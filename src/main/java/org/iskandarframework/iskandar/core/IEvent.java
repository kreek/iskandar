/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iskandarframework.iskandar.core;

/**
 *
 * @author alastair
 */
public interface IEvent {

    String getEventType();
    Object getEventPayload();
}
