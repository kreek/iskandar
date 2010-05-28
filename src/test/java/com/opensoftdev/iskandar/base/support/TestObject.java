package com.opensoftdev.iskandar.base.support;

import com.google.inject.Inject;


public class TestObject implements ITestObject {

    private boolean _commandExecuted = false;

    public boolean isCommandExecuted() {
        return _commandExecuted;
    }

    public void setCommandExecuted(boolean _commandExecuted) {
        this._commandExecuted = _commandExecuted;
    }

    @Inject
    public TestObject() {

    }

}
