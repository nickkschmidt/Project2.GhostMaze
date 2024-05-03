package com.example.gonuts.tests;

import static org.junit.Assert.*;

import com.example.gonuts.Ghosts;
import com.example.gonuts.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class initGhostsTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testInitGhosts() {
        // Set ghost coordinates to known values
        activity.ghost1PosX = 1;
        activity.ghost1PosY = 2;
        activity.ghost2PosX = 3;
        activity.ghost2PosY = 4;
        activity.ghost3PosX = 5;
        activity.ghost3PosY = 6;
        activity.ghost4PosX = 7;
        activity.ghost4PosY = 8;

        // Call the initGhosts() method
        activity.initGhosts();
    }
}
