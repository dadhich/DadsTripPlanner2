package com.example.dadstripplanner

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TripOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_options)

        // Get source and destination from the intent
        val source = intent.getStringExtra("source") ?: "Lowe Rd opp James Park"
        val destination = intent.getStringExtra("destination") ?: "Hornsby Station"

        // Set the trip banner
        val tripBanner = findViewById<TextView>(R.id.tripBanner)
        tripBanner.text = "Trip from $source to $destination"

        // Hardcoded trip options data (matching the screenshot)
        val tripOptions = listOf(
            TripOption("26 mins", "10:44 am", "10:42", "running 2 mins late", "#FFA500", "575", "10:53 am"),
            TripOption("26 mins", "1:42 am", "1:40", "running 2 mins late", "#FFA500", "575", "10:53 am"),
            TripOption("54 mins", "11:12 am", "11:12", "On time", "#00FF00", "575", "11:21 am"),
            TripOption("84 mins", "11:42 am", "11:42", "On time", "#00FF00", "575", "11:51 am"),
            TripOption("2 hrs", "12:12 pm", "", "Real-time data unavailable", "#FFFFFF", "575", "12:21 pm")
        ).sortedBy { it.etaMinutes() } // Sort by ETA

        // Populate trip options
        findViewById<TextView>(R.id.tripOption1Eta).text = tripOptions[0].eta
        findViewById<TextView>(R.id.tripOption1Arrival).text = tripOptions[0].arrivalTime
        findViewById<TextView>(R.id.tripOption1Timetable).text = tripOptions[0].timetableTime
        findViewById<TextView>(R.id.tripOption1Status).text = tripOptions[0].status
        findViewById<View>(R.id.tripOption1StatusBox).setBackgroundColor(android.graphics.Color.parseColor(tripOptions[0].statusColor))
        findViewById<TextView>(R.id.tripOption1Route).text = tripOptions[0].route

        findViewById<TextView>(R.id.tripOption2Eta).text = tripOptions[1].eta
        findViewById<TextView>(R.id.tripOption2Arrival).text = tripOptions[1].arrivalTime
        findViewById<TextView>(R.id.tripOption2Timetable).text = tripOptions[1].timetableTime
        findViewById<TextView>(R.id.tripOption2Status).text = tripOptions[1].status
        findViewById<View>(R.id.tripOption2StatusBox).setBackgroundColor(android.graphics.Color.parseColor(tripOptions[1].statusColor))
        findViewById<TextView>(R.id.tripOption2Route).text = tripOptions[1].route

        findViewById<TextView>(R.id.tripOption3Eta).text = tripOptions[2].eta
        findViewById<TextView>(R.id.tripOption3Arrival).text = tripOptions[2].arrivalTime
        findViewById<TextView>(R.id.tripOption3Timetable).text = tripOptions[2].timetableTime
        findViewById<TextView>(R.id.tripOption3Status).text = tripOptions[2].status
        findViewById<View>(R.id.tripOption3StatusBox).setBackgroundColor(android.graphics.Color.parseColor(tripOptions[2].statusColor))
        findViewById<TextView>(R.id.tripOption3Route).text = tripOptions[2].route

        findViewById<TextView>(R.id.tripOption4Eta).text = tripOptions[3].eta
        findViewById<TextView>(R.id.tripOption4Arrival).text = tripOptions[3].arrivalTime
        findViewById<TextView>(R.id.tripOption4Timetable).text = tripOptions[3].timetableTime
        findViewById<TextView>(R.id.tripOption4Status).text = tripOptions[3].status
        findViewById<View>(R.id.tripOption4StatusBox).setBackgroundColor(android.graphics.Color.parseColor(tripOptions[3].statusColor))
        findViewById<TextView>(R.id.tripOption4Route).text = tripOptions[3].route

        findViewById<TextView>(R.id.tripOption5Eta).text = tripOptions[4].eta
        findViewById<TextView>(R.id.tripOption5Arrival).text = tripOptions[4].arrivalTime
        findViewById<TextView>(R.id.tripOption5Status).text = tripOptions[4].status
        findViewById<TextView>(R.id.tripOption5Route).text = tripOptions[4].route

        // Back button functionality
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}

data class TripOption(
    val eta: String,
    val arrivalTime: String,
    val timetableTime: String,
    val status: String,
    val statusColor: String,
    val route: String,
    val expectedArrival: String
) {
    fun etaMinutes(): Int {
        return when {
            eta.endsWith("mins") -> eta.replace(" mins", "").toIntOrNull() ?: Int.MAX_VALUE
            eta.endsWith("hrs") -> (eta.replace(" hrs", "").toIntOrNull() ?: 0) * 60
            else -> Int.MAX_VALUE
        }
    }
}