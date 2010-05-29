package com.opensoftdev.iskandar.core;

public interface ICommandFactory {
    ICommand create(IEvent event);
}
