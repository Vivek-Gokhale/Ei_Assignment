// Concrete Command: Move
class MoveCommand implements Command {
    private Chess chess;
    private String piece, from, to;

    public MoveCommand(Chess chess, String piece, String from, String to) {
        this.chess = chess;
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        chess.movePiece(piece, from, to);
    }

    @Override
    public void undo() {
        chess.undoMove(piece, from, to);
    }
}
