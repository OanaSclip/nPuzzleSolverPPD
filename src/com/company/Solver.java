package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solver {
    private Integer threadNumber;

    public Solver(Integer threadNumber) {
        this.threadNumber = threadNumber;
    }

    public PuzzleSolution solve(Puzzle puzzle) throws InterruptedException {
        LinkedBlockingQueue<PuzzleState> queue = new LinkedBlockingQueue<>();
        Set<Puzzle> visited = Collections.newSetFromMap(new ConcurrentHashMap<>());

        queue.offer(new PuzzleState(puzzle, Collections.emptyList()));
        visited.add(puzzle);

        PuzzleSolution solution = new PuzzleSolution();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadNumber; i++) {
            threadList.add(new Thread(new Worker(queue, visited, solution)));
        }

        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }


        return solution;
    }
}
