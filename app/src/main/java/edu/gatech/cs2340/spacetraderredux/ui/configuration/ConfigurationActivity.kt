package edu.gatech.cs2340.spacetraderredux.ui.configuration

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Space
import android.widget.TextView
import android.widget.Toast

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SkillType
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.SpaceTraderGlobal
import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.ui.SuccessView
import edu.gatech.cs2340.spacetraderredux.ui.tradespec.Trade
import edu.gatech.cs2340.spacetraderredux.ui.tradespec.TradeSpecification
import kotlinx.android.synthetic.main.activity_configuration.*
import kotlinx.android.synthetic.main.configuration_containers.view.*

class ConfigurationActivity : AppCompatActivity(), ConfigurationView{

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
                SkillType.FIGHTER to fighter_buttons.findViewById(R.id.valueText))

        characterName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.onPlayerNameChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        characterName.setText(presenter.playerConfiguration.playerName)
        updateDifficulty(presenter.playerConfiguration.playerDifficulty)
        difficulty_buttons.labelText.text = "Difficulty"
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

    override fun configurationSuccess(game: Game) {
        Toast.makeText(this@ConfigurationActivity, "Creating valid player", Toast.LENGTH_SHORT).show()
        var global = getApplication() as SpaceTraderGlobal
        global.game = game
        val activityChangeIntent = Intent(this@ConfigurationActivity, Trade::class.java)
        this@ConfigurationActivity.startActivity(activityChangeIntent)
        this.finish()
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
