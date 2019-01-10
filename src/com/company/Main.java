package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Puzzle puzzle = new PuzzleShuffler().shuffle(123, 80);
        System.out.println(puzzle.toString());

        PuzzleSolution solve = new Solver(8).solve(puzzle);
        System.out.println(solve);
    }
}
