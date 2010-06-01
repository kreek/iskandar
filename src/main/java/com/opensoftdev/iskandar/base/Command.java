package com.opensoftdev.iskandar.base;

import com.google.inject.BindingAnnotation;
import com.opensoftdev.iskandar.core.ICommand;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Command implements ICommand {

    public Command() {
    }

    @Override
    public void execute() {
    }

    public void dispatch() {
        
    }
}