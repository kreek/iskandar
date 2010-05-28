/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensoftdev.iskandar.base.support;

import com.google.inject.ImplementedBy;

@ImplementedBy(TestObject.class)
public interface ITestObject {
    boolean isCommandExecuted();
    void setCommandExecuted(boolean _commandExecuted);
}
