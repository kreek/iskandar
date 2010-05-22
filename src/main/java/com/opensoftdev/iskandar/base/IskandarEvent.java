/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base;

/**
 *
 * @author alastair
 */
public abstract class IskandarEvent {


    private String _eventType;

    public String getEventType() {
        return _eventType;
    }

    public IskandarEvent(String type){
        
        this._eventType = type;
    }

}
