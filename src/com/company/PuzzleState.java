package com.company;

import java.util.List;

public class PuzzleState {
    private Puzzle puzzle;
    private List<PuzzleMove> moves;

    public PuzzleState(Puzzle puzzle, List<PuzzleMove> moves) {
        this.puzzle = puzzle;
        this.moves = moves;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public List<PuzzleMove> getMoves() {
        return moves;
    }
}
