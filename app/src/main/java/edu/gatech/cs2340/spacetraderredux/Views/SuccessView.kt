package edu.gatech.cs2340.spacetraderredux.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import edu.gatech.cs2340.spacetraderredux.Model.Difficulty
import edu.gatech.cs2340.spacetraderredux.Model.GameInstance
import edu.gatech.cs2340.spacetraderredux.Model.Player
import edu.gatech.cs2340.spacetraderredux.R

class SuccessView : AppCompatActivity() {
    private var gameInstance: GameInstance? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_view)
        val intent = intent
        val successText = findViewById<View>(R.id.successTextView) as TextView
        successText.text = intent.getStringExtra("playerData")
        val exitButton = findViewById<View>(R.id.exitButton) as Button
        exitButton.setOnClickListener {
            val intent = Intent(applicationContext, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("EXIT", true)
            startActivity(intent)
        }

        val gameData = intent.getBundleExtra("gameData")
        val stats = gameData.getIntArray("playerStats")
        val playerName = gameData.getString("playerName")
        val difficultyValue = gameData.getInt("difficulty")
        val difficulty = Difficulty.values()[difficultyValue]
        gameInstance = GameInstance(Player(playerName!!, stats!![0], stats[1], stats[2], stats[3]), difficulty)
        gameInstance!!.universe.dumpToLog()

    }
}
