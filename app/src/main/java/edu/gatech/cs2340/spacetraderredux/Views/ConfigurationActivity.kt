package edu.gatech.cs2340.spacetraderredux.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import edu.gatech.cs2340.spacetraderredux.Model.Difficulty

import edu.gatech.cs2340.spacetraderredux.Model.SkillType
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.Presenters.ConfigurationPresenter
import kotlinx.android.synthetic.main.activity_configuration.*
import kotlinx.android.synthetic.main.configuration_containers.view.*

class ConfigurationActivity : AppCompatActivity(), ConfigurationPresenter.View {

    private var presenter: ConfigurationPresenter = ConfigurationPresenter(this)

    private lateinit var difficultyTextView: TextView
    private lateinit var buttonIdToSkillType: Map<Int, SkillType>
    private lateinit var skillTypeToTextView: Map<SkillType, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        difficultyTextView = difficulty_buttons.findViewById(R.id.valueText) as TextView

        buttonIdToSkillType = mapOf(
                R.id.pilot_buttons to SkillType.PILOT,
                R.id.engineer_buttons to SkillType.ENGINEER,
                R.id.trader_buttons to SkillType.TRADER,
                R.id.fighter_buttons to SkillType.FIGHTER)

        skillTypeToTextView = mapOf(
                SkillType.PILOT to pilot_buttons.findViewById(R.id.valueText),
                SkillType.ENGINEER to engineer_buttons.findViewById(R.id.valueText),
                SkillType.TRADER to trader_buttons.findViewById(R.id.valueText),
                SkillType.FIGHTER to fighter_buttons.findViewById(R.id.valueText)
        )

        difficulty_buttons.labelText.text = "Difficulty"
        difficulty_buttons.valueText.text = "EASY"
        pilot_buttons.labelText.text = "Pilot:"
        engineer_buttons.labelText.text = "Enginer:"
        trader_buttons.labelText.text = "Trader:"
        fighter_buttons.labelText.text = "Fighter:"

        submitButton.setOnClickListener { presenter.onSubmit() }
    }

    override fun updateDifficulty(difficulty: Difficulty) {
        difficultyTextView.text = difficulty.name
    }

    override fun updateSkillPoints(type: SkillType, points: Int) {
        skillTypeToTextView.getValue(type).text = points.toString()
    }

    override fun updateRemainingSkillPoints(remainingSkillPoints: Int) {
        totalPoints.text = remainingSkillPoints.toString()
    }

    override fun displayInvalidPlayerNameError() {
        Toast.makeText(this@ConfigurationActivity, "Player name is empty", Toast.LENGTH_SHORT).show()
    }

    override fun displaySkillPointsRemainingError() {
        Toast.makeText(this@ConfigurationActivity, "Unallocated skill points remaining", Toast.LENGTH_SHORT).show()
    }

    override fun goToNextView() {
        Toast.makeText(this@ConfigurationActivity, "Creating valid player", Toast.LENGTH_SHORT).show()
        val activityChangeIntent = Intent(this@ConfigurationActivity, SuccessView::class.java)
        this@ConfigurationActivity.startActivity(activityChangeIntent)
    }

    /**
     * Processes a decrement button being clicked, updating the corresponding difficulty or skillpoint.
     * @param view the view the event happened in.
     */
    fun downClicked(view: View) {
        val parentView = view.parent as View
        if (parentView.id == R.id.difficulty_buttons) {
            presenter.onDecrementDifficulty()
        } else {
            presenter.onDecrementSkillType(buttonIdToSkillType.getValue(parentView.id))
        }
    }

    /**
     * Processes an increment button being clicked, updating the corresponding difficulty or skillpoint.
     * @param view the view the event happened in.
     */
    fun upClicked(view: View) {
        val parentView = view.parent as View
        if (parentView.id == R.id.difficulty_buttons) {
            presenter.onIncrementDifficulty()
        } else {
            presenter.onIncrementSkillType(buttonIdToSkillType.getValue(parentView.id))
        }
    }
}
