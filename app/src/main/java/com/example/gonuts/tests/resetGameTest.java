package com.example.gonuts.tests;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;
import com.example.gonuts.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class resetGameTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }

    @Test
    public void testResetGame() {
        // Call the resetGame() method
        mainActivity.resetGame();

        // Verify that the activity is set with the correct layout
        Assert.assertEquals(R.layout.activity_main, mainActivity.getWindow().getDecorView().getRootView().findViewById(android.R.id.content).getId());

        // Verify that the score is reset to 0
        assertEquals(0, mainActivity.score);

        // Verify that mazeArray is reset to its original state
        // (You need to provide the original state of mazeArray and mazeArraytemp)
        assertArrayEquals(mainActivity.mazeArraytemp, mainActivity.mazeArray);

        // Verify that mazeLayout is updated
        RelativeLayout mazeLayout = mainActivity.findViewById(R.id.mazeLayout);
        assertNotNull(mazeLayout);

        // Verify that buttons and click listeners are set correctly
        Button buttonright = mainActivity.findViewById(R.id.buttonright);
        Button buttondown = mainActivity.findViewById(R.id.buttondown);
        Button buttonleft = mainActivity.findViewById(R.id.buttonleft);
        Button buttonup = mainActivity.findViewById(R.id.buttonup);
        View temp = mainActivity.findViewById(R.id.temp);
        View temp2 = mainActivity.findViewById(R.id.temp2);

        assertNotNull(buttonright);
        assertNotNull(buttondown);
        assertNotNull(buttonleft);
        assertNotNull(buttonup);
        assertNotNull(temp);
        assertNotNull(temp2);
    }
}
