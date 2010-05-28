/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.core;

import com.google.inject.ImplementedBy;
import com.opensoftdev.iskandar.base.Command;

@ImplementedBy(Command.class)
public interface ICommand {
    void execute();
}
