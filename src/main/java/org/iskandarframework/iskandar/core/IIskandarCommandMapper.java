package org.iskandarframework.iskandar.core;

/**
 * This type should be implemented on the main or any facade that may exist in
 * the application.  It requires the implementation of mapping classes.  It is
 * not neccessary to implement this as it it optional at this point
 */
public interface IIskandarCommandMapper {

    void mapCommands();

}
