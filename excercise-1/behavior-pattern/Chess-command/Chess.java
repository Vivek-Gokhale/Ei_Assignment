// Receiver: knows how to perform actual chess actions
class Chess {
    public void movePiece(String piece, String from, String to) {
        System.out.println(piece + " moved from " + from + " to " + to);
    }

    public void undoMove(String piece, String from, String to) {
        System.out.println("Undo move: " + piece + " moved back from " + to + " to " + from);
    }

    public void castle(String kingFrom, String kingTo, String rookFrom, String rookTo) {
        System.out.println("Castling: King " + kingFrom + " → " + kingTo +
                           " and Rook " + rookFrom + " → " + rookTo);
    }

    public void undoCastle(String kingFrom, String kingTo, String rookFrom, String rookTo) {
        System.out.println("Undo castling: King " + kingTo + " → " + kingFrom +
                           " and Rook " + rookTo + " → " + rookFrom);
    }
}