/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.core;

import java.util.Map;


/**
 *
 * @author alastair
 */
public interface IViewHandler{


    Map<String, Object> getViewMap();
    void setView(String view);



}