package com.example.gonuts.tests;

import static org.junit.Assert.*;

import com.example.gonuts.Ghosts;

import org.junit.Test;

public class GhostYXTest {

    @Test
    public void testSetGhostX() {
        for (int i = 0; i < 100; i++) {
            int result = Ghosts.setGhostX();
            // Verify that the result is within the expected range
            assertTrue(result >= 0 && result <= 12);
        }
    }

    @Test
    public void testSetGhostY() {
        for (int i = 0; i < 100; i++) {
            int result = Ghosts.setGhostY();
            // Verify that the result is within the expected range
            assertTrue(result >= 0 && result <= 21);
        }
    }
}