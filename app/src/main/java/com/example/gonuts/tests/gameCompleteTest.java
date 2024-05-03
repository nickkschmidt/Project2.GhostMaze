package com.example.gonuts.tests;

import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class gameCompleteTest {

    private MainActivity maze;

    @Before
    public void setUp() {
        // Initialize the Maze object with a sample mazeArray
        maze = new MainActivity();
    }

    @Test
    public void testGameCompleteWhenMazeIsComplete() {
        // Set up a complete maze (no more 2's left)
        int[][] completeMazeArray = new int[21][13];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 13; j++) {
                completeMazeArray[i][j] = 0; // Assuming 0 represents empty space
            }
        }

        // Test gameComplete() method
        assertTrue(maze.gameComplete());
    }

    @Test
    public void testGameNotCompleteWhenMazeIsIncomplete() {
        // Set up an incomplete maze (at least one 2 left)
        int[][] incompleteMazeArray = new int[21][13];
        incompleteMazeArray[10][5] = 2; // Place a 2 in the maze


        // Test gameComplete() method
        assertFalse(maze.gameComplete());
    }
}
