package com.example.gonuts;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        addDotsToMaze(mazeLayout, 21, 13);
    }

    private void addDotsToMaze(RelativeLayout mazeLayout, int rows, int cols) {
        // Define dot size
        int dotSize = 5; // in dp

        // Define margin between dots
        int horizontalMargin = 35; // in dp
        int verticalMargin = 35;

        // Calculate total width and height of the maze
        int mazeWidth = cols * horizontalMargin;
        int mazeHeight = rows * verticalMargin;

        // Calculate horizontal and vertical spacing between dots
        int horizontalSpacing = dotSize + horizontalMargin;
        int verticalSpacing = dotSize + verticalMargin;

        // Loop through rows and columns to add dots
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate position of the dot
                int leftMargin = j * (horizontalSpacing + 30);
                int topMargin = i * (verticalSpacing + 30);

                // Create a new ImageView for the dot
                ImageView dot = new ImageView(this);
                dot.setImageResource(R.drawable.dot);

                // Set layout parameters for the dot
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        (dotSize), (dotSize));
                params.leftMargin = (leftMargin);
                params.topMargin = (topMargin);
                dot.setLayoutParams(params);

                // Add the dot to the maze layout
                mazeLayout.addView(dot);
            }
        }
    }

}


