package com.opensoftdev.iskandar.base;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.opensoftdev.iskandar.core.ICommand;

public class Command implements ICommand {

    protected final Injector _injector;

    @Inject
    public Command(Injector injector) {
        this._injector = injector;
    }

    @Override
    public void execute() {

    }
}