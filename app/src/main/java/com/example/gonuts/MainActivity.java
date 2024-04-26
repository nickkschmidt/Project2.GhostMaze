package com.example.gonuts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        updateMaze(mazeLayout, 21, 13);

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveRight function
//                CharSequence text = "Hello toast!";
//                int duration = Toast.LENGTH_SHORT;
//                Toast toast = Toast.makeText(MainActivity.this,text, duration);
//                toast.show();
                moveRight();
            }
        });


    }



    public static int score = 0;

    private Button button;

    static int[][] mazeArray = {         /* 0 = wall/no path, 1 = path + no pellet, 2 = path + pellet,
                                            maze coordinates are in (x, y)  */
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //1
            {2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2}, //2
            {2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2}, //3
            {2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2}, //4
            {2, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //5
            {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //6
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //7
            {2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2}, //8
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //9
            {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2}, //10
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2}, //11
            {2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2, 0, 2}, //12
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2}, //13
            {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //14
            {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 2, 2}, //15
            {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //16
            {2, 0, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2}, //17
            {2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2}, //18
            {2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2}, //19
            {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2}, //20
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //21

    };


    public void updateMaze(RelativeLayout mazeLayout, int rows, int cols) {
        // Define dot size
        int dotSize = 5; // in dp

        // Define margin between dots
        float horizontalMargin = 60.3F; // in dp
        float verticalMargin = 60.4F;

        // Calculate total width and height of the maze
        float mazeWidth = cols * dotSize + (cols - 1) * horizontalMargin;
        float mazeHeight = rows * dotSize + (rows - 1) * verticalMargin;

        // Calculate horizontal and vertical spacing between dots
        float horizontalSpacing = dotSize + horizontalMargin;
        float verticalSpacing = dotSize + verticalMargin;

        int startLeft = 158;
        int startTop = 158;

        // Loop through rows and columns to add dots
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate position of the dot
                float leftMargin = startLeft + j * (horizontalSpacing);
                float topMargin = startTop + i * (verticalSpacing);

                // Create a new ImageView for the dot
                ImageView dot = new ImageView(this);
                // Set layout parameters for the dot
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        (dotSize), (dotSize));
                params.leftMargin = (int) leftMargin;
                params.topMargin = (int) topMargin;
                dot.setLayoutParams(params);
                if (mazeArray[i][j] == 2) {
                    dot.setImageResource(R.drawable.dot);
                } else if (mazeArray[i][j] == 1){
                    dot.setImageResource(R.drawable.dotblue);
                }
                else if (mazeArray[i][j] == 0) {
                    dot.setImageResource(R.drawable.dotblack);
                }
                // Add the dot to the maze layout
                mazeLayout.addView(dot);
            }
        }
        }

    public static int pacmanPositionX = 0;
    public static int pacmanPositionY = 0;


    public void moveRight() {
        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        if (mazeArray[pacmanPositionX][pacmanPositionY] > 0) {
            pacmanPositionX += 1;
            if (mazeArray[pacmanPositionX][pacmanPositionY] == 2) {
                mazeArray[pacmanPositionX][pacmanPositionY] = 1;
                score++;
                updateMaze(mazeLayout, 21, 13);
            }
        }

        if (pacmanPositionX > 13) {
            pacmanPositionX = 13;
        }

    }

    public void moveLeft() {
        pacmanPositionX -= 1;
        if (pacmanPositionX < 0) {
            pacmanPositionX = 0;
        }
    }

    public void moveDown() {
        pacmanPositionY += 1;
        if (pacmanPositionY > 21) {
            pacmanPositionY = 21;
        }

    }

    public void moveUp() {
        pacmanPositionY -= 1;
        if (pacmanPositionY < 0) {
            pacmanPositionY = 0;
        }

    }

}




