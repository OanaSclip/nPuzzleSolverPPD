package com.company;

import java.util.Optional;
import java.util.Random;

public class PuzzleShuffler {

    public Puzzle shuffle(int seed, int moves) {
        Puzzle puzzle = Puzzle.correctPuzzle;

        Random random = new Random(seed);

        while (moves > 0) {
            PuzzleMove puzzleMove = PuzzleMove.values()[random.nextInt(4)];
            Optional<Puzzle> optionalPuzzle = puzzleMove.doMove(puzzle);
            if (optionalPuzzle.isPresent()) {
                puzzle = optionalPuzzle.get();
                moves--;
            }
        }
        return puzzle;
    }

}
