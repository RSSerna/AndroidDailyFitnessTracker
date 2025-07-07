package com.example.dailyfitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText stepsInput; // Declare an EditText variable to capture user input for steps

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepsInput = findViewById(R.id.steps_input); // Initialize the EditText for steps input
        Button calculateCaloriesButton = findViewById(R.id.calculate_calories_button); // Initialize the button for calculation

        // Set an OnClickListener for the calculate button
        calculateCaloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stepsText = stepsInput.getText().toString(); // Get the text input from the user
                if (stepsText.isEmpty()) { // Check if the input is empty
                    Toast.makeText(MainActivity.this, "Please enter your steps", Toast.LENGTH_SHORT).show(); // Show a toast message
                } else {
                    // Convert the steps text to an integer
                    int steps = Integer.parseInt(stepsText);

                    // Create an Intent to start the CaloriesActivity
                    Intent intent = new Intent(MainActivity.this, CaloriesActivity.class);

                    // Add the steps value to the Intent as an extra
                    intent.putExtra("steps", steps); // "steps" is the key, and steps is the value

                    // Start the CaloriesActivity
                    startActivity(intent);
                }
            }
        });
    }
}