package com.example.gonuts.tests;

import com.example.gonuts.Ghosts;
import com.example.gonuts.MainActivity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class checkGhostsTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testCheckGhosts() {
        // Call the checkGhosts() method
        activity.checkGhosts();

        // Verify that ghost coordinates are not inside a wall
        assertFalse(isCoordinateInWall(activity.ghost1PosX, activity.ghost1PosY));
        assertFalse(isCoordinateInWall(activity.ghost2PosX, activity.ghost2PosY));
        assertFalse(isCoordinateInWall(activity.ghost3PosX, activity.ghost3PosY));
        assertFalse(isCoordinateInWall(activity.ghost4PosX, activity.ghost4PosY));
    }


    // Helper method to check if a coordinate is inside a wall
    private boolean isCoordinateInWall(int x, int y) {
        return activity.mazeArray[y][x] == 0; // Assuming 0 represents a wall
    }
}