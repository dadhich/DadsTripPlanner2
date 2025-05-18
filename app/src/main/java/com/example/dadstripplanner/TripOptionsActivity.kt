package com.example.dadstripplanner

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TripOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_options)

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            finish() // Return to the previous activity
        }
    }
}