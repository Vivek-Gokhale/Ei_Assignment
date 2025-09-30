// Concrete Command: Move a chess piece
class MoveCommand implements Command {
    private Chess chess;  // receiver
    private String piece, from, to; // move details

    public MoveCommand(Chess chess, String piece, String from, String to) {
        this.chess = chess;
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        chess.movePiece(piece, from, to); // execute move
    }

    @Override
    public void undo() {
        chess.undoMove(piece, from, to); // undo move
    }
}
