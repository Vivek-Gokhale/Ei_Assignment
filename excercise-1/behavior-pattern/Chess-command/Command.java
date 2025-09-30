// Command interface: declares execute and undo methods
public interface Command {
    void execute(); // perform the action
    void undo();    // undo the action
}