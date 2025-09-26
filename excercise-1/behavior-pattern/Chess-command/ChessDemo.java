// Client
public class ChessDemo {
    public static void main(String[] args) {
        Chess chess = new Chess();
        ChessController controller = new ChessController();

        // Add commands
        controller.addCommand(new MoveCommand(chess, "Knight", "g1", "f3"));
        controller.addCommand(new CastleCommand(chess, "e1", "g1", "h1", "f1"));

        // Execute
        controller.executeCommand(0); // Knight move
        controller.executeCommand(1); // Castling

        // Undo
        System.out.println("--- Undo last ---");
        controller.undoLastCommand();

        System.out.println("--- Undo last ---");
        controller.undoLastCommand();
    }
}
