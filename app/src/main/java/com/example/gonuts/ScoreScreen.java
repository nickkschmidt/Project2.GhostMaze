package com.example.gonuts;

import android.os.Bundle;
import android.widget.TextView;


public class ScoreScreen extends MainActivity {
    public TextView scoreText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        scoreText = findViewById(R.id.scoreTextView);

    }
}
