package com.example.dadstripplanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinationInput = findViewById<EditText>(R.id.destinationInput)
        val sourceInput = findViewById<EditText>(R.id.sourceInput)
        val currentLocation = findViewById<RadioButton>(R.id.currentLocation)
        val customLocation = findViewById<RadioButton>(R.id.customLocation)
        val sourceGroup = findViewById<RadioGroup>(R.id.sourceGroup)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Toggle source input visibility based on radio button
        sourceGroup.setOnCheckedChangeListener { _, checkedId ->
            sourceInput.visibility =
                if (checkedId == R.id.customLocation) android.view.View.VISIBLE else android.view.View.GONE
        }

        // Placeholder for Next button (to be implemented later)
        nextButton.setOnClickListener {
            // Add navigation logic here later
        }
    }
}