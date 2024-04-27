package com.example.gonuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;


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

        buttonright = findViewById(R.id.buttonright);

        buttondown = findViewById(R.id.buttondown);

        buttonleft = findViewById(R.id.buttonleft);

        buttonup = findViewById(R.id.buttonup);

        temp = findViewById(R.id.temp);

        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveRight function
                moveRight();
            }
        });

        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveDown function
                moveDown();
            }
        });

        buttonleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveLeft function
                moveLeft();
            }
        });


        buttonup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveUp function
                moveUp();
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the moveUp function
                setContentView(R.layout.layout);
            }
        });

        initGhosts();
    }

    public static int score = 0;
    TextView scoreTextView;

    private Button buttonright;
    private Button buttondown;
    private Button buttonleft;
    private Button buttonup;
    private Button temp;

    static int[][] mazeArray = {         /* 0 = wall/no path, 1 = path + no pellet, 2 = path + pellet,
                                            maze coordinates are in (x, y)  */
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
                } else if (mazeArray[i][j] == 1) {
                    dot.setImageResource(R.drawable.dotblue);
                } else if (mazeArray[i][j] == 0) {
                    dot.setImageResource(R.drawable.dotblack);
                }
                // Add the dot to the maze layout
                if ((i != 0) || (j != 0)) {
                    mazeLayout.addView(dot);
                }
            }
        }
        if (gameComplete()) {
            setContentView(R.layout.layout);
        }
    }

    public boolean gameComplete() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 13; j++) {
                if (mazeArray[i][j] == 2) return false;
            }
        }
        return true;
    }


    public static int pacmanPositionX = 0;
    public static int pacmanPositionY = 0;

    public void moveRight() {
        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        if (mazeArray[pacmanPositionY][pacmanPositionX] > 0) {
            if ((pacmanPositionX + 1 < 13) && (mazeArray[pacmanPositionY][pacmanPositionX + 1] != 0)) {
                pacmanPositionX += 1;
                score++;
                scoreTextView = findViewById(R.id.scoreTextView);
                scoreTextView.setText("Score: " + score);
                if (mazeArray[pacmanPositionY][pacmanPositionX] == 2) {
                    mazeArray[pacmanPositionY][pacmanPositionX] = 1;
                    updateMaze(mazeLayout, 21, 13);
                }
                ImageView pacmanImageView = findViewById(R.id.pacman);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pacmanImageView.getLayoutParams();
                params.leftMargin += 66;
                pacmanImageView.setLayoutParams(params);
                moveGhosts();
            }

            else {
                Toast.makeText(getApplicationContext(), "You cannot movein that Direction!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void moveLeft() {
        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        if (mazeArray[pacmanPositionY][pacmanPositionX] > 0) {
            if ((pacmanPositionX - 1 >= 0) && (mazeArray[pacmanPositionY][pacmanPositionX - 1] != 0)) {
                pacmanPositionX -= 1;
                score++;
                scoreTextView = findViewById(R.id.scoreTextView);
                scoreTextView.setText("Score: " + score);
                if (mazeArray[pacmanPositionY][pacmanPositionX] == 2) {
                    mazeArray[pacmanPositionY][pacmanPositionX] = 1;
                    updateMaze(mazeLayout, 21, 13);
                }
                ImageView pacmanImageView = findViewById(R.id.pacman);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pacmanImageView.getLayoutParams();
                params.leftMargin -= 66;
                pacmanImageView.setLayoutParams(params);
                moveGhosts();
            }
            else {
                Toast.makeText(getApplicationContext(), "You cannot movein that Direction!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void moveDown() {
        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        if (mazeArray[pacmanPositionY][pacmanPositionX] > 0) {
            if ((pacmanPositionY + 1 < 21) && (mazeArray[pacmanPositionY + 1][pacmanPositionX] != 0)) {
                pacmanPositionY += 1;
                score++;
                scoreTextView = findViewById(R.id.scoreTextView);
                scoreTextView.setText("Score: " + score);
                if (mazeArray[pacmanPositionY][pacmanPositionX] == 2) {
                    mazeArray[pacmanPositionY][pacmanPositionX] = 1;
                    updateMaze(mazeLayout, 21, 13);
                }
                ImageView pacmanImageView = findViewById(R.id.pacman);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pacmanImageView.getLayoutParams();
                params.topMargin += 66;
                pacmanImageView.setLayoutParams(params);
                moveGhosts();
            }
            else {
                Toast.makeText(getApplicationContext(), "You cannot movein that Direction!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void moveUp() {
        RelativeLayout mazeLayout = findViewById(R.id.mazeLayout);
        if (mazeArray[pacmanPositionY][pacmanPositionX] > 0) {
            if ((pacmanPositionY - 1 >= 0) && (mazeArray[pacmanPositionY - 1][pacmanPositionX] != 0)) {
                pacmanPositionY -= 1;
                score++;
                scoreTextView = findViewById(R.id.scoreTextView);
                scoreTextView.setText("Score: " + score);
                if (mazeArray[pacmanPositionY][pacmanPositionX] == 2) {
                    mazeArray[pacmanPositionY][pacmanPositionX] = 1;
                    updateMaze(mazeLayout, 21, 13);
                }
                ImageView pacmanImageView = findViewById(R.id.pacman);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pacmanImageView.getLayoutParams();
                params.topMargin -= 66F;
                pacmanImageView.setLayoutParams(params);
                moveGhosts();
            }
            else {
                Toast.makeText(getApplicationContext(), "You cannot movein that Direction!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    int randomDir1 = 0;
    int randomDir2 = 0;
    int randomDir3 = 0;
    int randomDir4 = 0;

    public static int ghost1PosX;
    public static int ghost1PosY;
    public static int ghost2PosX;
    public static int ghost2PosY;
    public static int ghost3PosX;
    public static int ghost3PosY;
    public static int ghost4PosX;
    public static int ghost4PosY;

    public void setGhostCoords() {
        ghost1PosX = Ghosts.setGhostX();
        ghost1PosY = Ghosts.setGhostY();
        ghost2PosX = Ghosts.setGhostX();
        ghost2PosY = Ghosts.setGhostY();
        ghost3PosX = Ghosts.setGhostX();
        ghost3PosY = Ghosts.setGhostY();
        ghost4PosX = Ghosts.setGhostX();
        ghost4PosY = Ghosts.setGhostY();
    }

    public void checkGhosts() {
        setGhostCoords();
        boolean ghostinwall = true;

        while (ghostinwall) {
            ghostinwall = false; // Reset ghostinwall to false before checking ghosts

            // Check each ghost's position
            if ((ghost1PosY) >= 0 && (ghost1PosY) < 21 &&
                    (ghost1PosX) >= 0 && (ghost1PosX) < 13 &&
                    mazeArray[ghost1PosY][ghost1PosX] == 0) {
                setGhostCoords(); // Update ghost coordinates if ghost 1 is in a wall
                ghostinwall = true; // Set ghostinwall to true if ghost 1 is in a wall
            }

            if ((ghost2PosY) >= 0 && (ghost2PosY) < 21 &&
                    (ghost2PosX) >= 0 && (ghost2PosX) < 13 &&
                    mazeArray[ghost2PosY][ghost2PosX] == 0) {
                setGhostCoords(); // Update ghost coordinates if ghost 1 is in a wall
                ghostinwall = true; // Set ghostinwall to true if ghost 1 is in a wall
            }

            if ((ghost3PosY) >= 0 && (ghost3PosY) < 21 &&
                    (ghost3PosX) >= 0 && (ghost3PosX) < 13 &&
                    mazeArray[ghost3PosY][ghost3PosX] == 0) {
                setGhostCoords(); // Update ghost coordinates if ghost 1 is in a wall
                ghostinwall = true; // Set ghostinwall to true if ghost 1 is in a wall
            }

            if ((ghost4PosY) >= 0 && (ghost4PosY) < 21 &&
                    (ghost4PosX) >= 0 && (ghost4PosX) < 13 &&
                    mazeArray[ghost4PosY][ghost4PosX] == 0) {
                setGhostCoords(); // Update ghost coordinates if ghost 1 is in a wall
                ghostinwall = true; // Set ghostinwall to true if ghost 1 is in a wall
            }
        }
    }


    public void initGhosts() {
        checkGhosts();
            ImageView ghost1Img = findViewById(R.id.ghost1);
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) ghost1Img.getLayoutParams();
            params1.leftMargin = ((ghost1PosX + 2) * 66);
            params1.topMargin = ((ghost1PosY + 2) * 66);

            ImageView ghost2Img = findViewById(R.id.ghost2);
            RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) ghost2Img.getLayoutParams();
            params2.leftMargin = ((ghost2PosX + 2) * 66);
            params2.topMargin = ((ghost2PosY + 2) * 66);

            ImageView ghost3Img = findViewById(R.id.ghost3);
            RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) ghost3Img.getLayoutParams();
            params3.leftMargin = ((ghost3PosX + 2) * 66);
            params3.topMargin = ((ghost3PosY + 2) * 66);

            ImageView ghost4Img = findViewById(R.id.ghost4);
            RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) ghost4Img.getLayoutParams();
            params4.leftMargin = ((ghost4PosX + 2) * 66);
            params4.topMargin = ((ghost4PosY + 2) * 66);
    }

    public void moveGhosts() {
        Random random1 = new Random();
        randomDir1 = random1.nextInt(4) + 1;
        ImageView ghostImageView1 = findViewById(R.id.ghost1);
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) ghostImageView1.getLayoutParams();

        switch (randomDir1) {
            case 1:
                if (validMove((ghost1PosX + 1), (ghost1PosY))) {
                    ghost1PosX += 1;
                    params1.leftMargin += 66;
                }
                break;
            case 2:
                if (validMove((ghost1PosX - 1), (ghost1PosY))) {
                    ghost1PosX -= 1;
                    params1.leftMargin -= 66;
                }
                break;
            case 3:
                if (validMove((ghost1PosX), (ghost1PosY + 1))) {
                    ghost1PosY += 1;
                    params1.topMargin += 66;
                }
                break;
            case 4:
                if (validMove((ghost1PosX), (ghost1PosY - 1))) {
                    ghost1PosY -= 1;
                    params1.topMargin -= 66;
                }
                break;
        }
        ghostImageView1.setLayoutParams(params1);

        Random random2 = new Random();
        randomDir2 = random2.nextInt(4) + 1;
        ImageView ghostImageView2 = findViewById(R.id.ghost2);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) ghostImageView2.getLayoutParams();

        switch (randomDir2) {
            case 1:
                if (validMove((ghost2PosX + 1), (ghost2PosY))) {
                    ghost2PosX += 1;
                    params2.leftMargin += 66;
                }
                break;
            case 2:
                if (validMove((ghost2PosX - 1), (ghost2PosY))) {
                    ghost2PosX -= 1;
                    params2.leftMargin -= 66;
                }
                break;
            case 3:
                if (validMove((ghost2PosX), (ghost2PosY + 1))) {
                    ghost2PosY += 1;
                    params2.topMargin += 66;
                }
                break;
            case 4:
                if (validMove((ghost2PosX), (ghost2PosY - 1))) {
                    ghost2PosY -= 1;
                    params2.topMargin -= 66;
                }
                break;
        }
        ghostImageView2.setLayoutParams(params2);

        Random random3 = new Random();
        randomDir3 = random3.nextInt(4) + 1;
        ImageView ghostImageView3 = findViewById(R.id.ghost3);
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) ghostImageView3.getLayoutParams();

        switch (randomDir3) {
            case 1:
                if (validMove((ghost3PosX + 1), (ghost3PosY))) {
                    ghost3PosX += 1;
                    params3.leftMargin += 66;
                }
                break;
            case 2:
                if (validMove((ghost3PosX - 1), (ghost3PosY))) {
                    ghost3PosX -= 1;
                    params3.leftMargin -= 66;
                }
                break;
            case 3:
                if (validMove((ghost3PosX), (ghost3PosY + 1))) {
                    ghost3PosY += 1;
                    params3.topMargin += 66;
                }
                break;
            case 4:
                if (validMove((ghost3PosX), (ghost3PosY - 1))) {
                    ghost3PosY -= 1;
                    params3.topMargin -= 66;
                }
                break;
        }
        ghostImageView3.setLayoutParams(params3);

        Random random4 = new Random();
        randomDir4 = random4.nextInt(4) + 1;
        ImageView ghostImageView4 = findViewById(R.id.ghost4);
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) ghostImageView4.getLayoutParams();

        switch (randomDir4) {
            case 1:
                if (validMove((ghost4PosX + 1), (ghost4PosY))) {
                    ghost4PosX += 1;
                    params4.leftMargin += 66;
                }
                break;
            case 2:
                if (validMove((ghost4PosX - 1), (ghost4PosY))) {
                    ghost4PosX -= 1;
                    params4.leftMargin -= 66;
                }
                break;
            case 3:
                if (validMove((ghost4PosX), (ghost4PosY + 1))) {
                    ghost4PosY += 1;
                    params4.topMargin += 66;
                }
                break;
            case 4:
                if (validMove((ghost4PosX), (ghost4PosY - 1))) {
                    ghost4PosY -= 1;
                    params4.topMargin -= 66;
                }
                break;
        }
        ghostImageView4.setLayoutParams(params4);
    }

    public boolean validMove(int x, int y) {
        if (x >= 0 && x < 13 && y >= 0 && y < 21)
            if (mazeArray[y][x] != 0) {
                return true;
        }
        return false;
    }

}




