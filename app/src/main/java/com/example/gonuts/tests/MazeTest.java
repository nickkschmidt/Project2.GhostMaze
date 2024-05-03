package com.example.gonuts.tests;

import android.widget.RelativeLayout;
import android.widget.ImageView;
import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;
import com.example.gonuts.R;

import org.junit.Test;
import org.junit.runner.RunWith;

public class MazeTest {

    @Test
    public void testUpdateMaze() {
        // Define rows and columns
        int rows = 21;
        int cols = 13;

        // Create instance of your class where updateMaze method resides
        MainActivity test= new MainActivity();

        // Create a RelativeLayout
        RelativeLayout mazeLayout = test.findViewById(R.id.mazeLayout);

        // Create a mock mazeArray for testing
        int[][] mazeArraytest = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //0
                {2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2}, //1
                {2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2}, //2
                {2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2}, //3
                {2, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //4
                {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //5
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //6
                {2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2}, //7
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //8
                {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2}, //9
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2}, //10
                {2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2, 0, 2}, //11
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2}, //12
                {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //13
                {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 2, 2}, //14
                {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //15
                {2, 0, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2}, //16
                {2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2}, //17
                {2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2}, //18
                {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //19
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //20
        };

        // Set the mazeArray
        test.mazeArray = mazeArraytest;

        // Call updateMaze method
        test.updateMaze(mazeLayout, rows, cols);

        // Assertions to check if dots are added properly
        assertEquals((rows - 1) * (cols - 1), mazeLayout.getChildCount());

        // Add more assertions as needed to test the behavior of your updateMaze method
        // For example, you can check if the positions of the dots are correct, if the correct images are set, etc.
    }
}
