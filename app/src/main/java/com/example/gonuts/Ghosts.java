package com.example.gonuts;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class Ghosts extends MainActivity {

    /**
     * Generates a random x-coordinate for placing a ghost within the maze.
     *
     * @return A random integer representing the x-coordinate for placing a ghost.
     */
    public static int setGhostX() {
        int min = 0;
        int max = 12;
        Random random = new Random();
        int coord = random.nextInt(max - min) + min;
        return coord;
    }

    /**
     * Generates a random y-coordinate for placing a ghost within the maze.
     *
     * @return A random integer representing the y-coordinate for placing a ghost.
     */
    public static int setGhostY() {
        int min = 0;
        int max = 20;
        Random random = new Random();
        int coord = random.nextInt(max - min) + min;
        return coord;
    }


}
