package edu.gatech.cs2340.spacetraderredux.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.ui.configuration.ConfigurationActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val button = findViewById<View>(R.id.newGame) as Button
        button.setOnClickListener {
            // Perform action on click
            val activityChangeIntent = Intent(this@SplashActivity,
                    ConfigurationActivity::class.java)

            // currentContext.startActivity(activityChangeIntent);

            this@SplashActivity.startActivity(activityChangeIntent)
        }
        continueGame.setOnClickListener {
            val activityChangeIntent = Intent(this@SplashActivity,
                    SystemInfoActivity::class.java)
            this@SplashActivity.startActivity(activityChangeIntent)
        }
        if (intent.getBooleanExtra("EXIT", false)) {   // To be removed...
            finish()
        }
    }


}
