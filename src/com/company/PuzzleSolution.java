package com.company;

import java.util.List;

public class PuzzleSolution {
    private List<PuzzleMove> moves;

    public List<PuzzleMove> getMoves() {
        return moves;
    }

    public void setMoves(List<PuzzleMove> moves) {
        this.moves = moves;
    }

    public boolean isPresent() {
        return moves != null;
    }

    public String toString() {
        return moves.toString();
    }
}
