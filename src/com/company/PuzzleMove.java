package com.company;

import java.util.Optional;

public enum PuzzleMove {
    DOWN {
        protected Puzzle move(Puzzle puzzle, Integer blankPosition) {
            return puzzle.swap(blankPosition, blankPosition + puzzle.getN());
        }

        public boolean canMove(Puzzle puzzle, Integer blankPosition) {
            return blankPosition  < puzzle.getPuzzleState().size() - puzzle.getN();
        }
    },
    UP {
        protected Puzzle move(Puzzle puzzle, Integer blankPosition) {
            return puzzle.swap(blankPosition, blankPosition - puzzle.getN());
        }

        public boolean canMove(Puzzle puzzle, Integer blankPosition) {
            return blankPosition >= puzzle.getN();
        }
    },
    LEFT {
        protected Puzzle move(Puzzle puzzle, Integer blankPosition) {
            return puzzle.swap(blankPosition, blankPosition-1);
        }

        public boolean canMove(Puzzle puzzle, Integer blankPosition) {
            return blankPosition % puzzle.getN() != 0;
        }
    },
    RIGHT {
        protected Puzzle move(Puzzle puzzle, Integer blankPosition) {
            return puzzle.swap(blankPosition, blankPosition+1);
        }

        public boolean canMove(Puzzle puzzle, Integer blankPosition) {
            return (blankPosition + 1) % puzzle.getN() != 0;
        }
    };


    protected abstract Puzzle move(Puzzle puzzle, Integer blankPosition);

    public abstract boolean canMove(Puzzle puzzle, Integer blankPosition);

    public Optional<Puzzle> doMove(Puzzle puzzle) {
        Integer blankPosition = puzzle.getBlankPosition();
        if (!canMove(puzzle, blankPosition)) {
            return Optional.empty();
        }
        return Optional.of(move(puzzle, blankPosition));
    }
}
