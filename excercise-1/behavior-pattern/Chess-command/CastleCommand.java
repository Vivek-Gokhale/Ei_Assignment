// Concrete Command: Castle
class CastleCommand implements Command {
    private Chess chess;  // receiver
    private String kingFrom, kingTo, rookFrom, rookTo;

    public CastleCommand(Chess chess, String kingFrom, String kingTo, String rookFrom, String rookTo) {
        this.chess = chess;
        this.kingFrom = kingFrom;
        this.kingTo = kingTo;
        this.rookFrom = rookFrom;
        this.rookTo = rookTo;
    }

    @Override
    public void execute() {
        chess.castle(kingFrom, kingTo, rookFrom, rookTo); // execute castling
    }

    @Override
    public void undo() {
        chess.undoCastle(kingFrom, kingTo, rookFrom, rookTo); // undo castling
    }
}

