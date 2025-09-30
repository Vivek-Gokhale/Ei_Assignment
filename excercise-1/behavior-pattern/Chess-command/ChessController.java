import java.util.ArrayList;
// Invoker
class ChessController {
    private ArrayList<Command> commandSlots = new ArrayList<>();
    private ArrayList<Command> history = new ArrayList<>();

    // Add command
    public void addCommand(Command command) {
        commandSlots.add(command);
    }

    // Execute command by index
    public void executeCommand(int index) {
        if (index >= 0 && index < commandSlots.size()) {
            Command cmd = commandSlots.get(index);
            cmd.execute();
            history.add(cmd);
        } else {
            System.out.println("No command at index " + index);
        }
    }

    // Undo last command
    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command last = history.remove(history.size() - 1);
            last.undo();
        } else {
            System.out.println("No commands to undo!");
        }
    }
}