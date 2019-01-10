package com.company;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker implements Runnable {
    private static final int MAGIC_NUMBER = 80;
    private final LinkedBlockingQueue<PuzzleState> queue;
    private final Set<Puzzle> visited;
    private final PuzzleSolution solution;

    Worker(LinkedBlockingQueue<PuzzleState> queue, Set<Puzzle> visited, PuzzleSolution solution) {
        this.queue = queue;
        this.visited = visited;
        this.solution = solution;
    }

    public void run() {
        while (true) {

            synchronized (solution) {
                if (solution.isPresent()) {
                    return;
                }
            }

            PuzzleState state;
            try {
                state = queue.take();

                synchronized (solution) {
                    if (state.getPuzzle().isSolved()) {
                        solution.setMoves(state.getMoves());
                        return;
                    }
                }


                if (state.getMoves().size() > MAGIC_NUMBER) {
                    return;
                }

                addNewMoves(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewMoves(PuzzleState state) {
        for (PuzzleMove move : PuzzleMove.values()) {
            Optional<Puzzle> newPuzzle = move.doMove(state.getPuzzle());
            if (newPuzzle.isPresent()) {
                if (!visited.contains(newPuzzle.get())) {
                    visited.add(newPuzzle.get());
                    ArrayList<PuzzleMove> puzzleMoves = new ArrayList<>(state.getMoves());
                    puzzleMoves.add(move);
                    queue.offer(new PuzzleState(newPuzzle.get(), puzzleMoves));
                }
            }
        }
    }
}
