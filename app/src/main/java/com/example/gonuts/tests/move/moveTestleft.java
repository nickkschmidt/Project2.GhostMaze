package com.example.gonuts.tests.move;

import static org.junit.Assert.assertEquals;

import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class moveTestleft {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testMoveleft() {
        // Setup initial conditions
        activity.pacmanPositionX = 1;
        activity.pacmanPositionY = 0;

        activity.score = 0;

        // Call the moveRight() method
        activity.moveLeft();

        // Verify that the pacman position has been updated correctly
        assertEquals(0, activity.pacmanPositionX);

        // Verify that the score has been updated correctly
        assertEquals(1, activity.score);
    }
}
