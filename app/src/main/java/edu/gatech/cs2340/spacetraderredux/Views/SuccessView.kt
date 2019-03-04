package edu.gatech.cs2340.spacetraderredux.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import edu.gatech.cs2340.spacetraderredux.Model.Game
import edu.gatech.cs2340.spacetraderredux.Model.Player
import edu.gatech.cs2340.spacetraderredux.R

class SuccessView : AppCompatActivity() {
    //TODO: fix
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_view)
        val intent = intent
        val successText = findViewById<View>(R.id.successTextView) as TextView
        val exitButton = findViewById<View>(R.id.exitButton) as Button
        exitButton.setOnClickListener {
            val intent = Intent(applicationContext, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("EXIT", true)
            startActivity(intent)
        }

        Game.reinitialize()
        successText.text = Game.instance.player.toString()
        Game.instance.universe.dumpToLog()
    }
}
