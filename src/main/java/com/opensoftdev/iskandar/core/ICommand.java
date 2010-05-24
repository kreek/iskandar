/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.core;

/**
 *
 * @author alastair
 */
public interface ICommand {
    public void execute(IIskandarEvent e);
}
