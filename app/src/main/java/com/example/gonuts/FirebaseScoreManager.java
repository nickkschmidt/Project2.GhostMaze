package com.example.gonuts;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Manages score data in the Firebase Realtime Database.
 *
 * This class provides methods to interact with the Firebase Realtime Database
 * for storing and retrieving score data.
 */

public class FirebaseScoreManager {

    private final FirebaseDatabase database;
    private static DatabaseReference scoresRef;

    /**
     * Constructs a new FirebaseScoreManager instance.
     *
     * Initializes the Firebase database and obtains a reference to the "Scores"
     * node in the database.
     */
    public FirebaseScoreManager() {
        // Initialize Firebase
        database = FirebaseDatabase.getInstance();

        // Get reference to the "scores" node in the database
        scoresRef = database.getReference("Scores");
    }

    /**
     * Adds a score to the specified node in the Firebase database.
     *
     * @param nodeName The name of the node in which to add the score.
     * @param score The score to be added to the database.
     */
    public void addScorefire(String nodeName, int score) {
        scoresRef.child(nodeName).push().setValue(score);
    }
}
