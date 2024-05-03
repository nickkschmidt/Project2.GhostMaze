package com.example.gonuts.tests.move;

import static org.junit.Assert.assertEquals;

import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class moveTestup {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testMoveup() {
        // Setup initial conditions
        activity.pacmanPositionX = 0;
        activity.pacmanPositionY = 1;

        activity.score = 0;

        // Call the moveRight() method
        activity.moveUp();

        // Verify that the pacman position has been updated correctly
        assertEquals(0, activity.pacmanPositionY);

        // Verify that the score has been updated correctly
        assertEquals(1, activity.score);
    }
}
