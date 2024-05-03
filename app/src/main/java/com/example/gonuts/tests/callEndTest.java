package com.example.gonuts.tests;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static org.junit.Assert.*;

import com.example.gonuts.MainActivity;
import com.example.gonuts.R;

import org.junit.Before;
import org.junit.Test;

public class callEndTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testCallEnd() {
        // Call the method
        activity.callEnd();

        // Verify that scoreTextView is set with the correct text
        TextView scoreTextView = activity.findViewById(R.id.scoreTextView);
        assertEquals("Score: " + activity.score, scoreTextView.getText());

        Button buttonReset = activity.findViewById(R.id.buttonreset);
        assertNotNull(buttonReset);
    }
}
