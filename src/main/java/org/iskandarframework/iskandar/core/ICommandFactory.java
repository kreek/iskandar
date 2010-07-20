package org.iskandarframework.iskandar.core;

/**
 * This interface is used for using Iskandar with DI frameworks such as Guice or
 * Spring.  These frameworks require the framework to instantiate everything so
 * using regular reflection does not work
 */
public interface ICommandFactory {

    /**
     * The interface should use the DI framework to create or get an instance of
     * the command
     * @return
     */
    ICommand getCommand();

}
