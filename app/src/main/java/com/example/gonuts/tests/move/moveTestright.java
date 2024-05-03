package com.example.gonuts.tests.move;

import android.widget.RelativeLayout;
import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class moveTestright {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testMoveright() {
        // Setup initial conditions
        activity.pacmanPositionX = 0;
        activity.pacmanPositionY = 0;

        activity.score = 0;

        // Call the moveRight() method
        activity.moveRight();

        // Verify that the pacman position has been updated correctly
        assertEquals(1, activity.pacmanPositionX);

        // Verify that the score has been updated correctly
        assertEquals(1, activity.score);
    }
}
