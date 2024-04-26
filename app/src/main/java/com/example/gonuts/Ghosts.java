package com.example.gonuts;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class Ghosts extends MainActivity {

    public static int setGhostX() {
        int min = 2;
        int max = 14;
        Random random = new Random();
        int coord = random.nextInt(max - min) + min;
        return coord;
    }
    public static int setGhostY() {
        int min = 2;
        int max = 22;
        Random random = new Random();
        int coord = random.nextInt(max - min) + min;
        return coord;
    }


}
