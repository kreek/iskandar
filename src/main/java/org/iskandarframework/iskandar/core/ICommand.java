package org.iskandarframework.iskandar.core;

/**
 * This is the interface to a single command.  All it needs to interface is an
 * execute method
 */
public interface ICommand {
    
    /**
     * This method gets invoked by the framework when the concrete command gets
     * dispatched.  The IEvent is the event that gets dispatched from the
     * deriving app.
     * @param IEvent e  The event that was dipatched
     */
    public void execute(IEvent e);
}
