package edu.gatech.cs2340.spacetraderredux.Views

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import java.util.Collections
import java.util.HashMap

import edu.gatech.cs2340.spacetraderredux.Model.Difficulty
import edu.gatech.cs2340.spacetraderredux.Model.Player
import edu.gatech.cs2340.spacetraderredux.Model.SkillType
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.ViewModels.ConfigurationViewModel
import kotlinx.android.synthetic.main.activity_configuration.*
import kotlinx.android.synthetic.main.configuration_containers.view.*

class ConfigurationActivity : AppCompatActivity() {
    private var mViewModel: ConfigurationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)
        mViewModel = ViewModelProviders.of(this).get(ConfigurationViewModel::class.java!!)
        difficulty_buttons.labelText.text = "Difficulty"
        difficulty_buttons.valueText.text = "EASY"
        pilot_buttons.labelText.text = "Pilot:"
        engineer_buttons.labelText.text = "Enginer:"
        trader_buttons.labelText.text = "Trader:"
        fighter_buttons.labelText.text = "Fighter:"
        submitButton.setOnClickListener {
            mViewModel!!.setName(characterName.text.toString())
            if (mViewModel!!.validPlayer()) {
                Toast.makeText(this@ConfigurationActivity, "Creating valid player", Toast.LENGTH_SHORT).show()
                val s = mViewModel!!.createPlayer()
                val activityChangeIntent = Intent(this@ConfigurationActivity, SuccessView::class.java)
                activityChangeIntent.putExtra("playerData", s)
                activityChangeIntent.putExtra("gameData", mViewModel!!.createGameDataBundle())
                this@ConfigurationActivity.startActivity(activityChangeIntent)
            } else {
                Toast.makeText(this@ConfigurationActivity, "Invalid User Input", Toast.LENGTH_SHORT).show()


            }
        }
    }

    /**
     * Processes a decrement button being clicked, updating the corresponding difficulty or skillpoint.
     * @param view the view the event happened in.
     */
    fun downClicked(view: View) {
        val parentView = view.parent as View
        val labelText = parentView.findViewById<View>(R.id.valueText) as TextView
        val remainingText = findViewById<View>(R.id.totalPoints) as TextView
        if (parentView.id == R.id.difficulty_buttons) {
            mViewModel!!.decDifficulty()
            labelText.text = mViewModel!!.difficulty.toString()
        } else if (parentView.id == R.id.pilot_buttons) {
            mViewModel!!.decPoints(SkillType.PILOT)
            labelText.text = Integer.toString(mViewModel!!.pilot)
        } else if (parentView.id == R.id.fighter_buttons) {
            mViewModel!!.decPoints(SkillType.FIGHTER)
            labelText.text = Integer.toString(mViewModel!!.fighter)
        } else if (parentView.id == R.id.trader_buttons) {
            mViewModel!!.decPoints(SkillType.TRADER)
            labelText.text = Integer.toString(mViewModel!!.trader)
        } else if (parentView.id == R.id.engineer_buttons) {
            mViewModel!!.decPoints(SkillType.ENGINEER)
            labelText.text = Integer.toString(mViewModel!!.engineer)

        }
        remainingText.text = mViewModel!!.remaining.toString();
    }

    /**
     * Processes an increment button being clicked, updating the corresponding difficulty or skillpoint.
     * @param view the view the event happened in.
     */
    fun upClicked(view: View) {
        val parentView = view.parent as View
        val labelText = parentView.findViewById<View>(R.id.valueText) as TextView
        val remainingText = findViewById<View>(R.id.totalPoints) as TextView
        if (parentView.id == R.id.difficulty_buttons) {
            mViewModel!!.incDifficulty()
            labelText.text = mViewModel!!.difficulty.toString()
        } else if (parentView.id == R.id.pilot_buttons) {
            mViewModel!!.incPoints(SkillType.PILOT)
            labelText.text = Integer.toString(mViewModel!!.pilot)
        } else if (parentView.id == R.id.fighter_buttons) {
            mViewModel!!.incPoints(SkillType.FIGHTER)
            labelText.text = Integer.toString(mViewModel!!.fighter)
        } else if (parentView.id == R.id.trader_buttons) {
            mViewModel!!.incPoints(SkillType.TRADER)
            labelText.text = Integer.toString(mViewModel!!.trader)
        } else if (parentView.id == R.id.engineer_buttons) {
            mViewModel!!.incPoints(SkillType.ENGINEER)
            labelText.text = Integer.toString(mViewModel!!.engineer)

        }
        remainingText.text = mViewModel!!.remaining.toString()
    }
}
