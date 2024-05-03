package com.example.gonuts.tests.move;

import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class ghostMoveTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testMoveGhosts() {

        // Set initial positions of ghosts
        activity.ghost1PosX = 1;
        activity.ghost1PosY = 1;
        activity.ghost2PosX = 1;
        activity.ghost2PosY = 1;
        activity.ghost3PosX = 1;
        activity.ghost3PosY = 1;
        activity.ghost4PosX = 1;
        activity.ghost4PosY = 1;

        // Call the moveGhosts() method
        activity.moveGhosts();

        // Verify that ghost positions are updated correctly based on the random directions
        assertEquals(1, activity.ghost1PosX);
        assertEquals(0, activity.ghost1PosY);

        assertEquals(0, activity.ghost2PosX);
        assertEquals(1, activity.ghost2PosY);

        assertEquals(0, activity.ghost3PosX);
        assertEquals(-1, activity.ghost3PosY);

        assertEquals(-1, activity.ghost4PosX);
        assertEquals(0, activity.ghost4PosY);
    }
}
