package com.example.gonuts;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseScoreManager {

    private final FirebaseDatabase database;
    private static DatabaseReference scoresRef;

    public FirebaseScoreManager() {
        // Initialize Firebase
        database = FirebaseDatabase.getInstance();

        // Get reference to the "scores" node in the database
        scoresRef = database.getReference("Scores");
        if (scoresRef == null) {
            // Handle initialization failure
            Log.e("FirebaseScoreManager", "Database reference is null");
        }
    }

    public void addScorefire(String nodeName, int score) {
        scoresRef.child(nodeName).push().setValue(score);
    }
}
