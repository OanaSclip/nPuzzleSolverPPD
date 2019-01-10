package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Puzzle {
    private Integer n;
    private List<Integer> puzzleState;
    public static Puzzle correctPuzzle = new Puzzle(4, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0));

    public Puzzle(Integer n, List<Integer> puzzleState) {
        this.n = n;
        this.puzzleState = puzzleState;
    }

    public List<Integer> getPuzzleState() {
        return puzzleState;
    }

    public Integer getN() {
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puzzle puzzle = (Puzzle) o;
        return puzzle.puzzleState.equals(this.puzzleState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(puzzleState);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n * n; i++) {
            s.append(String.format("%2s ", puzzleState.get(i)));
            if ((i + 1) % n == 0) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    public Puzzle swap(int i, int j) {
        List<Integer> newPuzzleState = new ArrayList<>(puzzleState);
        Integer temp = newPuzzleState.get(i);
        newPuzzleState.set(i, newPuzzleState.get(j));
        newPuzzleState.set(j, temp);
        return new Puzzle(n, newPuzzleState);
    }

    public Integer getBlankPosition() {
        return puzzleState.indexOf(0);
    }

    public boolean isSolved() {
        return correctPuzzle.equals(this);
    }
}
