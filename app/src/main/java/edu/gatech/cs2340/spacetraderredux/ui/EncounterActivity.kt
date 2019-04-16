package edu.gatech.cs2340.spacetraderredux.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.gatech.cs2340.spacetraderredux.R

class EncounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encounter)
    }

    fun attackClicked(view : View) {
        val activityChangeIntent = Intent(this@EncounterActivity, EncounterDialog::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }
}
