package com.example.gonuts.tests;

import static org.junit.Assert.*;

import com.example.gonuts.Ghosts;
import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class ghostCoordsTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testSetGhostCoords() {
        // Call the setGhostCoords() method
        activity.setGhostCoords();

        // Verify that ghost coordinates are within the expected range
        assertTrue(activity.ghost1PosX >= 0 && activity.ghost1PosX < 13);
        assertTrue(activity.ghost1PosY >= 0 && activity.ghost1PosY < 21);
        assertTrue(activity.ghost2PosX >= 0 && activity.ghost2PosX < 13);
        assertTrue(activity.ghost2PosY >= 0 && activity.ghost2PosY < 21);
        assertTrue(activity.ghost3PosX >= 0 && activity.ghost3PosX < 13);
        assertTrue(activity.ghost3PosY >= 0 && activity.ghost3PosY < 21);
        assertTrue(activity.ghost4PosX >= 0 && activity.ghost4PosX < 13);
        assertTrue(activity.ghost4PosY >= 0 && activity.ghost4PosY < 21);
    }
}
